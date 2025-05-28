package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateDto request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.CreateResultDto toCreateResultDTO(Mission mission) {
        return new MissionResponseDTO.CreateResultDto(
                mission.getId(),
                mission.getReward(),
                mission.getDeadline(),
                mission.getMissionSpec(),
                mission.getStore().getName()
        );
    }

    public static MissionResponseDTO.MissionPreviewDTO toPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO toPreviewListDTO(Page<Mission> missions) {
        List<MissionResponseDTO.MissionPreviewDTO> dtoList = missions.stream()
                .map(MissionConverter::toPreviewDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missions.isLast())
                .isFirst(missions.isFirst())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .listSize(dtoList.size())
                .missions(dtoList)
                .build();
    }
}
