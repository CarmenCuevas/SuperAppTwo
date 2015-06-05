package co.carmen.superapptwo.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.carmen.superapptwo.ActivityPersonal;
import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Product;

/**
 * Created by Alfredo on 21/05/2015.
 */
public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ProductViewHolder> {

    private ArrayList<Product> products;
    private String product_photo ;
    private Context context;

    public PersonalAdapter(ArrayList<Product> products,String product_photo) {
        this.product_photo = product_photo;
        this.products = products;

    }

    @Override
    public ProductViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_product, viewGroup, false);

        ProductViewHolder vh = new ProductViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder (ProductViewHolder productViewHolder,final int i){
        productViewHolder.product_price.setText(String.valueOf(products.get(i).getPrecios()));
        productViewHolder.product_suc.setText(String.valueOf(products.get(i).getProductName()));
        productViewHolder.product_direc.setText(String.valueOf(products.get(i).getProductName()));;
       /* productViewHolder.product_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("Click::", products.get(i).getProductid());
                Intent intent = new Intent(context, ActivityPersonal.class);
                intent.putExtra("categoryId", products.get(i).getProductid());
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView product_price;
        TextView product_suc;
        TextView product_direc;

        Button product_but;


        public  ProductViewHolder(View itemView) {
            super(itemView);

            this.product_price = (TextView) itemView.findViewById(R.id.txt_personal_price);
            this.product_suc = (TextView) itemView.findViewById(R.id.txt_personal_super);
            this.product_direc = (TextView) itemView.findViewById(R.id.txt_personal_direc);
            this.product_but = (Button) itemView.findViewById(R.id.buttonA);


        }

    }





}