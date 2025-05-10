package umc.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.study.domain.Member;
import umc.study.domain.QMember;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findMemberProfile(Long memberId) {
        QMember m = QMember.member;

        return Optional.ofNullable(queryFactory.selectFrom(m)
                .where(m.id.eq(memberId))
                .fetchOne());
    }
}