package framework.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class APIUtil {
    public static final String CONTENT_TYPE_HEADER_KEY = "content-type";
    private static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=\"attachment\"; filename=\"";
    private static final String BASIC_AUTH = "Basic ";
    public static final String SLASH_N_SLASH_N_TWO_HYPHEN = "\n\n--";
    private static final String SLASH_R_SLASH_N = "\r\n";
    private static final String SLASH = "\"";
    private static final String SLASH_R_SLASH_N_SLASH_R_SLASH_N = "\r\n\r\n";
    private static final String TWO_HYPHEN_SLASH_R_SLASH_N = "--\r\n";
    private static final String SLASH_R_SLASH_N_TWO_HYPHEN = "\r\n--";
    private static final String COLON = ":";
    private static final String DOUBLE_HYPHEN = "--";
    private static final String BOUNDARY = String.format(
            "%s",
            DOUBLE_HYPHEN + RandomUtil.getLatinRandomString(27));

    public static HttpResponse<String> getWithAuth(
            String uri,
            String authType,
            String login,
            String password,
            String contentType,
            String typeValue)
    {
        HttpResponse<String> result = null;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header(authType, basicAuth(login, password))
                    .header(contentType, typeValue)
                    .GET()
                    .build();
            result = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            LogUtil.error(e.toString());
        }
        return result;
    }

    public static HttpResponse<String> postWithAuth(
            String uri,
            String body,
            String authType,
            String login,
            String password,
            String contentType,
            String typeValue)
    {
        HttpResponse<String> result = null;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header(authType, basicAuth(login, password))
                    .header(contentType, typeValue)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            result = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            LogUtil.error(e.toString());
        }
        return result;
    }

    public static HttpResponse<String> postImageWithAuth(
            String uri,
            String authType,
            String login,
            String password,
            String contentType,
            String typeValue,
            Path pathToFile)
    {
        HttpResponse<String> result = null;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header(authType, basicAuth(login, password))
                    .header(contentType, typeValue + BOUNDARY)
                    .POST(createBody(pathToFile, BOUNDARY))
                    .build();
            result = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            LogUtil.error(e.toString());
        }
        return result;
    }

    public static HttpResponse<String> post(String uri, String body, String contentType, String typeValue) {
        HttpResponse<String> result = null;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(uri))
                    .header(contentType, typeValue)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            result = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            LogUtil.error(e.toString());
        }
        return result;
    }

    public static <T> String getResponseBody(HttpResponse<T> response) {
        return (String) response.body();
    }

    public static <T> int getResponseStatusCode(HttpResponse<T> response) {
        return response.statusCode();
    }

    public static <T> List<String> getContentTypeHeader(HttpResponse<T> response) {
        return response.headers().allValues(CONTENT_TYPE_HEADER_KEY);
    }

    private static String basicAuth(String username, String password) {
        return String.format(
                "%s%s",
                APIUtil.BASIC_AUTH,
                Base64.getEncoder().encodeToString((username + APIUtil.COLON + password).getBytes()));
    }

    private static HttpRequest.BodyPublisher createBody(Path path, String boundary) {
        var byteArrays = new ArrayList<byte[]>();
        byteArrays.add((APIUtil.SLASH_N_SLASH_N_TWO_HYPHEN + boundary + APIUtil.SLASH_R_SLASH_N).getBytes());
        byteArrays.add((APIUtil.CONTENT_DISPOSITION + path.toString() + APIUtil.SLASH).getBytes());
        byteArrays.add((APIUtil.SLASH_R_SLASH_N_SLASH_R_SLASH_N).getBytes());
        try {
            byteArrays.add(Files.readAllBytes(path));
        } catch (IOException e) {
            LogUtil.error(e.toString());
        }
        byteArrays.add((APIUtil.SLASH_R_SLASH_N_TWO_HYPHEN + boundary + APIUtil.TWO_HYPHEN_SLASH_R_SLASH_N).getBytes());
        return HttpRequest.BodyPublishers.ofByteArrays(byteArrays);
    }
}
