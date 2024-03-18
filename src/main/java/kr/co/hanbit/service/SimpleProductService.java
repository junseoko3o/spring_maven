package kr.co.hanbit.service;

import kr.co.hanbit.dto.ProductDto;
import kr.co.hanbit.model.Product;
import kr.co.hanbit.repository.ListProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    private final ListProductRepository listProductRepository;
    private final ModelMapper modelMapper;
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = listProductRepository.add(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    public ProductDto findById(Long id) {
        Product product = listProductRepository.findById(id);
        return modelMapper.map(product, ProductDto.class);
    }

}
