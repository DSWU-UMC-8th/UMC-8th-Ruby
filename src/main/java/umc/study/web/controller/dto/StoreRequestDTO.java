package umc.study.web.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateDto {
        @NotBlank
        private String name;

        @NotBlank
        private String address;

        @NotNull
        private Float score;

        @NotNull
        private Long regionId;
    }

}
