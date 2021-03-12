package app.api.addSuiteTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SuiteResponse {
    private final int statusCode;
    private final Suite suite;
    private final List<String> contentType;
}
