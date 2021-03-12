package app.api.addRunTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Run {
    @JsonProperty("id")
    private int id;

    @JsonProperty("assignedto_id")
    private int assignedtoId;

    @JsonProperty("blocked_count")
    private int blockedCount;

    @JsonProperty("completed_on")
    private Timestamp completedOn;

    @JsonProperty("config")
    private String config;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("config_ids")
    private List<Integer> configIds = new ArrayList<>();

    @JsonProperty("created_on")
    private Timestamp createdOn;

    @JsonProperty("custom_status?_count")
    private int count;

    @JsonProperty("description")
    private String description;

    @JsonProperty("failed_count")
    private int failedCount;

    @JsonProperty("include_all")
    private boolean includeAll;

    @JsonProperty("is_completed")
    private boolean isCompleted;

    @JsonProperty("milestone_id")
    private int milestoneId;

    @JsonProperty("plan_id")
    private int planId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("passed_count")
    private int passedCount;

    @JsonProperty("project_id")
    private int projectId;

    @JsonProperty("retest_count")
    private int retestCount;

    @JsonProperty("suite_id")
    private int suiteId;

    @JsonProperty("untested_count")
    private int untestedCount;

    @JsonProperty("updated_on")
    private Timestamp updatedOn;

    @JsonProperty("url")
    private String url;

    @JsonProperty("refs")
    private String refs;

    @JsonProperty("custom_status1_count")
    private int customStatus1Count;

    @JsonProperty("custom_status2_count")
    private int customStatus2Count;

    @JsonProperty("custom_status3_count")
    private int customStatus3Count;

    @JsonProperty("custom_status4_count")
    private int customStatus4Count;

    @JsonProperty("custom_status5_count")
    private int customStatus5Count;

    @JsonProperty("custom_status6_count")
    private int customStatus6Count;

    @JsonProperty("custom_status7_count")
    private int customStatus7Count;
}
