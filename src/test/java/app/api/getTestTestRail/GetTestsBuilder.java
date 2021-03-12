package app.api.getTestTestRail;

import framework.utils.PropertyReader;

public class GetTestsBuilder {
    private String parameters;

    public GetTestsBuilder() {
        this.parameters = "";
    }

    public GetTestsBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public GetTestsBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public GetTestsBuilder addSectionEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("getTestsEndpoint");
        return this;
    }

    public GetTestsBuilder runId(int runId) {
        this.parameters += String.valueOf(runId);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
