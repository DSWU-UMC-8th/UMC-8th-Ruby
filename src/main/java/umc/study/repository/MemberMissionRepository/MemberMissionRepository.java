package umc.study.repository.MemberMissionRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}