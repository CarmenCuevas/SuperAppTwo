package co.carmen.superapptwo.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.ui.adapter.ProductAdapter;

public class ProductFragment extends Fragment {


    public Context CONTEXT;


    @InjectView(R.id.list_products)
    RecyclerView listProducts;

    ProductAdapter adapter;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_product, container, false);
        ButterKnife.inject(this, rootView);

        inListProducts();
        return rootView;
    }



    private void inListProducts() {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        //adapter = new ProductAdapter(CONTEXT);

        listProducts.setLayoutManager(lm);
        //listProducts.setAdapter(adapter);



    }
}