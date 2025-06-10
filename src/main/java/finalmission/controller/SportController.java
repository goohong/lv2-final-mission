package finalmission.controller;

import finalmission.dto.request.SportCreateRequest;
import finalmission.dto.response.SportResponse;
import finalmission.service.SportService;
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
@RequestMapping("/sports")
public class SportController {

    private final SportService sportService;

    public SportController(final SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping
    public ResponseEntity<List<SportResponse>> getAllReservations() {
        return ResponseEntity.ok(sportService.getAll());
    }

    @PostMapping
    public ResponseEntity<SportResponse> createReservation(@RequestBody SportCreateRequest request) {
        SportResponse response = sportService.create(request);
        return ResponseEntity.created(URI.create("times/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable("id") Long id) {
        sportService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }
}
