package kr.co.hanbit.service;

import kr.co.hanbit.dto.ProductDto;
import kr.co.hanbit.model.Product;
import kr.co.hanbit.repository.DatabaseProductRepository;
import kr.co.hanbit.repository.ListProductRepository;
import kr.co.hanbit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    //    private final ListProductRepository listProductRepository;
//    private final DatabaseProductRepository databaseProductRepository;
    private final ProductRepository productRepository;
    private final ValidationService validationService;
    @Autowired
    SimpleProductService(ProductRepository productRepository, ValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::toDto)
                .toList();
    }
    public ProductDto add(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        validationService.checkValid(product);
        Product savedProduct = productRepository.add(product);
        return ProductDto.toDto(savedProduct);
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        return ProductDto.toDto(product);
    }
    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        return products.stream()
                .map(ProductDto::toDto)
                .toList();
    }
    public ProductDto update(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        Product updateProduct = productRepository.update(product);
        return ProductDto.toDto(updateProduct);
    }
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
