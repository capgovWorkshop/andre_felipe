package capgov.coppetec.com.br.dia1seminario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class Desafio1Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio1);
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
