package app.api.addCaseTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CaseResponse {
    private final int statusCode;
    private final Case aCase;
    private final List<String> contentType;
}
