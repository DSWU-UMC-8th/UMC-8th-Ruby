package umc.study.converter;


import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDto request, Store store, Member member) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review) {
        return new ReviewResponseDTO.CreateResultDTO(
                review.getId(),
                review.getBody(),
                review.getScore(),
                review.getStore().getName(),
                review.getMember().getName()
        );
    }

}
