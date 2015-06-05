package co.carmen.superapptwo;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;

import co.carmen.superapptwo.ui.fragment.PersonalFragment;
import co.carmen.superapptwo.ui.fragment.ProductFragment;


public class ActivityProduct extends ActionBarActivity {

    private String categoryId = "";
    private String producsURL = "http://profecoapi.tk/categories/%s/?format=json";
    private String productImage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_product);
        categoryId = getIntent().getStringExtra("categoryId");
        productImage = getIntent().getStringExtra("productImage");

        producsURL = String.format(producsURL, categoryId);
        getFragmentManager().beginTransaction().replace(R.id.conteiner, ProductFragment.getInstance(producsURL,productImage)).commit();
        Log.wtf("String url:", producsURL);
        Log.wtf("String url:", productImage);

        Fresco.initialize(this);

        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* void showDialog() {
        mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = PersonalFragment.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    /*public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @InjectView(R.id.list_products)
        RecyclerView listProducts;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity_product, container, false);
            return rootView;
        }
    }*/
}
