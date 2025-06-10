package finalmission.dto.request;

import finalmission.domain.Member;
import finalmission.domain.Role;

public record MemberCreateRequest(
        String name,
        String email,
        String password,
        Role role
) {
    public Member toDomain() {
        return Member.withoutId(name, email, password, role);
    }
}
