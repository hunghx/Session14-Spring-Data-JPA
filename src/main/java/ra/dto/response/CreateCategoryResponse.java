package ra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class CreateCategoryResponse {
    private int catalogId;
    private String catalogName;
    private Date created;
    private boolean status;
}
