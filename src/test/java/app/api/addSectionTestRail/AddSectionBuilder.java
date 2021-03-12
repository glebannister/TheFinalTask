package app.api.addSectionTestRail;

import framework.utils.PropertyReader;

public class AddSectionBuilder {
    private String parameters;

    public AddSectionBuilder() {
        this.parameters = "";
    }

    public AddSectionBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddSectionBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddSectionBuilder addSectionEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addSectionEndpoint");
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
