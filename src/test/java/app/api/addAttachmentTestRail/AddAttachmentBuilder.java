package app.api.addAttachmentTestRail;

import framework.utils.PropertyReader;

public class AddAttachmentBuilder {
    private String parameters;

    public AddAttachmentBuilder() {
        this.parameters = "";
    }

    public AddAttachmentBuilder baseUrl() {
        this.parameters += PropertyReader.getTestRailValue("testRailBaseUrl");
        return this;
    }

    public AddAttachmentBuilder version() {
        this.parameters += PropertyReader.getTestRailValue("testRailVersion");
        return this;
    }

    public AddAttachmentBuilder addAttachmentEndpoint() {
        this.parameters += PropertyReader.getTestRailValue("addAttachmentEndpoint");
        return this;
    }

    public AddAttachmentBuilder resultId(int resultId) {
        this.parameters += String.valueOf(resultId);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
