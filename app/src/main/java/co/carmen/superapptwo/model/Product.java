package co.carmen.superapptwo.model;


import java.util.ArrayList;

/**
 * Created by Alfredo on 14/05/2015.
 */
public class Product {

    private String productName;
    private String productId;
    private String productImage;
    private ArrayList<Precio> precios;

    public ArrayList<Precio> getPrecios() {
        return precios;
    }

    public void setPrecios(ArrayList<Precio> precios) {
        this.precios = precios;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductid() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
