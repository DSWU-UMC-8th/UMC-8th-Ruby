package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.controller.dto.ChallengeResponseDTO;

public class ChallengeConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.PROGRESS)
                .build();
    }

    public static ChallengeResponseDTO.CreateResultDto toCreateResultDto(MemberMission mm) {
        return new ChallengeResponseDTO.CreateResultDto(
                mm.getId(),
                mm.getMember().getId(),
                mm.getMission().getId(),
                mm.getStatus().name()
        );
    }
}