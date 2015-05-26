package co.carmen.superapptwo.ui.adapter;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Category;

/**
 * Created by Alfredo on 18/05/2015.
 */



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }


    @Override
   public CategoryViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.imageandtext_layout, viewGroup, false);

    CategoryViewHolder vh = new CategoryViewHolder(v);
       return vh;

   }


    @Override
    public void onBindViewHolder (CategoryViewHolder categoryViewHolder, int i){
       categoryViewHolder.category_txt.setText(String.valueOf(categories.get(i).getCategoryName()));


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }





    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView category_photo;
        TextView category_txt;







       public  CategoryViewHolder(View itemView) {
           super(itemView);
           this.category_photo = (ImageView) itemView.findViewById(R.id.imagecategoria);
           this.category_txt = (TextView) itemView.findViewById(R.id.categoriatext);
       }


    }



}






