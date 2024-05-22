package com.example.domain;

/**
 * お酒の商品情報を表すドメインです.
 *
 * @author haruka.yamaneki
 */
public class Item {
    /** ID */
    private Integer id;
    /** 商品名 */
    private String name;
    /** 産地 */
    private String productionArea;
    /** 商品画像 */
    private String image;
    /** 値段 */
    private String price;
    /** コメント */
    private String comment;

    public Item(){}

    public Item(Integer id, String name, String productionArea, String image, String price, String comment) {
        this.id = id;
        this.name = name;
        this.productionArea = productionArea;
        this.image = image;
        this.price = price;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionArea() {
        return productionArea;
    }

    public void setProductionArea(String productionArea) {
        this.productionArea = productionArea;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productionArea='" + productionArea + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
