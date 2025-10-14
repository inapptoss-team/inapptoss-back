package tossmember.inapptoss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PuzzleRepository extends JpaRepository<Puzzles, Long> {
    // puzzle_id로 퍼즐 찾기
    Optional<Puzzles> findByPuzzleId(String puzzleId);
}
