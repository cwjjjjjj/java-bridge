package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.text.html.parser.Parser;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        return input();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String input = input();
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String input = input();
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static String input() {
        return Console.readLine();
    }
}
