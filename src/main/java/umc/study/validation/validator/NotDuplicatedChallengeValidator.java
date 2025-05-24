package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.validation.annotation.NotDuplicatedChallenge;
import umc.study.web.controller.dto.ChallengeRequestDTO;

@Component
@RequiredArgsConstructor
public class NotDuplicatedChallengeValidator implements ConstraintValidator<NotDuplicatedChallenge, ChallengeRequestDTO.CreateDto> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(ChallengeRequestDTO.CreateDto dto, ConstraintValidatorContext context) {
        if (dto == null || dto.getMemberId() == null || dto.getMissionId() == null) return true;

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addConstraintViolation();
        }

        return !exists;
    }
}
