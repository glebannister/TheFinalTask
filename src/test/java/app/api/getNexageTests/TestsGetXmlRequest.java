package app.api.getNexageTests;

import app.api.baseRequest.BaseRequest;
import app.api.constants.RequestHeaderConstants;
import framework.utils.APIUtil;
import framework.utils.LogUtil;
import framework.utils.XmlUtil;
import java.net.http.HttpResponse;

public class TestsGetXmlRequest {
    public static TestsResponseNexage getTestsXml(Tests sendingPost){
        LogUtil.info("Getting token");
        String URL = new TestGetXmlBuilder()
                .apiBaseUrl()
                .testEndpoint()
                .getEndpoint()
                .xmlEndpoint()
                .projectId(sendingPost.getProjectId())
                .build();
        LogUtil.info(URL);
        HttpResponse<String> result = APIUtil.post(
                URL,
                XmlUtil.toXmlString(sendingPost),
                RequestHeaderConstants.CONTENT_TYPE_HEADER_KEY,
                RequestHeaderConstants.HEADER_VALUE_APPLICATION_XML);
        LogUtil.info(String.format("Response body %s", result.body()));
        return getTestsResponse(result);
    }

    private static TestsResponseNexage getTestsResponse(HttpResponse<String> result){
        return new TestsResponseNexage(
                APIUtil.getResponseStatusCode(result),
                result.body(),
                BaseRequest.getContentType(result));
    }
}
