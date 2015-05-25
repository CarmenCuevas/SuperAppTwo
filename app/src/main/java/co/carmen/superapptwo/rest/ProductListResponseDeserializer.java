package co.carmen.superapptwo.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.carmen.superapptwo.model.Product;
import co.carmen.superapptwo.rest.models.ProductListResponse;

/**
 * Created by Alfredo on 14/05/2015.
 */
public class ProductListResponseDeserializer implements JsonDeserializer<ProductListResponse> {


    @Override
    public ProductListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //First deserialize the attributes that are in the first level in the JsonObject.
        Gson gson = new Gson();
        ProductListResponse response = gson.fromJson(json, ProductListResponse.class);

        //Then deserialize all the attributes that are needed but are nested
        JsonObject data = json.getAsJsonObject()
                .getAsJsonObject(Constants.DATA_KEY);
        response.setOffset(data.get(Constants.OFFSET_KEY).getAsInt());

        JsonArray productsArray = data.getAsJsonArray(Constants.RESULTS_KEY);
        response.setProducts(extractProductsFromJson(productsArray));

        return response;
    }

    private ArrayList<Product> extractProductsFromJson (JsonArray productsArray) {
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < productsArray.size(); i++) {
            JsonObject productData = productsArray.get(i).getAsJsonObject();
            products.add(Product.buildFromJson(productData));
        }

        return products;
    }

}
