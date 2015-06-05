package co.carmen.superapptwo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;

import co.carmen.superapptwo.ui.fragment.PersonalFragment;
import co.carmen.superapptwo.ui.fragment.ProductFragment;


public class ActivityPersonal extends AppCompatActivity {

    private String categoryId = "";
    private String producsURL = "http://profecoapi.tk/categories/%s/?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_personal);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.personal_fragment, new PlaceholderFragment())
                    .commit();
        }
        /*categoryId = getIntent().getStringExtra("categoryId");
        producsURL = String.format(producsURL, categoryId);
        getFragmentManager().beginTransaction().replace(R.id.personal_fragment, PersonalFragment.getInstance(producsURL)).commit();
        Log.wtf("String url:", producsURL);*/

        Fresco.initialize(this);

    }
    public void  ActivityProduct3(View view){
        Button button = (Button) findViewById(R.id.buttonP);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPersonal.this, ActivityLista.class);
                startActivity(intent);
            }
        });

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
            View rootView = inflater.inflate(R.layout.fragment_activity_personal, container, false);
            return rootView;
        }



    }

    /**
     * A placeholder fragment containing a simple view.
     */

}
