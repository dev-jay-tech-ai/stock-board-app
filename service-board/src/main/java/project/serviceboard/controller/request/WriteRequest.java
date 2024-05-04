package project.serviceboard.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteRequest {
    private String title;
    private String body;
    private String stockId;
}
