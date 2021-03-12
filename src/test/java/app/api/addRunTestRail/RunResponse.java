package app.api.addRunTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RunResponse {
    private final int statusCode;
    private final Run run;
    private final List<String> contentType;
}
