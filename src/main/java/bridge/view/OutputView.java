package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final static String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String MOVING_SPACE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String GAME_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private final static String IS_SUCCEED_MESSAGE = "게임 성공 여부: ";
    private final static String NUMBER_OF_TRIAL_MESSAGE = "총 시도한 횟수: ";
    private final static String FORMAT_START = "[ ";
    private final static String FORMAT_END = " ]\n";
    private final static String FORMAT_STEP = " | ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printBridgeSizeMessage() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public static void printMovingSpaceMessage() {
        System.out.println(MOVING_SPACE_MESSAGE);
    }

    public static void printGameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String userState) {
        System.out.print(userState);
    }

    public static void printMapStart() {
        System.out.print(FORMAT_START);
    }

    public static void printMapEnd() {
        System.out.print(FORMAT_END);
    }

    public static void printMapStep() {
        System.out.print(FORMAT_STEP);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
