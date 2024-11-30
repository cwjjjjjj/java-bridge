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
            if (location == bridgeSize) {

                break;
            }
            OutputView.printMovingSpaceMessage();
            String userMoving = InputView.readMoving();
            boolean isMoving = bridgeGame.move(bridge, location, userMoving);
            if (isMoving) {
                location++;
                if (userMoving.equals("U")) {
                    user.addUpRoute("O");
                    user.addDownRoute(" ");
                }
                if (userMoving.equals("D")) {
                    user.addUpRoute(" ");
                    user.addDownRoute("O");
                }
                printUserRoute(user);
            }
            if (!isMoving) {
                if (userMoving.equals("U")) {
                    user.addUpRoute("X");
                    user.addDownRoute(" ");
                }
                if (userMoving.equals("D")) {
                    user.addUpRoute(" ");
                    user.addDownRoute("X");
                }
                printUserRoute(user);
                OutputView.printGameRestartMessage();
                String restartingInput = InputView.readGameCommand();
                boolean isRestart = bridgeGame.retry(restartingInput);
                if (isRestart) {
                    location = 0;
                    user = new User();
                }
                if (!isRestart) {
                    break;
                }
            }
        }
    }

    private void printUserRoute(User user) {
        List<String> upRoute = user.getUpRoute();
        List<String> downRoute = user.getDownRoute();
        OutputView.printMapStart();
        for (int i = 0; i < upRoute.size(); i++) {
            OutputView.printMap(upRoute.get(i));
            if (i != upRoute.size()-1) {
                OutputView.printMapStep();
            }
        }
        OutputView.printMapEnd();
        OutputView.printMapStart();
        for (int i = 0; i < downRoute.size(); i++) {
            OutputView.printMap(downRoute.get(i));
            if (i != downRoute.size()-1) {
                OutputView.printMapStep();
            }
        }
        OutputView.printMapEnd();
    }
}
