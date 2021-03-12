package app.api.getToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private final int statusCode;
    private final String token;
    private final List<String> contentType;
}
