package co.carmen.superapptwo.model;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import co.carmen.superapptwo.rest.Constants;

/**
 * Created by Alfredo on 14/05/2015.
 */
public class Product {

    @SerializedName(Constants.ID_KEY)
    int id;

    @SerializedName(Constants.NAME_KEY)
    String name;

    @SerializedName(Constants.SUPER_KEY)
    String superon;

    @SerializedName(Constants.PRICE_KEY)
    String price;

    @SerializedName(Constants.CANT_KEY)
    String canti;

    @Expose
    Uri urlImage;

    public static Product buildFromJson (JsonObject productData){

        Gson gson = new Gson();
        Product cuProduct = gson.fromJson(productData, Product.class);
        return cuProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperon() {
        return superon;
    }

    public void setSuperon(String description) {
        this.superon = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCanti() {
        return canti;
    }

    public void setCanti(String canti) {
        this.canti = canti;
    }

    public Uri getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Uri urlImage) {
        this.urlImage = urlImage;
    }


}
