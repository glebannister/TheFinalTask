package app.ui.enums;

public enum TestStatus {
    PASSED("PASSED"),
    FAILED("FAILED"),
    SKIPPED("SKIPPED");
    private final String testStatus;

    TestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getTestStatus() {
        return testStatus;
    }
}
