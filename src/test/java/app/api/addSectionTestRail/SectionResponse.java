package app.api.addSectionTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SectionResponse {
    private final int statusCode;
    private final Section section;
    private final List<String> contentType;
}
