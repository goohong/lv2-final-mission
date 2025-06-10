package finalmission.service;

import finalmission.domain.Member;
import finalmission.domain.Reservation;
import finalmission.domain.ReservationTime;
import finalmission.domain.Sport;
import finalmission.dto.request.ReservationCreateRequest;
import finalmission.dto.response.ReservationResponse;
import finalmission.exception.NotFoundException;
import finalmission.repository.ReservationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final MemberService memberService;
    private final ReservationTimeService reservationTimeService;
    private final SportService sportService;

    public ReservationService(final ReservationRepository reservationRepository, final MemberService memberService,
                              final ReservationTimeService reservationTimeService, final SportService sportService) {
        this.reservationRepository = reservationRepository;
        this.memberService = memberService;
        this.reservationTimeService = reservationTimeService;
        this.sportService = sportService;
    }

    public ReservationResponse create(ReservationCreateRequest request) {
        Member member = memberService.find(request.memberId());
        ReservationTime time = reservationTimeService.find(request.timeId());
        Sport sport = sportService.find(request.sportId());

        Reservation savedReservation = reservationRepository.save(
                Reservation.withoutId(request.date(), member, sport, time));
        return ReservationResponse.from(savedReservation);
    }

    public void removeReservation(final Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new NotFoundException();
        }
        reservationRepository.deleteById(id);
    }

    public List<ReservationResponse> getAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationResponse::from)
                .toList();
    }
}
