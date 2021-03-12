package app.api.addRunTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;

public class RunRequest {

    public static RunResponse sendPost(Run sendingPost, String login, String password) {
        LogUtil.info("Creating run");
        String URL = new AddRunBuilder()
                .baseUrl()
                .version()
                .addRunEndpoint()
                .build();
        HttpResponse<String> result = APIUtil.postWithAuth(
                URL,
                JsonUtil.toJsonString(sendingPost),
                RequestHeaderConstants.CONTENT_TYPE_HEADER_AUTH,
                login,
                password,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                RequestHeaderConstants.HEADER_VALUE_APPLICATION_JSON);
        LogUtil.info(String.format("Request body %s", result.body()));
        return new RunResponse(
                APIUtil.getResponseStatusCode(result),
                JsonUtil.fromJsonString(APIUtil.getResponseBody(result), Run.class),
                BaseRequest.getContentType(result));
    }
}
