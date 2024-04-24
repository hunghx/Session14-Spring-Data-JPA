package ra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {

    private String name;
    private float price;
    private MultipartFile file;
    private int stock;
    private Integer categoryId;
}
