package co.carmen.superapptwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Alfredo on 05/06/2015.
 */
public class ActivityLista extends AppCompatActivity {

    private String categoryId = "";
    private String producsURL = "http://profecoapi.tk/categories/%s/?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container1, new PlaceholderFragment())
                    .commit();
        }
        /*categoryId = getIntent().getStringExtra("categoryId");
        producsURL = String.format(producsURL, categoryId);
        getFragmentManager().beginTransaction().replace(R.id.personal_fragment, PersonalFragment.getInstance(producsURL)).commit();
        Log.wtf("String url:", producsURL);*/

        Fresco.initialize(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_personal, menu);
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

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lista, container, false);
            return rootView;
        }



    }

    /**
     * A placeholder fragment containing a simple view.
     */

}
