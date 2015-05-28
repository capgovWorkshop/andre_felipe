package capgov.coppetec.com.br.dia1seminario.controller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
import java.util.GregorianCalendar;

import capgov.coppetec.com.br.dia1seminario.R;
import capgov.coppetec.com.br.dia1seminario.dao.PessoaDAO;
import capgov.coppetec.com.br.dia1seminario.model.Pessoa;

public class Desafio8AlterarActivity extends BaseActivity {

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio8_alterar);

        Pessoa pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        final EditText nome = (EditText) findViewById(R.id.nome);
        nome.setText(pessoa.getNome());

        final EditText password = (EditText) findViewById(R.id.password);
        password.setText(pessoa.getSenha());

        final EditText email = (EditText) findViewById(R.id.email);
        email.setText(pessoa.getEmail());

        final EditText phone = (EditText) findViewById(R.id.phone);
        phone.setText(pessoa.getTelefone());

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(pessoa.getData());

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.updateDate(year, month, day);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);
        Button alterar = (Button) findViewById(R.id.alterar);

        if(pessoa.getSexo().equals(getString(R.string.male))) {
            radioGroup.check(R.id.radioMen);
        }else{
            radioGroup.check(R.id.radioWoman);
        }

        alterar.setOnClickListener(new View.OnClickListener() {
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

                if (radioButtonID == R.id.radioMen) {
                    sexStr = getString(R.string.male);
                } else {
                    sexStr = getString(R.string.female);
                }

                Pessoa pessoa = new Pessoa(nomeStr, emailStr, passwordStr, dateTime, phoneStr, sexStr);

                PessoaDAO pessoaDAO = new PessoaDAO(Desafio8AlterarActivity.this);

                pessoaDAO.atualizarDados(pessoa);

                Intent intent = new Intent(Desafio8AlterarActivity.this, Desafio8ExibirActivity.class);
                intent.putExtra("pessoa", pessoa);
                startActivity(intent);
            }
        });

    }
}
