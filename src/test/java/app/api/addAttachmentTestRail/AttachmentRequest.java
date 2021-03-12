package app.api.addAttachmentTestRail;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.JsonUtil;
import framework.utils.LogUtil;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class AttachmentRequest {

    public static AttachmentResponse sendPost(int resultId, String login, String password, Path pathToFile) {
        LogUtil.info("Creating attachment");
        String URL = new AddAttachmentBuilder()
                .baseUrl()
                .version()
                .addAttachmentEndpoint()
                .resultId(resultId)
                .build();
        LogUtil.info(URL);
        HttpResponse<String> result = APIUtil.postImageWithAuth(
                URL,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_AUTH,
                login,
                password,
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                String.format("%s",
                        RequestHeaderConstants.HEADER_VALUE_MULTIPART_FROM_DATA +
                        RequestHeaderConstants.HEADER_VALUE_BOUNDARY),
                pathToFile);
        LogUtil.info(String.format("Request body %s", result.body()));
        return new AttachmentResponse(
                APIUtil.getResponseStatusCode(result),
                JsonUtil.fromJsonString(APIUtil.getResponseBody(result), Attachment.class),
                BaseRequest.getContentType(result));
    }
}
