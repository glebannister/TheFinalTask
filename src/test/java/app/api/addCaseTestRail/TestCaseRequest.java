package app.api.addCaseTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;

public class TestCaseRequest {

    public static CaseResponse sendPost(int sectionId, Case sendingPost, String login, String password) {
        LogUtil.info("Creating testCase");
        String URL = new AddCaseBuilder()
                .baseUrl()
                .version()
                .addCaseEndpoint()
                .sectionId(sectionId)
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
        return new CaseResponse(
                APIUtil.getResponseStatusCode(result),
                JsonUtil.fromJsonString(APIUtil.getResponseBody(result), Case.class),
                BaseRequest.getContentType(result));
    }
}
