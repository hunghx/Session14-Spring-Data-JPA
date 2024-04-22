package ra.mapper;

import org.springframework.stereotype.Component;
import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.model.Category;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class CreateCategoryMapper implements GenericMapper<CreateCategoryRequest, Category, CreateCategoryResponse>{
    @Override
    public Category mapperRequestToEntity(CreateCategoryRequest createCategoryRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        Date created = null;
        try {
            created = sdf.parse(sdf.format(now));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //Category: name, description, created
        Category categoryEntity = Category.builder().catalogName(createCategoryRequest.getCatalogName())
                .descriptions(createCategoryRequest.getDescriptions())
                .created(created).build();
        return categoryEntity;
    }

    @Override
    public CreateCategoryResponse mapperEntityToResponse(Category category) {
        return new CreateCategoryResponse(category.getCatalogId(),category.getCatalogName(),
                category.getCreated(),category.isStatus());
    }
}
