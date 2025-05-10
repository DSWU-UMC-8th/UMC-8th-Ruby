package umc.study.repository.MemberMissionRepository;

import umc.study.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findActiveMissionsByMember(Long memberId, LocalDateTime lastUpdatedAt);
}