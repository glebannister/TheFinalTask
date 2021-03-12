package app.ui.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewTest {
    private final String name;
    private final String status;
    private final String method;
    private final String startTime;
    private final String endTime;
    private final String environment;
    private final String browser;
    private final String pathToScreenshot;
}
