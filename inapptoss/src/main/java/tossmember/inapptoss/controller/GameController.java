package tossmember.inapptoss.controller;

import jakarta.persistence.EntityListeners;
import lombok.NoArgsConstructor;

public class GameController {
}
@NoArgsConstructor(acceess = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
