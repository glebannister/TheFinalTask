package app.api.addResultTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Result {
    @JsonProperty("status_id")
    private int statusId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("version")
    private String version;

    @JsonProperty("elapsed")
    private Timestamp elapsed;

    @JsonProperty("defects")
    private String defects;

    @JsonProperty("assignedto_id")
    private int assignedtoId;

    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("created_on")
    private int createdOn;

    @JsonProperty("custom_step_results")
    private String customStepResults;

    @JsonProperty("id")
    private int id;

    @JsonProperty("test_id")
    private int testId;

    @JsonProperty("attachment_ids")
    private int[] attachmentIds;
}
