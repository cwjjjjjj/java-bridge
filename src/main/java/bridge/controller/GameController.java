package bridge.controller;

import bridge.BridgeGame;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
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
        User user = new User();
        while (true) {

            OutputView.printMovingSpaceMessage();
            boolean isMoving = bridgeGame.move(bridge, location, InputView.readMoving());
            if (isMoving) {
                location++;
                printUserRoute(user, bridge);
            }

            if (!isMoving) {
                printUserRoute(user, bridge);
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

    private void printUserRoute(User user, Bridge bridge) {
        List<String> upRoute = user.getUpRoute();
        List<String> downRoute = user.getDownRoute();
        OutputView.printMapStart();
        for (int i = 0; i < upRoute.size(); i++) {
            OutputView.printMap(upRoute.get(i));
            if (i != upRoute.size()-1) {
                OutputView.printMapStep();
            }
        }
        for (int i = 0; i < downRoute.size(); i++) {
            OutputView.printMap(downRoute.get(i));
            if (i != downRoute.size()-1) {
                OutputView.printMapStep();
            }
        }
        OutputView.printMapEnd();

    }
}
