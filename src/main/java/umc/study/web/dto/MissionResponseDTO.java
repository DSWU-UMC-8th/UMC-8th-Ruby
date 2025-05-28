package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

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

    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }

    @Getter
    @Builder
    public static class MissionPreviewListDTO {
        private boolean isLast;
        private boolean isFirst;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<MissionPreviewDTO> missions;
    }
}
