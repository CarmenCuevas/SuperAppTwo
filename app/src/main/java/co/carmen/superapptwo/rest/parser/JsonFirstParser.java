package co.carmen.superapptwo.rest.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.carmen.superapptwo.model.Category;

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


       /* for (int index = 0; index < 20; index++) {

            Category category = new Category();

            category.setCategoryId("123");
            category.setCategoryImage("");
            category.setCategoryName("Frutas");


            categories.add(category);
        }*/



    }
}
