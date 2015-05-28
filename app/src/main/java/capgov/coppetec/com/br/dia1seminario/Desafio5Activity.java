package capgov.coppetec.com.br.dia1seminario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Desafio5Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio5);

        final EditText editTextEntry = (EditText) findViewById(R.id.editTextEntry);
        Button buttonEntry = (Button) findViewById(R.id.buttonEntry);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        buttonEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextEntry.getText().toString();
                if(text.equals(getString(R.string.TextView))){
                    textView.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                }else if(text.equals(getString(R.string.EditText))){
                    textView.setVisibility(View.GONE);
                    editText.setVisibility(View.VISIBLE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                }else if(text.equals(getString(R.string.Button))){
                    textView.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                }else if(text.equals(getString(R.string.ImageView))){
                    textView.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    textView.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                    showAlertToUser();
                }
            }
        });
    }
    public void showAlertToUser(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Mensagem do dialog");
        alertDialogBuilder.setPositiveButton("mensagem positiva",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        alertDialogBuilder.setNegativeButton("mensagem negativa",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_desafio1) {
            Intent intent = new Intent(getApplicationContext(), Desafio1Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio2) {
            Intent intent = new Intent(getApplicationContext(), Desafio2Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio3) {
            Intent intent = new Intent(getApplicationContext(), Desafio3Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio4) {
            Intent intent = new Intent(getApplicationContext(), Desafio4Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio5) {
            Intent intent = new Intent(getApplicationContext(), Desafio5Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio6) {
            Intent intent = new Intent(getApplicationContext(), Desafio6Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_desafio7) {
            Intent intent = new Intent(getApplicationContext(), Desafio7Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if (id == R.id.action_cronometro) {
            Intent intent = new Intent(getApplicationContext(), CronometroActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
