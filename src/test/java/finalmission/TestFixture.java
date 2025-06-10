package finalmission;

import finalmission.domain.Role;
import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.request.ReservationCreateRequest;
import finalmission.dto.request.ReservationTimeCreateRequest;
import finalmission.dto.request.SportCreateRequest;
import finalmission.dto.response.MemberResponse;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestFixture {
    public static String testToken =
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwibmFtZSI6IkRhbm55Iiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzQ5NTQxNzE1LCJleHAiOjE3NDk5MDE3MTV9.gZW0DfZjkwQzJIw0JtWcWpyGsO9naCA8WnwwGAlILTw";

    public static ReservationCreateRequest reservationCreateRequest = new ReservationCreateRequest(
            LocalDate.now().plusDays(1),
            1L,
            1L,
            1L
    );

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
            "password",
            Role.ADMIN
    );

    public static MemberResponse expectedMemberResponse = new MemberResponse(
            1L,
            "Danny",
            "danny@example.com"
    );
}
