package app.api.enums;

public enum ResultStatusIdEnum {
    PASSED (1),
    BLOCKED (2),
    RETEST (3),
    FAILED (4),
    PASSED_WITH_ISSUES (5),
    NOT_IMPLEMENTED (6);
    private final int valueOfStatus;

    ResultStatusIdEnum(int valueOfStatus) {
        this.valueOfStatus = valueOfStatus;
    }

    public int getValueOfStatus() {
        return valueOfStatus;
    }
}
