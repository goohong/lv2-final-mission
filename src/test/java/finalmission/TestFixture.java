package finalmission;

import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.request.ReservationTimeCreateRequest;
import finalmission.dto.response.MemberResponse;
import java.time.LocalTime;

public class TestFixture {
    public static ReservationTimeCreateRequest reservationTimeCreateRequest = new ReservationTimeCreateRequest(
            LocalTime.of(12, 0)
    );

    public static MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
            "Danny",
            "danny@example.com",
            "password"
    );

    public static MemberResponse expectedMemberResponse = new MemberResponse(
            1L,
            "Danny",
            "danny@example.com"
    );
}
