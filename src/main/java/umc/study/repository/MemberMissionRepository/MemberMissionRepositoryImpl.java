package umc.study.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMission> findActiveMissionsByMember(Long memberId, LocalDateTime lastUpdatedAt) {
        QMemberMission mm = QMemberMission.memberMission;

        return queryFactory.selectFrom(mm)
                .where(
                        mm.member.id.eq(memberId),
                        mm.status.in(MissionStatus.PROGRESS, MissionStatus.COMPLETE),
                        mm.updatedAt.lt(lastUpdatedAt)
                )
                .orderBy(mm.updatedAt.desc())
                .limit(15)
                .fetch();
    }
}
