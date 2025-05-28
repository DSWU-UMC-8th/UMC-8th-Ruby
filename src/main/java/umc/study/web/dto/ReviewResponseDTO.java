package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ReviewResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class CreateResultDTO {
        private Long id;
        private String body;
        private Float score;
        private String storeName;
        private String memberName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberReviewDTO {
        private String nickname;
        private Long storeId;
        private LocalDate createdAt;
        private Float score;
        private String body;
    }

}
