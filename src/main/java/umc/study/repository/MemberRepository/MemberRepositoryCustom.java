package umc.study.repository.MemberRepository;

import umc.study.domain.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findMemberProfile(Long memberId);
}