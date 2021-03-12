package app.api.getToken;

import framework.utils.PropertyReader;

public class TokenGetBuilder {
    private String parameters;

    public TokenGetBuilder() {
        this.parameters = "";
    }

    public TokenGetBuilder apiBaseUrl() {
        this.parameters += PropertyReader.getAppApiValue("apiBaseUrl");
        return this;
    }

    public TokenGetBuilder tokenEndpoint() {
        this.parameters += PropertyReader.getAppApiValue("tokenEndpoint");
        return this;
    }

    public TokenGetBuilder getEndpoint() {
        this.parameters += PropertyReader.getAppApiValue("getEndpoint");
        return this;
    }

    public TokenGetBuilder variant(String variant){
        this.parameters += String.format("?variant=%s",  variant);
        return this;
    }

    public String build() {
        String fullUri = "";
        fullUri += parameters;
        return fullUri;
    }
}
