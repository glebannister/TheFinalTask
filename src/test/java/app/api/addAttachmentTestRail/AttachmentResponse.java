package app.api.addAttachmentTestRail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AttachmentResponse {
    private final int statusCode;
    private final Attachment attachment;
    private final List<String> contentType;
}
