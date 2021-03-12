package app.api.addSectionTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Section {
    @JsonProperty("depth")
    private int depth;

    @JsonProperty("description")
    private String description;

    @JsonProperty("display_order")
    private int display_order;

    @JsonProperty("id")
    private int id;

    @JsonProperty("parent_id")
    private Integer parentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("suite_id")
    private int suiteId;
}
