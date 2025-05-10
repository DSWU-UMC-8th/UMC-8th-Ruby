package umc.study.repository.MissionRepository;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findHomeMissions(Long regionId, LocalDate lastDeadline);
}