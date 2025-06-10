package finalmission;

import finalmission.dto.request.MemberCreateRequest;

public class TextFixture {
    public static MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
            "Danny",
            "danny@example.com",
            "password"
    );
}
