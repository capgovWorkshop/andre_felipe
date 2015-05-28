package capgov.coppetec.com.br.dia1seminario.controller;

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

import capgov.coppetec.com.br.dia1seminario.R;


public class Desafio4Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio4);

        final EditText editTextEntry = (EditText) findViewById(R.id.editTextEntry);
        Button buttonEntry = (Button) findViewById(R.id.buttonEntry);

        buttonEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertToUser(editTextEntry.getText().toString());
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
