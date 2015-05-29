package co.carmen.superapptwo.rest.parser;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.carmen.superapptwo.model.Category;
import co.carmen.superapptwo.model.Local;
import co.carmen.superapptwo.model.Precio;
import co.carmen.superapptwo.model.Product;

/**
 * Created by Alfredo on 27/05/2015.
 */
public class JsonFirstParser {

    public static ArrayList<Category> parserCategoriesJsonObject(JSONArray jsonArray){
        ArrayList<Category> categories = new ArrayList<>();
        Log.e("JsonArray",String.valueOf(jsonArray));

        try {
            for(int i=0; i < jsonArray.length();i++){
                Category category= new Category();
                JSONObject categ = jsonArray.getJSONObject(i);
                category.setCategoryId(categ.getString("id"));
                category.setCategoryName(categ.getString("categoria"));
                category.setCategoryImage(categ.getString("imagen"));

                categories.add(category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public static ArrayList<Product> parserCreateProduct(JSONArray jsonArray){
        ArrayList<Product> products = new ArrayList<>();
        try {

            for(int index = 0; index < jsonArray.length(); index++){
                Product product = new Product();
                ArrayList<Precio> precios = new ArrayList<>();
                product.setProductId(jsonArray.getJSONObject(index).getString("id"));
                product.setProductName(jsonArray.getJSONObject(index).getString("name"));
                for(int indexb = 0; indexb < jsonArray.getJSONObject(index).getJSONArray("precios").length(); indexb++){
                    Precio precio = new Precio();
                    precio.setPrecioProduct(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getLong("precio"));
                    Local local = new Local();
                    local.setLocalName(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getString("sucursal"));
                    local.setLocalDirec(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getString("direccion"));
                    local.setLocalTel(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getString("telefono"));
                    local.setLocalId(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getString("id"));
                    local.setLocalLat(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getLong("latitud"));
                    local.setLocalLong(jsonArray.getJSONObject(index).getJSONArray("precios").getJSONObject(indexb).getJSONObject("local").getLong("longitud"));
                    precio.setPrecioLocal(local);
                    precios.add(precio);
                }
                products.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return products;
    }


        /*try {
            for(int i = 0; i < jsonArray.getJSONArray("categories").length(); i++){
                Category category = new Category();

                category.setCategoryId(jsonObject.getJSONArray("categories").getJSONObject(i).getString("id"));
                category.setCategoryImage(jsonObject.getJSONArray("categories").getJSONObject(i).getString("image"));
                category.setCategoryName(jsonObject.getJSONArray("categories").getJSONObject(i).getString("categoria"));


                categories.add(category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/



}
