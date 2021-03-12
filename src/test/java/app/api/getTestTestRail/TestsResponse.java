package app.api.getTestTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TestsResponse {
    private final int statusCode;
    private final List<Tests> tests;
    private final List<String> contentType;
}
