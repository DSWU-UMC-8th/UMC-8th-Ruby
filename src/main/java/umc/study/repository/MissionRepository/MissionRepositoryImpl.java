package umc.study.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QRegion;
import umc.study.domain.QStore;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findHomeMissions(Long regionId, LocalDate lastDeadline) {
        QMission m = QMission.mission;
        QStore s = QStore.store;
        QRegion r = QRegion.region;

        return queryFactory.selectFrom(m)
                .join(m.store, s).fetchJoin()
                .join(s.region, r).fetchJoin()
                .where(
                        r.id.eq(regionId),
                        m.deadline.gt(lastDeadline)
                )
                .orderBy(m.deadline.asc())
                .limit(15)
                .fetch();
    }
}
