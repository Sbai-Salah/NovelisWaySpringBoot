package io.novelis.springbootnovelisstyle2.api.resource;

import io.novelis.springbootnovelisstyle2.service.ProductService;
import io.novelis.springbootnovelisstyle2.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.net.URI;
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(Pageable pageable)
    {
        return ResponseEntity.ok(productService.findAll(pageable));
    }



    @PostMapping
    public void SaveProduct(@RequestBody ProductDto productDto){
        productService.save(productDto);
    }



}
