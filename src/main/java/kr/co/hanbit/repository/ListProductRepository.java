package kr.co.hanbit.repository;

import kr.co.hanbit.common.EntityNotFoundException;
import kr.co.hanbit.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListProductRepository implements ProductRepository {
    private final List<Product> products = new CopyOnWriteArrayList<>();
    // 멀티쓰레드 환경때문에 스레드세이프한 컬렉션을 사용해야함.
    private final AtomicLong sequence = new AtomicLong(1L);

    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product Not Found"));
    }
    public List<Product> findAll() {
        return products;
    }
    public Product add(Product product) {
        product.setId(sequence.getAndAdd(1L));
        products.add(product);
        return product;
    }
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Product> findByNameContaining(String name) {
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }
    public Product update(Product product) {
        int indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }

    public void delete(Long id) {
        Product product = this.findById(id);
        products.remove(product);
    }
}
