package tossmember.inapptoss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tossmember.inapptoss.dto.StageProgress;
import tossmember.inapptoss.service.StageService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stage")
@CrossOrigin(origins = "*", allowCredentials = "false")
public class StageController {

    @Autowired
    private StageService stageService;

    // 스테이지 진입 가능 여부 확인
    @GetMapping("/can-enter")
    public ResponseEntity<Map<String, Object>> canEnterStage(
            @RequestParam String playerId,
            @RequestParam int stageNumber
    ) {
        boolean canEnter = stageService.canEnterStage(playerId, stageNumber);

        Map<String, Object> response = new HashMap<>();
        response.put("playerId", playerId);
        response.put("stageNumber", stageNumber);
        response.put("canEnter", canEnter);

        if (canEnter) {
            response.put("message", "스테이지 " + stageNumber + " 진입 가능");
        } else {
            response.put("message", "스테이지 " + stageNumber + " 진입 불가 (이미 클리어했거나 유효하지 않은 스테이지 입니다.");
        }

        return ResponseEntity.ok(response);
    }

    // 스테이지 클리어 처리
    @PostMapping("/clear")
    public ResponseEntity<Map<String, Object>> clearStage(
            @RequestParam String playerId,
            @RequestParam int stageNumber
    ) {
        boolean success = stageService.clearStage(playerId, stageNumber);

        Map<String, Object> response = new HashMap<>();
        response.put("playerId", playerId);
        response.put("stageNumber", stageNumber);
        response.put("success", success);

        if (success) {
            response.put("message", "스테이지 " + stageNumber + " 클리어 완료");
            response.put("clearedStages", stageService.getProgress(playerId).getClearedStages());
            response.put("remainingStages", stageService.getRemainingStages(playerId));
            response.put("allStagesCleared", stageService.isAllStagesCleared(playerId));
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "클리어 했거나 열리지 않은 스테이지입니다.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 플레이어의 전체 스테이지 클리어 정보 조회
    @GetMapping("/progress/{playerId")
    public ResponseEntity<Map<String, Object>> getStageProgress(@PathVariable String playerId) {
        StageProgress progress = stageService.getProgress(playerId);

        Map<String, Object> response = new HashMap<>();
        response.put("playerId", playerId);
        response.put("clearedStages", progress.getClearedStages());
        response.put("totalStages", stageService.getTotalStages());
        response.put("remainingStages", stageService.getRemainingStages(playerId));
        response.put("allStagesCleared", stageService.isAllStagesCleared(playerId));
        response.put("message", "스테이지 진행 정보 조회");

        return  ResponseEntity.ok(response);
    }

    // 스테이지 클리어 상태 전체 리셋 (선택 기능)
    @PostMapping("/reset/{playerId}")
    public ResponseEntity<Map<String, Object>> resetStageProgress(@PathVariable String playerId) {
        stageService.resetProgress(playerId);

        Map<String, Object> response = new HashMap<>();
        response.put("playerId", playerId);
        response.put("clearedStages", stageService.getProgress(playerId).getClearedStages());
        response.put("totalStages", stageService.getTotalStages());
        response.put("message", "스테이지가 초기화 되었습니다.");

        return ResponseEntity.ok(response);
    }
}
