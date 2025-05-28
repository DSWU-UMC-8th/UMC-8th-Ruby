package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.NotDuplicatedChallenge;

public class ChallengeRequestDTO {

    @Getter
    @NotDuplicatedChallenge
    public static class CreateDto {

        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}