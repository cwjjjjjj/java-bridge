package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class GameController {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        int bridgeSize = InputView.readBridgeSize();
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(makeBridge, bridgeSize);
    }
}
