package app.api.addSuiteTestRail;

import framework.utils.PropertyReader;

public class AddSuiteBuilder {
    private String parameters;

    public AddSuiteBuilder() {
        this.parameters = "";
    }

    public AddSuiteBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddSuiteBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddSuiteBuilder addSuiteEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addSuiteEndpoint");
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
