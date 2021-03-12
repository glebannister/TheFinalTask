package app.api.enums;

public enum  RunAssignedToEnum {
    ME (1);
    private final int valueOfAssignedTo;

    RunAssignedToEnum(int valueOfAssignedTo) {
        this.valueOfAssignedTo = valueOfAssignedTo;
    }

    public int getValueOfAssignedTo() {
        return valueOfAssignedTo;
    }
}
