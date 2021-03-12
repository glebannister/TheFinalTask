package app.api.addResultTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;

public class ResultRequest {

    public static ResultResponse sendPost(int testId, Result sendingPost, String login, String password) {
        LogUtil.info("Creating result");
        String URL = new AddResultBuilder()
                .baseUrl()
                .version()
                .addResultEndpoint()
                .testId(testId)
                .build();
        LogUtil.info(URL);
        HttpResponse<String> result = APIUtil.postWithAuth(
                URL,
                JsonUtil.toJsonString(sendingPost),
                RequestHeaderConstants.CONTENT_TYPE_HEADER_AUTH,
                login,
                password,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                RequestHeaderConstants.HEADER_VALUE_APPLICATION_JSON);
        LogUtil.info(String.format("Request body %s", result.body()));
        return new ResultResponse(
                APIUtil.getResponseStatusCode(result),
                JsonUtil.fromJsonString(APIUtil.getResponseBody(result), Result.class),
                BaseRequest.getContentType(result));
    }
}
