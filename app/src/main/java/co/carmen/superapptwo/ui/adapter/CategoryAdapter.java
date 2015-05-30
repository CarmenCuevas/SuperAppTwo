package co.carmen.superapptwo.ui.adapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import co.carmen.superapptwo.ActivityProduct;
import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Category;

/**
 * Created by Alfredo on 18/05/2015.
 */



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;
    private Context context;
    private String urlIm ="http://a73d00d6.ngrok.io/%s";

    public CategoryAdapter(ArrayList<Category> categories, Context context){
        this.categories = categories;
        this.context = context;
    }

    @Override
   public CategoryViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.imageandtext_layout, viewGroup, false);

    CategoryViewHolder vh = new CategoryViewHolder(v);
       return vh;
   }

    @Override
    public void onBindViewHolder (CategoryViewHolder categoryViewHolder,final int i){
       categoryViewHolder.category_txt.setText(String.valueOf(categories.get(i).getCategoryName()));
        categoryViewHolder.category_photo.setImageURI(Uri.parse(String.format(urlIm,categories.get(i).getCategoryImage())));
        categoryViewHolder.category_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("Click::", categories.get(i).getCategoryId());
                Intent intent = new Intent(context, ActivityProduct.class);
                intent.putExtra("categoryId", categories.get(i).getCategoryId());
                intent.putExtra("productImage",String.format(urlIm,categories.get(i).getCategoryImage()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView category_photo;
        TextView category_txt;
       public  CategoryViewHolder(View itemView) {
           super(itemView);
           this.category_photo = (SimpleDraweeView) itemView.findViewById(R.id.img_category);
           this.category_txt = (TextView) itemView.findViewById(R.id.categoriatext);
       }

    }

}






