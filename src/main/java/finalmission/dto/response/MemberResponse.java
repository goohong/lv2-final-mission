package finalmission.dto.response;

import finalmission.domain.Member;

public record MemberResponse(
        Long id,
        String name,
        String email,
        String password
) {
    public static MemberResponse from(final Member savedMember) {
        return new MemberResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail(),
                savedMember.getPassword()
        );
    }
}
