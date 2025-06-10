package finalmission.service;

import finalmission.domain.Member;
import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.response.MemberResponse;
import finalmission.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse create(MemberCreateRequest request) {
        Member savedMember = memberRepository.save(request.toDomain());
        return MemberResponse.from(savedMember);
    }
}
