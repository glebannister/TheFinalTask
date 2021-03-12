package app.api.addSuiteTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Suite {
    @JsonProperty("completed_on")
    private Timestamp completedOn;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private int id;

    @JsonProperty("is_baseline")
    private boolean isBaseline;

    @JsonProperty("is_completed")
    private boolean isCompleted;

    @JsonProperty("is_master")
    private boolean isMaster;

    @JsonProperty("name")
    private String name;

    @JsonProperty("project_id")
    private int projectId;

    @JsonProperty("url")
    private String url;
}
