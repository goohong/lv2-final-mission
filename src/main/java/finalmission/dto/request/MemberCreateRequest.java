package finalmission.dto.request;

import finalmission.domain.Member;

public record MemberCreateRequest(
   String name,
   String email,
   String password
) {
    public Member toDomain() {
        return Member.withoutId(name, email, password);
    }
}
