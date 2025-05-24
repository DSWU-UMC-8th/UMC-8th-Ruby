package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.controller.dto.StoreRequestDTO;
import umc.study.web.controller.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store) {
        return new StoreResponseDTO.CreateResultDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getScore(),
                store.getRegion().getName()
        );
    }
}
