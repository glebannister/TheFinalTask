package app.api.addResultTestRail;

import framework.utils.PropertyReader;

public class AddResultBuilder {
    private String parameters;

    public AddResultBuilder() {
        this.parameters = "";
    }

    public AddResultBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddResultBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddResultBuilder addResultEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addResultEndpoint");
        return this;
    }

    public AddResultBuilder testId(int testId) {
        this.parameters += String.valueOf(testId);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
