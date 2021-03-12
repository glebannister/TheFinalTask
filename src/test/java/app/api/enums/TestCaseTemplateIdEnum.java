package app.api.enums;

public enum TestCaseTemplateIdEnum {
    TEST_CASE (1);
    private final int valueOfTemplate;

    TestCaseTemplateIdEnum(int valueOfTemplate) {
        this.valueOfTemplate = valueOfTemplate;
    }

    public int getValueOfTemplate() {
        return valueOfTemplate;
    }
}
