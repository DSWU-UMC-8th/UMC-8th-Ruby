package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.ValidPage;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요. (10개 단위로 페이징)")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 ID, path variable 입니다"),
    })
    public ApiResponse<Page<ReviewResponseDTO.MemberReviewDTO>> getMyReviews(
            @PathVariable(name = "memberId") Long memberId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(
                reviewQueryService.getMyReviews(memberId, page - 1)
                        .map(ReviewConverter::toMemberReviewDTO)
        );
    }
}