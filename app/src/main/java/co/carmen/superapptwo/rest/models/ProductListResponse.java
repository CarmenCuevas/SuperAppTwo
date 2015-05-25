package co.carmen.superapptwo.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import co.carmen.superapptwo.model.Product;
import co.carmen.superapptwo.rest.Constants;

/**
 * Created by Alfredo on 14/05/2015.
 */
public class ProductListResponse {
    @SerializedName(Constants.CODE_KEY)
    int code;

    @SerializedName(Constants.STATUS_KEY)
    String status;

    //We expose these fields because we gonna parse them manually with a deserializer
    @Expose
    int offset;

    @Expose
    List<Product> products;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
