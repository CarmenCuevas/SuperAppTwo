package co.carmen.superapptwo.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Product;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
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
        productViewHolder.product_txt.setText(String.valueOf(products.get(i).getProductName()));


        productViewHolder.product_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("Click::", products.get(i).getProductid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView product_photo;
        TextView product_txt;
        public  ProductViewHolder(View itemView) {
            super(itemView);
            this.product_photo = (ImageView) itemView.findViewById(R.id.img_product);
            this.product_txt = (TextView) itemView.findViewById(R.id.txt_product_name);
        }

    }


}