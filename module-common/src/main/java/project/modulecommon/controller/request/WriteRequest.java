package project.modulecommon.controller.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteRequest {
    private String title;
    private String body;
}
