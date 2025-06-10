package finalmission.service;

import finalmission.domain.Sport;
import finalmission.dto.request.SportCreateRequest;
import finalmission.dto.response.SportResponse;
import finalmission.exception.NotFoundException;
import finalmission.repository.SportRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SportService {
    private final SportRepository sportRepository;

    public SportService(final SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public SportResponse create(SportCreateRequest request) {
        Sport savedSport = sportRepository.save(request.toDomain());
        return SportResponse.from(savedSport);
    }

    public void removeReservation(final Long id) {
        if (!sportRepository.existsById(id)) {
            throw new NotFoundException();
        }
        sportRepository.deleteById(id);
    }

    public List<SportResponse> getAll() {
        return sportRepository.findAll().stream()
                .map(SportResponse::from)
                .toList();
    }
}
