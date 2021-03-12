package app.api.getTestTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class TestsRequest {

    public static TestsResponse getTests(int runId, String login, String password) {
        LogUtil.info("Getting tests");
        String URL = new GetTestsBuilder()
                .baseUrl()
                .version()
                .addSectionEndpoint()
                .runId(runId)
                .build();
        LogUtil.info(URL);
        HttpResponse<String> result = APIUtil.getWithAuth(
                URL,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_AUTH,
                login,
                password,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                RequestHeaderConstants.HEADER_VALUE_APPLICATION_JSON);
        return new TestsResponse(
                APIUtil.getResponseStatusCode(result),
                Arrays.asList(JsonUtil.fromJsonStringAsArray(APIUtil.getResponseBody(result), Tests[].class)),
                BaseRequest.getContentType(result));
    }
}
