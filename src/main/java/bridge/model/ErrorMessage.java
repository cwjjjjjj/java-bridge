package bridge.model;

public enum ErrorMessage {
    INVALID_SIZE_INPUT("숫자만 입력해주세요."),
    INVALID_UD_INPUT("U 또는 D만 입력해주세요."),
    INVALID_RESTART_INPUT("R 또는 Q만 입력해주세요."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
