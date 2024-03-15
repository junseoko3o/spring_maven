package kr.co.hanbit.model;

public class Product {
    private Long id;
    private String name;
    private Integer price;

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
}
