package bridge.controller;

import bridge.BridgeGame;
import bridge.model.*;
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
        int bridgeSize;
        while(true) {
            try {
                bridgeSize = Integer.parseInt(InputView.readBridgeSize());
                break;
            } catch (NumberFormatException e) {
                OutputView.printErrorMessage(ErrorMessage.INVALID_SIZE_INPUT.getMessage());
            }
        }
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(makeBridge);

        int location = 0;
        User user = new User();
        boolean isSuccess = false;
        int numberOfTrial = 1;
        while (true) {
            if (location == bridgeSize) {
                isSuccess = true;
                break;
            }
            OutputView.printMovingSpaceMessage();
            String userMoving;
            while (true) {
                try {
                    userMoving = InputView.readMoving();
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(ErrorMessage.INVALID_UD_INPUT.getMessage());
                }
            }
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
                String restartingInput;
                while (true) {
                    try {
                        restartingInput = InputView.readGameCommand();
                        break;
                    } catch (IllegalArgumentException e) {
                        OutputView.printErrorMessage(ErrorMessage.INVALID_RESTART_INPUT.getMessage());
                    }
                }
                boolean isRestart = bridgeGame.retry(restartingInput);
                if (isRestart) {
                    numberOfTrial++;
                    location = 0;
                    user = new User();
                }
                if (!isRestart) {
                    break;
                }
            }
        }
        result(user, isSuccess, numberOfTrial);
    }

    private void printUserRoute(User user) {
        List<String> upRoute = user.getUpRoute();
        List<String> downRoute = user.getDownRoute();
        printEachRoute(upRoute);
        printEachRoute(downRoute);
    }

    private static void printEachRoute(List<String> upRoute) {
        OutputView.printMapStart();
        for (int i = 0; i < upRoute.size(); i++) {
            OutputView.printMap(upRoute.get(i));
            if (i != upRoute.size()-1) {
                OutputView.printMapStep();
            }
        }
        OutputView.printMapEnd();
    }

    private void result(User user, boolean isSuccess, int numberOfTrial) {
        OutputView.printResult();
        printUserRoute(user);
        if(isSuccess) {
            OutputView.printEndingMessage("성공", numberOfTrial);
        }
        if(!isSuccess) {
            OutputView.printEndingMessage("실패", numberOfTrial);
        }
    }
}
