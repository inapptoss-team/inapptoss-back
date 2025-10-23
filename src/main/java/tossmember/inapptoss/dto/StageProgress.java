package tossmember.inapptoss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StageProgress {

    private String playerId;
    private Set<Integer> clearedStages;

    public StageProgress() {
        this.clearedStages = new HashSet<>();
    }

    public StageProgress(String playerId) {
        this();
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Set<Integer> getClearedStages() {
        return clearedStages;
    }

    public void setClearedStages(Set<Integer> clearedStages) {
        this.clearedStages = clearedStages;
    }

}
