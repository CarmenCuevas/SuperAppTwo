package co.carmen.superapptwo.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;

import java.util.ArrayList;

import co.carmen.superapptwo.R;

import co.carmen.superapptwo.model.Product;
import co.carmen.superapptwo.rest.app.ParseAplication;
import co.carmen.superapptwo.rest.parser.JsonFirstParser;

import co.carmen.superapptwo.ui.adapter.ProductAdapter;

public class ProductFragment extends Fragment {


    private RecyclerView recycler_product;
    private ProductAdapter adapter;
    private RecyclerView.LayoutManager managerPro;
    private String url ;

    public ProductFragment(){

    }

    public static ProductFragment getInstance(String url){
        ProductFragment pruductF = new ProductFragment();
        Bundle bun = new Bundle();
        bun.putString("url",url);
        pruductF.setArguments(bun);
        return new ProductFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity_product, container, false);
        url = getArguments().getString(url);
        initView(v);
        jsonProductRequest();
        return v;
    }

    private void initView (View view) {
        recycler_product = (RecyclerView) view.findViewById(R.id.list_products);
        recycler_product.setHasFixedSize(true);
        managerPro = new LinearLayoutManager(getActivity());
        recycler_product.setLayoutManager(managerPro);
    }

    private void jsonProductRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.wtf("STRING-REQUEST::", String.valueOf(jsonArray));
                if (jsonArray != null){
                    ArrayList<Product> products = JsonFirstParser.parserCreateProduct(jsonArray);
                    adapter = new ProductAdapter(products);
                    recycler_product.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.wtf("STRING-REQUEST-ERROR::", String.valueOf(volleyError));

            }
        });

        ParseAplication.getInstance().addToRequestQueue(jsonArrayRequest, "getProducts");

    }


}