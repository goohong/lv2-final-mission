package finalmission.controller;

import finalmission.dto.request.ReservationTimeCreateRequest;
import finalmission.dto.response.ReservationTimeResponse;
import finalmission.service.ReservationTimeService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
public class ReservationTimeController {

    private final ReservationTimeService reservationTimeService;

    public ReservationTimeController(final ReservationTimeService reservationTimeService) {
        this.reservationTimeService = reservationTimeService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationTimeResponse>> getAllReservations() {
        return ResponseEntity.ok(reservationTimeService.getAll());
    }

    @PostMapping
    public ResponseEntity<ReservationTimeResponse> createReservation(@RequestBody ReservationTimeCreateRequest request) {
        ReservationTimeResponse response = reservationTimeService.create(request);
        return ResponseEntity.created(URI.create("times/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable("id") Long id) {
        reservationTimeService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }
}
