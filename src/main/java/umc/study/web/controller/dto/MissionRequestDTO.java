package umc.study.web.controller.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.study.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateDto {

        @Min(value = 1)
        private Integer reward;

        @Future
        private LocalDate deadline;

        @NotBlank
        private String missionSpec;

        @ExistStore
        private Long storeId;
    }
}
