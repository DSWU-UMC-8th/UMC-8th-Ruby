package umc.study.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class MissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class CreateResultDto {
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private String storeName;
    }
}
