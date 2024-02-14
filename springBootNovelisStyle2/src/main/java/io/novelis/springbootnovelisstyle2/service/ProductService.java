package io.novelis.springbootnovelisstyle2.service;

import io.novelis.springbootnovelisstyle2.dao.ProductDao;
import io.novelis.springbootnovelisstyle2.domain.Product;
import io.novelis.springbootnovelisstyle2.service.dto.ProductDto;
import io.novelis.springbootnovelisstyle2.service.exception.BusinessException;
import io.novelis.springbootnovelisstyle2.service.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final ProductMapper productMapper;
    @Transactional(readOnly = true)
    public ProductDto getById(Long id){
        // we can use instead of 404 : HttpStatus.NOT_FOUND
return productMapper.toDto(productDao.getById(id).orElseThrow(()->new BusinessException(404, "product.not.found", "product not found")));
    }


    @Transactional(readOnly = true)
    public List<ProductDto> findAll(Pageable pageable)
    {
        return productMapper.toDto(productDao.findAll(pageable));
    }

    @Transactional
    public void save(ProductDto product){
        productDao.save(productMapper.toEntity(product));
    }




}
