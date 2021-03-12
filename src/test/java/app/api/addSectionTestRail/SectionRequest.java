package app.api.addSectionTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;

public class SectionRequest {

    public static SectionResponse sendPost(Section sendingPost, String login, String password) {
        LogUtil.info("Creating section");
        String URL = new AddSectionBuilder()
                .baseUrl()
                .version()
                .addSectionEndpoint()
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
        return new SectionResponse(
                APIUtil.getResponseStatusCode(result),
                JsonUtil.fromJsonString(APIUtil.getResponseBody(result), Section.class),
                BaseRequest.getContentType(result));
    }
}
