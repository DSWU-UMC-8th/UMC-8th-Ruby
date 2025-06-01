package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMyMissions(Long memberId, int page);
}