package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

import static bridge.view.OutputView.printBridgeSizeMessage;
import static bridge.view.OutputView.printStartMessage;

public class GameController {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        printStartMessage();
        printBridgeSizeMessage();
        int bridgeSize = InputView.readBridgeSize();
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(makeBridge, bridgeSize);
    }
}
