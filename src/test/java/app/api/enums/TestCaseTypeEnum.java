package app.api.enums;

public enum TestCaseTypeEnum {
    AUTOMATED (1),
    FUNCTIONALITY (2),
    GUI (3),
    OTHER (4),
    PERFORMANCE (5),
    REGRESSION (6),
    USABILITY (7);
    private final int valueOfType;

    TestCaseTypeEnum(int valueOfType) {
        this.valueOfType = valueOfType;
    }

    public int getValueOfType() {
        return valueOfType;
    }
}
