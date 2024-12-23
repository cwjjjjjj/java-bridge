package bridge;

import bridge.model.Bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Bridge bridge, int bridgeIndex, String userChoice) {
        String bridgeSingleState = bridge.getBridgeSingleState(bridgeIndex);
        return bridgeSingleState.equals(userChoice);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restartingInput) {
        if (restartingInput.equals("R")) {
            return true;
        }
        if (restartingInput.equals("Q")) {
            return false;
        }
        return false;
    }
}
