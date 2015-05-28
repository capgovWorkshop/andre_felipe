package capgov.coppetec.com.br.dia1seminario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Desafio6Activity extends ActionBarActivity {

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio6);

        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);
        Button submit = (Button) findViewById(R.id.submit);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
//        datePicker.init(year, month, day, null);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonID = radioGroup.getCheckedRadioButtonId();

                String nomeStr = nome.getText().toString();
                String passwordStr = password.getText().toString();
                String emailStr = email.getText().toString();

                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth();
                year = datePicker.getYear();

                String dataStr = new StringBuilder().append(day)
                        .append("/").append(month + 1).append("/").append(year)
                        .append(" ").toString();

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dateTime = new Date();
                try {
                    dateTime = format.parse(dataStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String phoneStr = phone.getText().toString();
                String sexStr = "";

                if(radioButtonID == R.id.radioMen){
                    sexStr = getString(R.string.male);
                }else{
                    sexStr = getString(R.string.female);
                }


                Cadastro cadastro = new Cadastro(nomeStr,emailStr,passwordStr,dateTime,phoneStr, sexStr);

                Intent intent = new Intent(Desafio6Activity.this, Desafio6Activity2.class);
                intent.putExtra("cadastro", cadastro);
                startActivity(intent);
            }
        });

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
