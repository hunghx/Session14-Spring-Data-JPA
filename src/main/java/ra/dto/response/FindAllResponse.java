package ra.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FindAllResponse {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean status;
}
