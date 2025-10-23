package tossmember.inapptoss.service;

import org.springframework.stereotype.Service;
import tossmember.inapptoss.dto.StageProgress;

import java.util.HashMap;
import java.util.Map;

@Service
public class StageService {

    private static final int TOTAL_STAGES = 3;
    private Map<String, StageProgress> progressMap = new HashMap<>();

    // 스테이지 진입 가능 여부 확인
    public boolean canEnterStage(String playerId, int stageNumber) {
        // 스테이지 번호가 1~3 범위가 벗어나면 false
        if (stageNumber < 1 || stageNumber > TOTAL_STAGES) {
            return  false;
        }

        StageProgress progress = getProgress(playerId);
        // 이미 클리어한 스테이지는 진입 불가
        return !progress.getClearedStages().contains(stageNumber);
    }

    // 스테이지 클리어 처리
    public boolean clearStage(String playerId, int stageNumber) {
        // 스테이지 번호가 유효하지 않으면 false
        if (stageNumber < 1 || stageNumber > TOTAL_STAGES) {
            return false;
        }

        stage
    }

    public StageProgress getProgress(String playerId) {
    }

    public Object getRemainingStages(String playerId) {
    }

    public Object isAllStagesCleared(String playerId) {
    }

    public Object getTotalStages() {
    }

    public void resetProgress(String playerId) {
    }
}
