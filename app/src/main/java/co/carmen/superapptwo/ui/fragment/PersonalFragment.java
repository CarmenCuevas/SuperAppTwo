package co.carmen.superapptwo.ui.fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

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

import butterknife.ButterKnife;
import butterknife.InjectView;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Precio;
import co.carmen.superapptwo.model.Product;
import co.carmen.superapptwo.rest.app.ParseAplication;
import co.carmen.superapptwo.rest.parser.JsonFirstParser;
import co.carmen.superapptwo.ui.adapter.PersonalAdapter;
import co.carmen.superapptwo.ui.adapter.ProductAdapter;

/**
 * Created by Alfredo on 21/05/2015.
 */
public class PersonalFragment extends Fragment {

    public Context CONTEXT;
    private RecyclerView recycler_personal;
    private PersonalAdapter adapter;
    private RecyclerView.LayoutManager managerPro;
    private String url ;
    private String product_photo ;

    public PersonalFragment() {
        // Required empty public constructor
    }

    public static PersonalFragment getInstance(String url){
        PersonalFragment personalF = new PersonalFragment();
        Bundle bun = new Bundle();
        bun.putString("producsURL",url);
        personalF.setArguments(bun);



        return personalF;
    }
   /* static PersonalFragment newInstance(int num) {
        PersonalFragment f = new PersonalFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_personal, container, false);
        jsonPersonalRequest();
        inListPersonal(rootView);
        return rootView;

    }*/

    @Override
    public void onResume() {
        super.onResume();
    }


    /*private void inListPersonal(View view) {
        recycler_personal = (RecyclerView) view.findViewById(R.id.recycler_personal);
        recycler_personal.setHasFixedSize(true);
        managerPro = new LinearLayoutManager(getActivity());
        recycler_personal.setLayoutManager(managerPro);
    }*/

    private void jsonPersonalRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.wtf("STRING-REQUEST::", String.valueOf(jsonArray));
                if (jsonArray != null){
                    //ArrayList<Precio> precios = JsonFirstParser.parserCreateProduct(jsonArray);
                    //adapter = new ProductAdapter(precios);
                    recycler_personal.setAdapter(adapter);
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
