package co.carmen.superapptwo.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Category;
import co.carmen.superapptwo.ui.adapter.CategoryAdapter;

/**
 * Created by Alfredo on 18/05/2015.
 */


public class CategoryFragment extends Fragment {
    private RecyclerView my_recycler_view;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager manager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity_category, container, false);

        initView(v);

        return v;
    }


    private void initView (View view){
        my_recycler_view = (RecyclerView) view.findViewById(R.id.recyclerviewcategory);
        my_recycler_view.setHasFixedSize(true);
        manager = new GridLayoutManager(getActivity(), 2);
        my_recycler_view.setLayoutManager(manager);

        ArrayList<Category> categories = new ArrayList<>();


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
    }




}
