package bridge.model;

import java.util.List;

public class Bridge {

    private List<String> bridgeState;

    public Bridge(List<String> bridgeState) {
        this.bridgeState = bridgeState;
    }

    public String getBridgeSingleState(int index) {
        return bridgeState.get(index);
    }
}
