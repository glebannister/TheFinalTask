package app.api.getTestTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Tests {
    @JsonProperty("assignedto_id")
    private int assignedtoId;

    @JsonProperty("case_id")
    private int caseId;

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

    @JsonProperty("run_id")
    private int runId;

    @JsonProperty("status_id")
    private int statusId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type_id")
    private int type_id;

    @JsonProperty("template_id")
    private int templateId;

    @JsonProperty("custom_automation_type")
    private String customAutomationType;

    @JsonProperty("custom_qa_status_terumo")
    private String customQaStatusTerumo;

    @JsonProperty("custom_descriprion")
    private String customDescriprion;

    @JsonProperty("custom_preconds")
    private String customPreconds;

    @JsonProperty("custom_steps_separated")
    private String customStepsSeparated;

    @JsonProperty("custom_expected")
    private String customExpected;
}
