package app.api.addCaseTestRail;

import framework.utils.PropertyReader;

public class AddCaseBuilder {
    private String parameters;

    public AddCaseBuilder() {
        this.parameters = "";
    }

    public AddCaseBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddCaseBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddCaseBuilder addCaseEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addTestCaseEndpoint");
        return this;
    }

    public AddCaseBuilder sectionId(int sectionId) {
        this.parameters += String.valueOf(sectionId);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
