package kr.co.hanbit.controller;

import kr.co.hanbit.dto.ProductDto;
import kr.co.hanbit.service.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final SimpleProductService simpleProductService;
    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody() ProductDto productDto) {
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }
}
