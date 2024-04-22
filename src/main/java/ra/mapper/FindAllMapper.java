package ra.mapper;

import lombok.Builder;
import org.springframework.stereotype.Component;
import ra.dto.response.FindAllResponse;
import ra.model.Category;
@Component
public class FindAllMapper implements GenericMapper<Category,Category, FindAllResponse>{

    @Override
    public Category mapperRequestToEntity(Category category) {
        return null;
    }

    @Override
    public FindAllResponse mapperEntityToResponse(Category category) {
        return new FindAllResponse(category.getCatalogId(),
                category.getCatalogName(), category.getDescriptions(),
                category.isStatus());
    }
}
