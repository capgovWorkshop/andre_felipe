package capgov.coppetec.com.br.dia1seminario.controller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import capgov.coppetec.com.br.dia1seminario.R;
import capgov.coppetec.com.br.dia1seminario.model.Pessoa;

public class Desafio8ExibirActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio8_exibir);

        final Pessoa pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        Button alterar = (Button) findViewById(R.id.alterar);

        if(pessoa != null) {

            TextView nome = (TextView) findViewById(R.id.nome);
            TextView password = (TextView) findViewById(R.id.password);
            TextView email = (TextView) findViewById(R.id.email);
            TextView phone = (TextView) findViewById(R.id.phone);
            TextView data = (TextView) findViewById(R.id.date);
            TextView sex = (TextView) findViewById(R.id.sex);

            nome.setText(pessoa.getNome());
            password.setText(pessoa.getSenha());
            email.setText(pessoa.getEmail());
            phone.setText(pessoa.getTelefone());
            sex.setText(pessoa.getSexo());

            if (pessoa.getData() != null) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                data.setText(format.format(pessoa.getData()));
            }
        }

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desafio8ExibirActivity.this, Desafio8AlterarActivity.class);
                intent.putExtra("pessoa", pessoa);
                startActivity(intent);
                finish();
            }
        });
    }
}
