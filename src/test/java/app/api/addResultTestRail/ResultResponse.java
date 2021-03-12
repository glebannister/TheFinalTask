package app.api.addResultTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResultResponse {
    private final int statusCode;
    private final Result result;
    private final List<String> contentType;
}
