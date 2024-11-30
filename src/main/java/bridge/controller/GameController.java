package bridge.controller;

import bridge.BridgeGame;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.view.OutputView.printBridgeSizeMessage;
import static bridge.view.OutputView.printStartMessage;

public class GameController {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        printStartMessage();
        printBridgeSizeMessage();
        int bridgeSize = InputView.readBridgeSize();
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(makeBridge, bridgeSize);

        int location = 0;
        while (true) {
            OutputView.printMovingSpaceMessage();
            boolean isMoving = bridgeGame.move(bridge, location, InputView.readMoving());
            if (isMoving) {
                location++;
            }
            if (!isMoving) {
                OutputView.printGameRestartMessage();
                String restartingInput = InputView.readGameCommand();
                boolean isRestart = bridgeGame.retry(restartingInput);
                if (isRestart) {
                    location = 0;
                }
                if (!isRestart) {
                    break;
                }
            }
        }
    }
}
