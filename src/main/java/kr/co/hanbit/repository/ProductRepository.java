package kr.co.hanbit.repository;

import kr.co.hanbit.model.Product;

import java.util.List;

public interface ProductRepository {
    Product add(Product product);
    Product findById(Long id);
    List<Product> findAll();
    List<Product> findByNameContaining(String name);
    Product update(Product product);
    void delete(Long id);

    // 클래스에 의존하던걸 해당 인터페이스에 의존하도록 변경함.
    // 구체적인 존재가 아닌 추상적인 존재에 의존하도록 함으로써 애플리케이션의 동작을 코드 변경 없이, 실행 시점에 결정할 수 있다.
}
