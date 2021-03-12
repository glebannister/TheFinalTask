package app.api.baseRequest;

import app.api.constants.RegExpConstants;
import framework.utils.APIUtil;
import framework.utils.StringUtil;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class BaseRequest {

    public static List<String> getContentType(HttpResponse<String> result) {
        String contentTypesResponse = APIUtil.getContentTypeHeader(result).stream().findFirst().get();
        return Arrays.asList(
                StringUtil.replaceWithRegExpWithEmptyString(
                        contentTypesResponse,
                        RegExpConstants.SQUARE_BRACKETS
                ).split(RegExpConstants.SEMICOLON_AND_SPACE)
        );
    }
}
