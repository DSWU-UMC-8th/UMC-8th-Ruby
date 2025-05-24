package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.controller.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateDto request);
}

