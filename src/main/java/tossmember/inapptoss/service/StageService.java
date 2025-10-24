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
        StageProgress progress = getProgress(playerId);

        // 스테이지 번호가 1~3 범위가 벗어나면 false
        if (stageNumber < 1 || stageNumber > TOTAL_STAGES) {
            return  false;
        }

        // 이미 클리어한 스테이지는 진입 불가
        if (progress.getClearedStages().contains(stageNumber)) {
            return false;
        }

        // 다음에 도전할 수 있는 스테이지만 진입 허용
        int nextStage = progress.getClearedStages().size() + 1;

        return stageNumber == nextStage;
    }

    // 스테이지 클리어 처리
    public boolean clearStage(String playerId, int stageNumber) {
        // 스테이지 번호가 유효하지 않으면 false
        if (stageNumber < 1 || stageNumber > TOTAL_STAGES) {
            return false;
        }

        StageProgress progress = getProgress(playerId);

        // 이미 클리어한 스테이지면 false 반환
        if (progress.getClearedStages().contains(stageNumber)) {
            return  false;
        }
        progress.getClearedStages().add(stageNumber);
        return true;
    }

    // 플레이어 진행 상황 조회
    public StageProgress getProgress(String playerId) {
        return  progressMap.computeIfAbsent(playerId, StageProgress::new);
    }

    // 남은 스테이지 개수 반환
    public Object getRemainingStages(String playerId) {
        StageProgress progress = getProgress(playerId);
        return TOTAL_STAGES - progress.getClearedStages().size();
    }

    // 모든 스테이지를 클리어했는지 확인
    public Object isAllStagesCleared(String playerId) {
        StageProgress progress = getProgress(playerId);
        return  progress.getClearedStages().size() == TOTAL_STAGES;
    }

    // 전체 스테이지 개수 반환
    public Object getTotalStages() {
        return TOTAL_STAGES;
    }

    // 플레이어 진행 상황 초기화
    public void resetProgress(String playerId) {
        progressMap.put(playerId, new StageProgress(playerId));
    }
}
