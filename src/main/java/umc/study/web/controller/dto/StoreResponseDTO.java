package umc.study.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class StoreResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class CreateResultDTO {
        private Long id;
        private String name;
        private String address;
        private Float score;
        private String regionName;
    }
}
