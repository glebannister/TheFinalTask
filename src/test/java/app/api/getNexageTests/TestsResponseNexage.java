package app.api.getNexageTests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TestsResponseNexage {
    private final int statusCode;
    private final String tests;
    private final List<String> contentType;
}
