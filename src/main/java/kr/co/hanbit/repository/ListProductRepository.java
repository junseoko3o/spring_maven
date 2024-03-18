package kr.co.hanbit.repository;

import kr.co.hanbit.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListProductRepository {
    private final List<Product> products = new CopyOnWriteArrayList<>();
    // 멀티쓰레드 환경때문에 스레드세이프한 컬렉션을 사용해야함.
    private final AtomicLong sequence = new AtomicLong();

    public Product add(Product product) {
        product.setId(sequence.getAndAdd(1L));
        products.add(product);
        return product;
    }
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
}
