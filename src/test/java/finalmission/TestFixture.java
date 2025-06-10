package finalmission;

import finalmission.dto.request.SportCreateRequest;
import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.request.ReservationTimeCreateRequest;
import finalmission.dto.response.MemberResponse;
import java.time.LocalTime;

public class TestFixture {
    public static ReservationTimeCreateRequest reservationTimeCreateRequest = new ReservationTimeCreateRequest(
            LocalTime.of(12, 0)
    );

    public static SportCreateRequest sportCreateRequest = new SportCreateRequest(
            "Soccer A",
            "Let's play soccer together!",
            5L
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
