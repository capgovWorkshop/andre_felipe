package capgov.coppetec.com.br.dia1seminario.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;

import capgov.coppetec.com.br.dia1seminario.R;


public class CronometroActivity extends BaseActivity {

    int minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        final LinearLayout layoutTerminou = (LinearLayout) findViewById(R.id.layoutTerminou);
        final LinearLayout layoutButtons = (LinearLayout) findViewById(R.id.layoutButtons);
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        Button fiveMin = (Button) findViewById(R.id.fiveMin);
        fiveMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 5;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });
        Button tenMin = (Button) findViewById(R.id.tenMin);
        tenMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 10;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });
        Button fithteenMin = (Button) findViewById(R.id.fithteenMin);
        fithteenMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 15;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });
        Button twentyMin = (Button) findViewById(R.id.twentyMin);
        twentyMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 20;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });
        Button twentyFiveMin = (Button) findViewById(R.id.twentyFiveMin);
        twentyFiveMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 25;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });
        Button thirtyMin = (Button) findViewById(R.id.thirtyMin);
        thirtyMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutes = 30;
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                layoutButtons.setVisibility(View.GONE);
                layoutTerminou.setVisibility(View.GONE);
                chronometer.setVisibility(View.VISIBLE);
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                int hoursElapsed = (int) (elapsedMillis / 3600000);
                int minutesElapsed = (int) (elapsedMillis - hoursElapsed * 3600000) / 60000;
                int seconds = (int) (elapsedMillis - hoursElapsed * 3600000 - minutesElapsed * 60000) / 1000;

                if(minutes*60 - seconds == 30){
                    chronometer.setTextColor(Color.RED);
                }

                if(minutesElapsed == minutes){
                    chronometer.stop();
                    layoutTerminou.setVisibility(View.VISIBLE);
                    layoutButtons.setVisibility(View.GONE);
                    chronometer.setVisibility(View.GONE);

                }
            }
        });


    }

}
