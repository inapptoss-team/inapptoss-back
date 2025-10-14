package tossmember.inapptoss.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = 'puzzles')
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Puzzles {
    @Id
    @Column(name = 'id')
    private Long id;

    @Column(name = 'stage_id')
    @JoinColumn(name = 'stage_id', foreignkey = @ForeignKey(name = 'fk_puzzles_stage_id'))
    private Long stage_id;

    @Column(name = 'map_id')
    @JoinColumn(name = 'map_id', foreignkey= @ForeignKey(name = 'fk_puzzles_map_id'))
    private Long map_id;

    @Column(name = 'puzzle_id')
    private String puzzle_id;

    @Column(name = 'answer')
    private String answer;

    @Column(name = 'state')
    private Boolean state;

    Puzzle puzzle(Long id, Long stage_id, Long map_id, String puzzle_id, String answer, BOOLEAN state) {
        this.id = id;
        this.stage_id = stage_id;
        this.map_id = map_id;
        this.puzzle_id = puzzle_id;
        this.answer = answer;
        this.state = state;
    }
}
