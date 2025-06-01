package umc.study.service.ChallengeService;


import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.ChallengeRequestDTO;

public interface ChallengeCommandService {
    MemberMission challengeMission(ChallengeRequestDTO.CreateDto request);
    void completeMission(Long memberId, Long missionId);
}