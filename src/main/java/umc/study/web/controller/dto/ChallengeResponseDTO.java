package umc.study.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ChallengeResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class CreateResultDto {
        private Long id;
        private Long memberId;
        private Long missionId;
        private String status;
    }
}
