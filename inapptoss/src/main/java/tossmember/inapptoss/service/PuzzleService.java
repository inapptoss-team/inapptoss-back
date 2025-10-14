package tossmember.inapptoss.service;

public class PuzzleService {
    public Puzzle puzzle (puzzle_id, user_result) {
        String str = repository.findAnswer(puzzle_id)
        if (user_result.equals(str))
        {
            puzzles.state = 1;
            return (TRUE);
        }
        else
            return (FALSE);
    }
}
