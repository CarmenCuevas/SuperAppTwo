package co.carmen.superapptwo.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.carmen.superapptwo.R;

import co.carmen.superapptwo.model.Category;
import co.carmen.superapptwo.rest.app.ParseAplication;
import co.carmen.superapptwo.rest.parser.JsonFirstParser;
import co.carmen.superapptwo.ui.adapter.CategoryAdapter;

/**
 * Created by Alfredo on 18/05/2015.
 */


public class CategoryFragment extends Fragment {
    private RecyclerView my_recycler_view;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private String url ="http://95ef1563.ngrok.io/categories/";
    //private RequestQueue queue;//sucia

    public CategoryFragment() {
    }

    public static CategoryFragment getInstance() {

        return new CategoryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //queue = Volley.newRequestQueue(this);//sucia
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity_category, container, false);
        makeSimpleRequest();
        jsonRequest();
        initView(v);
        return v;
    }

    private void initView (View view) {
        my_recycler_view = (RecyclerView) view.findViewById(R.id.recyclerviewcategory);
        my_recycler_view.setHasFixedSize(true);
        manager = new GridLayoutManager(getActivity(), 2);
        my_recycler_view.setLayoutManager(manager);

    }

    private void makeSimpleRequest() {
        // Request a string response from the provided URL.

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.wtf("STRING-REQUEST::", String.valueOf(jsonObject));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.wtf("STRING-REQUEST-ERROR::", String.valueOf(volleyError));
            }
        });

        // Add the request to the RequestQueue.
        ParseAplication.getInstance().addToRequestQueue(jsonObjectRequest, "getCategories");
    }

    private void jsonRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        ArrayList<Category> categories = null;
                        if (jsonObject != null) {
                            Log.wtf("STRING-REQUEST::", String.valueOf(jsonObject));
                            categories = JsonFirstParser.parserCategoriesJsonObject(jsonObject);

                            adapter = new CategoryAdapter(categories);

                            my_recycler_view.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.wtf("STRING-REQUEST-ERROR::", String.valueOf(volleyError));
            }
        });

        // Add the request to the RequestQueue.
        ParseAplication.getInstance().addToRequestQueue(jsonObjectRequest, "getCategories");
    }

        /*ArrayList<Category> categories = new ArrayList<>();


        /// datos dummies para cambiar

        for(int i = 0; i < 20; i++){
            Category category = new Category();
            category.setCategoryId(2);
            category.setCategoryImage("");
            category.setCategoryName("frutas");
            categories.add(category);
        }
         adapter = new CategoryAdapter(categories);
        my_recycler_view.setAdapter(adapter);

    }


    public static CategoryFragment newInstance(String text) {

        CategoryFragment f = new CategoryFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }*/

    /*private void SimpleRequest() {

        JsonObjectRequest jsonObject = new JsonObjectRequest(url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        //esta es una forma sucia de hacer el request y esxiste la otra en la que hago mi class aplication y mi parse de mi class
    }*/




}
