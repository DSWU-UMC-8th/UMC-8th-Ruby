package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ChallengeConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.ChallengeService.ChallengeCommandService;
import umc.study.web.controller.dto.ChallengeRequestDTO;
import umc.study.web.controller.dto.ChallengeResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class ChallengeRestController {

    private final ChallengeCommandService challengeCommandService;

    @PostMapping("/")
    public ApiResponse<ChallengeResponseDTO.CreateResultDto> challengeMission(
            @RequestBody @Valid ChallengeRequestDTO.CreateDto request) {

        MemberMission mm = challengeCommandService.challengeMission(request);
        return ApiResponse.onSuccess(ChallengeConverter.toCreateResultDto(mm));
    }
}
