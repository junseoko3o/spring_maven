package kr.co.hanbit.model;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private Integer price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    private Integer amount;

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }
    public Boolean containsName(String name) {
        return this.name.contains(name);
    }
}
