package app.api.getToken;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;

public class TokenRequest {

    public static TokenResponse getToken(Token sendingPost){
        LogUtil.info("Getting token");
        String URL = new TokenGetBuilder()
                .apiBaseUrl()
                .tokenEndpoint()
                .getEndpoint()
                .variant(sendingPost.getVariant())
                .build();
        LogUtil.info(URL);
        HttpResponse<String> result = APIUtil.post(
                URL,
                JsonUtil.toJsonString(sendingPost),
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                RequestHeaderConstants.HEADER_VALUE_APPLICATION_JSON);
        LogUtil.info(String.format("Response body %s", result.body()));
        return getTokenResponse(result);
    }

    private static TokenResponse getTokenResponse(HttpResponse<String> result){
        return new TokenResponse(
                APIUtil.getResponseStatusCode(result),
                result.body(),
                BaseRequest.getContentType(result));
    }
}
