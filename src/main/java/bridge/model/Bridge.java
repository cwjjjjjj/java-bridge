package bridge.model;

import java.util.List;

public class Bridge {

    private List<String> bridgeState;
    private int size;

    public Bridge(List<String> bridgeState, int size) {
        this.bridgeState = bridgeState;
        this.size = size;
    }

    public List<String> getBridgeState() {
        return bridgeState;
    }
}
