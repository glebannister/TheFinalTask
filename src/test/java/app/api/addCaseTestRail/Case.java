package app.api.addCaseTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Case {
    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("created_on")
    private Timestamp createdOn;

    @JsonProperty("estimate")
    private Timestamp estimate;

    @JsonProperty("estimate_forecast")
    private Timestamp estimateForecast;

    @JsonProperty("id")
    private int id;

    @JsonProperty("milestone_id")
    private int milestoneId;

    @JsonProperty("priority_id")
    private int priorityId;

    @JsonProperty("refs")
    private String refs;

    @JsonProperty("section_id")
    private int sectionId;

    @JsonProperty("suite_id")
    private int suiteId;

    @JsonProperty("template_id")
    private int templateId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type_id")
    private int typeId;

    @JsonProperty("updated_by")
    private int updatedBy;

    @JsonProperty("updated_on")
    private Timestamp updatedOn;
}
