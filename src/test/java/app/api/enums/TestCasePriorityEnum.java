package app.api.enums;

public enum TestCasePriorityEnum {
    DONT_TEST_5 (1),
    TEST_IF_TIME_4 (2),
    TEST_IF_TIME_3 (3),
    MUST_TEST_2 (4),
    MUST_TEST_1 (5);
    private final int valueOfPriority;

    TestCasePriorityEnum(int valueOfPriority) {
        this.valueOfPriority = valueOfPriority;
    }

    public int getValueOfPriority() {
        return valueOfPriority;
    }
}
