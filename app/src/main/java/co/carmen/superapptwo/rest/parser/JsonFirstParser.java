package co.carmen.superapptwo.rest.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.carmen.superapptwo.model.Category;
import co.carmen.superapptwo.model.Product;

/**
 * Created by Alfredo on 27/05/2015.
 */
public class JsonFirstParser {

    public static ArrayList<Category> parserCategoriesJsonObject(JSONObject jsonObject){
        ArrayList<Category> categories = new ArrayList<>();

        try {
            for(int i = 0; i < jsonObject.getJSONArray("categories").length(); i++){
                Category category = new Category();

                category.setCategoryId(jsonObject.getJSONArray("categories").getJSONObject(i).getString("id"));
                category.setCategoryImage(jsonObject.getJSONArray("categories").getJSONObject(i).getString("image"));
                category.setCategoryName(jsonObject.getJSONArray("categories").getJSONObject(i).getString("categoria"));


                categories.add(category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }return categories;

    }

    public static ArrayList<Product> parserProductsJsonObject(JSONObject jsonObject){
        ArrayList<Product> products = new ArrayList<>();

        try {
            for(int i = 0; i < jsonObject.getJSONArray("products").length(); i++){
                Product product = new Product();

                product.setProductid(jsonObject.getJSONArray("products").getJSONObject(i).getString("id"));
                product.setProductPrice(jsonObject.getJSONArray("products").getJSONObject(i).getString("price"));
                product.setProductName(jsonObject.getJSONArray("products").getJSONObject(i).getString("descripcion"));
                product.setProductName(jsonObject.getJSONArray("precios").getJSONObject(i).getString("precio"));



                products.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }return products;

    }
}
