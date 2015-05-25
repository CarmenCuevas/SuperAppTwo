package co.carmen.superapptwo.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.Product;
import co.carmen.superapptwo.rest.Constants;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static java.util.Collections.EMPTY_LIST;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int VIEW_PRODUCT = 0;
    private final int VIEW_PROGRESS = 1;
    private String noneContent = "None";
    private int DETAIL_FRAGMENT_ID = 0;

    List<Product> products = EMPTY_LIST;
    Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return products.get(position) != null ? VIEW_PRODUCT : VIEW_PROGRESS;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        if (viewType == VIEW_PRODUCT) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_product, viewGroup, false);

            return new ProductViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_product_progress, viewGroup, false);

            return new ProgressViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ProductViewHolder) {
            Product currentProduct = products.get(position);
            ((ProductViewHolder) viewHolder).setImg(currentProduct.getUrlImage());
            ((ProductViewHolder) viewHolder).setName(currentProduct.getName());
            ((ProductViewHolder) viewHolder).setTxtPrice(currentProduct.getPrice());
            ((ProductViewHolder) viewHolder).setTxtSuper(currentProduct.getDescription());


            Bundle bundle = new Bundle();

            bundle.putString(Constants.CATEGORY_URL_IMAGE, String.valueOf(currentProduct.getUrlImage()));
            bundle.putString(Constants.ID_KEY, String.valueOf(currentProduct.getId()));
            bundle.putString(Constants.NAME_KEY, currentProduct.getName());
            bundle.putString(Constants.PRICE_KEY, currentProduct.getName());
            bundle.putString(Constants.CANT_KEY, currentProduct.getName());
            if (currentProduct.getDescription().length() > 0) {
                bundle.putString(Constants.DESCRIPTION_KEY, currentProduct.getDescription());
            } else {
                bundle.putString(Constants.DESCRIPTION_KEY,noneContent );
            }



        }
    }

    @Override
    public int getItemCount() {
        if (products == null)
            return 0;

        return products.size();
    }


    public int getCharacterItemsCount() {
        if (isProgressViewVisible())
            return products.size() - 1;

        return products.size();
    }

    public void updateList(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public void addItemCollection(List<Product> products) {
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    /**
     * Make a request to the Marvel API to load 20 more characters
     * The offset for the request is defined by {@link #getItemCount()}
     */


    private void showOnLoadViewHolder() {
        products.add(null);
        notifyDataSetChanged();
    }

    public boolean isProgressViewVisible() {
        return products.contains(null);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.itemPro)
        RelativeLayout item;

        @InjectView(R.id.img_product)
        SimpleDraweeView imgProduct;

        @InjectView(R.id.txt_product_name)
        TextView txtName;

        @InjectView(R.id.txt_product_super)
        TextView txtSuper;

        @InjectView(R.id.txt_product_price)
        TextView txtPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }



        public void setImg(Uri urlImage) {
            if (!urlImage.equals(Uri.EMPTY))
                imgProduct.setImageURI(urlImage);
        }

        public void setName(String name) {
            txtName.setText(name);
        }

        public void setTxtSuper(String name) {
            txtName.setText(name);
        }

        public void setTxtPrice(String name) {
            txtName.setText(name);
        }


    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }




}