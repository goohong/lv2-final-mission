package finalmission.service;

import finalmission.domain.ReservationTime;
import finalmission.dto.request.ReservationTimeCreateRequest;
import finalmission.dto.response.ReservationTimeResponse;
import finalmission.exception.NotFoundException;
import finalmission.repository.ReservationTimeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservationTimeService {
    private final ReservationTimeRepository reservationTimeRepository;

    public ReservationTimeService(final ReservationTimeRepository reservationTimeRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
    }

    public ReservationTimeResponse create(ReservationTimeCreateRequest request) {
        ReservationTime savedReservationTime = reservationTimeRepository.save(request.toDomain());
        return ReservationTimeResponse.from(savedReservationTime);
    }

    public void removeReservation(final Long id) {
        if (!reservationTimeRepository.existsById(id)) {
            throw new NotFoundException();
        }
        reservationTimeRepository.deleteById(id);
    }

    public List<ReservationTimeResponse> getAll() {
        return reservationTimeRepository.findAll().stream()
                .map(ReservationTimeResponse::from)
                .toList();
    }
}
