package app.api.getNexageTests;

import framework.utils.PropertyReader;

public class TestGetXmlBuilder {
    private String parameters;

    public TestGetXmlBuilder() {
        this.parameters = "";
    }

    public TestGetXmlBuilder apiBaseUrl() {
        this.parameters += PropertyReader.getAppApiValue("apiBaseUrl");
        return this;
    }

    public TestGetXmlBuilder testEndpoint() {
        this.parameters += PropertyReader.getAppApiValue("testEndpoint");
        return this;
    }

    public TestGetXmlBuilder getEndpoint() {
        this.parameters += PropertyReader.getAppApiValue("getEndpoint");
        return this;
    }

    public TestGetXmlBuilder xmlEndpoint() {
        this.parameters += PropertyReader.getAppApiValue("xmlEndpoint");
        return this;
    }

    public TestGetXmlBuilder projectId(String projectId){
        this.parameters += String.format("?projectId=%s", projectId);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
