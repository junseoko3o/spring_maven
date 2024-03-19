package kr.co.hanbit.service;

import kr.co.hanbit.dto.ProductDto;
import kr.co.hanbit.model.Product;
import kr.co.hanbit.repository.DatabaseProductRepository;
import kr.co.hanbit.repository.ListProductRepository;
import kr.co.hanbit.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    //    private final ListProductRepository listProductRepository;
//    private final DatabaseProductRepository databaseProductRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;
    @Autowired
    SimpleProductService(ProductRepository productRepository, ModelMapper modelMapper, ValidationService validationService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }
    public ProductDto add(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);
        Product savedProduct = productRepository.add(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        return modelMapper.map(product, ProductDto.class);
    }
    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }
    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product updateProduct = productRepository.update(product);
        return modelMapper.map(updateProduct, ProductDto.class);
    }
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
