package app.api.addAttachmentTestRail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attachment {
    @JsonProperty("id")
    private int id;
}
