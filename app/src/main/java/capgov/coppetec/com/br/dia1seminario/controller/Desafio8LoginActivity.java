package capgov.coppetec.com.br.dia1seminario.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import capgov.coppetec.com.br.dia1seminario.R;
import capgov.coppetec.com.br.dia1seminario.dao.PessoaDAO;
import capgov.coppetec.com.br.dia1seminario.model.Pessoa;


public class Desafio8LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio8_login);

        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);
        Button login = (Button) findViewById(R.id.login);
        Button cadastro = (Button) findViewById(R.id.cadastro);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PessoaDAO pessoaDAO = new PessoaDAO(Desafio8LoginActivity.this);
                Pessoa pessoa = pessoaDAO.login(email.getText().toString(), password.getText().toString());

                if(pessoa != null) {
                    Intent intent = new Intent(Desafio8LoginActivity.this, Desafio8ExibirActivity.class);
                    intent.putExtra("pessoa", pessoa);
                    startActivity(intent);
                }else{
                    showAlertToUser(getString(R.string.cant_login));
                }
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desafio8LoginActivity.this, Desafio8CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showAlertToUser(String text){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage(text)
                .setPositiveButton(getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
