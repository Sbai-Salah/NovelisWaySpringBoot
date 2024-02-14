package io.novelis.springbootnovelisstyle2.service.mapper;

import io.novelis.springbootnovelisstyle2.domain.Product;
import io.novelis.springbootnovelisstyle2.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDto toDto(Product product);
    List<ProductDto> toDto(List<Product> product);

    Product toEntity(ProductDto productDto);

}
