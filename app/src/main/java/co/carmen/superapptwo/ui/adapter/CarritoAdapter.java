package co.carmen.superapptwo.ui.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.util.ArrayList;

import co.carmen.superapptwo.R;
import co.carmen.superapptwo.model.BaseClient;

/**
 * Created by marco on 29/05/15.
 */

public class CarritoAdapter extends ArrayAdapter<BaseClient> {

   private ArrayList<BaseClient> productosDelCarrito;

    private final Context context;


    public CarritoAdapter(Context context, ArrayList<BaseClient> productosdelcarrito) {


        super(context, -1, productosdelcarrito);
        this.context = context;
        this.productosDelCarrito = productosdelcarrito;



    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View carritoView = inflater.inflate(R.layout.layout_carrito, parent, false);

        //Obtener los campos de la vista raiz
        TextView txtNombreProd = (TextView) carritoView.findViewById(R.id.carritonombre);
        TextView txtDireccion = (TextView) carritoView.findViewById(R.id.carritodireccion);
        TextView txtPrecio = (TextView) carritoView.findViewById(R.id.carritoprecio);
        TextView txtSuper = (TextView) carritoView.findViewById(R.id.carritosuper);

        ImageView imageView = (ImageView) carritoView.findViewById(R.id.carritophoto);

        BaseClient selectedProduct = productosDelCarrito.get(position);

        txtNombreProd.setText(selectedProduct.getName());
        txtDireccion.setText(selectedProduct.getDireccion());
        String stringprecio = String.valueOf(selectedProduct.getPrecio());
        txtPrecio.setText(stringprecio);
        txtSuper.setText(selectedProduct.getSupermercado());
        txtNombreProd.setText(selectedProduct.getSupermercado());

        return carritoView;
    }
}
