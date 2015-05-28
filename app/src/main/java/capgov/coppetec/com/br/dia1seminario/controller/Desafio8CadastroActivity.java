package capgov.coppetec.com.br.dia1seminario.controller;

import android.content.Intent;
import android.os.Bundle;
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

import capgov.coppetec.com.br.dia1seminario.R;
import capgov.coppetec.com.br.dia1seminario.dao.PessoaDAO;
import capgov.coppetec.com.br.dia1seminario.model.Pessoa;

public class Desafio8CadastroActivity extends BaseActivity {

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio8_cadastrar);

        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);
        Button submit = (Button) findViewById(R.id.login);

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
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);

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

                Pessoa pessoa = new Pessoa(nomeStr,passwordStr, emailStr, dateTime, phoneStr, sexStr);

                PessoaDAO pessoaDAO = new PessoaDAO(Desafio8CadastroActivity.this);

                pessoaDAO.inserirPessoa(pessoa);

                Intent intent = new Intent(Desafio8CadastroActivity.this, Desafio8LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
