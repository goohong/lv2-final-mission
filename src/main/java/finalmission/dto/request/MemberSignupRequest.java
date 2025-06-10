package finalmission.dto.request;

public record MemberSignupRequest(
        String name,
        String email,
        String password
) {
}
