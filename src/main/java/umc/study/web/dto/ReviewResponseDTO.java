package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
}
