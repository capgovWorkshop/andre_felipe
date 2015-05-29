package capgov.coppetec.com.br.dia1seminario.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;

import capgov.coppetec.com.br.dia1seminario.R;
import capgov.coppetec.com.br.dia1seminario.model.NewAsyncTask;
import capgov.coppetec.com.br.dia1seminario.model.Pessoa;

public class Desafio9Activity extends ActionBarActivity implements NewAsyncTask.OnPostExecuteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio9);

        String json = "";
        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        final ListView listView = (ListView) findViewById(R.id.list);

        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            private AdapterView<?> parent;
            private View view;
            private int position;
            private long id;

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                this.parent = parent;
                this.view = view;
                this.position = position;
                this.id = id;

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_desafio9, menu);
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


    @Override
    public void onPostExecute(String result) {

    }
}
