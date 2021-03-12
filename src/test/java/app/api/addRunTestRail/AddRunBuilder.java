package app.api.addRunTestRail;

import framework.utils.PropertyReader;

public class AddRunBuilder {
    private String parameters;

    public AddRunBuilder() {
        this.parameters = "";
    }

    public AddRunBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddRunBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddRunBuilder addRunEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addRunEndpoint");
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
