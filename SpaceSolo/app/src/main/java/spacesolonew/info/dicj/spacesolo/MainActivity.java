package spacesolonew.info.dicj.spacesolo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    int cptPoint = 0;
    int loseHP = 5;
    int cptBtn1 = 0;
    int cptBtn2 = 0;
    int cptBtn3 = 0;
    int cptBtn4 = 0;
    public boolean btn1onoff = false;
    int epreuveChoisi = 0;
    CountDownTimer cntdowntimer;
    ProgressBar progbar;
    boolean debut = true;
    long lastUpdate;
    Sensor accelerometer;
    private SensorManager mSensorManager;
    verifParti Verifierparti = new verifParti();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progbar = (ProgressBar) findViewById(R.id.ProgressBar);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        cntdowntimer = new CountDownTimer(5000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {

                if (debut){
                    epreuveChoisi = spacesolonew.info.dicj.spacesolo.epreuve.choixEpreuve();
                    toastEpreuve();
                    debut = false;
                }
                int progress = (int) (millisUntilFinished/500);
                progbar.setProgress(progbar.getMax()-progress);
            }

            @Override
            public void onFinish() {
                loseHP--;
                if(loseHP <= 0){
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    endGame();
                }
                    else
                {
                    debut = true;
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    cntdowntimer.start();
                }


            }
        }.start();
        final ImageButton button = (ImageButton) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cptBtn1++;
                if (cptBtn1 % 2 == 0) {
                    button.setBackgroundResource(R.drawable.darkredbutton);
                    btn1onoff = false;
                } else {
                    button.setBackgroundResource(R.drawable.redbutton);
                    btn1onoff = true;
                }
                if(epreuveChoisi == 1) {
                    debut = true;
                    cptPoint++;
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    cntdowntimer.start();
                }
            }
        });

        final ImageButton button2 = (ImageButton) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cptBtn2++;
                if (cptBtn2 % 2 == 0) {
                    button2.setBackgroundResource(R.drawable.darkredbutton);
                    boolean btn2onoff = false;
                } else {
                    button2.setBackgroundResource(R.drawable.redbutton);
                    boolean btn2onoff = true;
                }
                if(epreuveChoisi == 2) {
                    debut = true;
                    cptPoint++;
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    cntdowntimer.start();
                }
            }
        });

        final ImageButton button3 = (ImageButton) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cptBtn3++;
                if (cptBtn3 % 2 == 0) {
                    button3.setBackgroundResource(R.drawable.interupteur);
                    boolean btn3onoff = true;
                } else {
                    button3.setBackgroundResource(R.drawable.interupteurresverse);
                    boolean btn3onoff = false;
                }
                if(epreuveChoisi == 3) {
                    debut = true;
                    cptPoint++;
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    cntdowntimer.start();
                }
            }
        });

        final ImageButton button4 = (ImageButton) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cptBtn4++;
                if (cptBtn4 % 2 == 0) {
                    button4.setBackgroundResource(R.drawable.interupteurresverse);
                    boolean btn4onoff = false;
                } else {
                    button4.setBackgroundResource(R.drawable.interupteur);
                    boolean btn4onoff = true;
                }
                if(epreuveChoisi == 4) {
                    debut = true;
                    cptPoint++;
                    cntdowntimer.cancel();
                    progbar.setProgress(0);
                    cntdowntimer.start();
                }
            }
        });
    }

    public void toastEpreuve() {
        switch (epreuveChoisi) {
            case 1:
                Toast.makeText(MainActivity.this, "ACCELERATE, YOU'LL MISS THE POINTS", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Dodge left", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Dodge right", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this, "DO SOMETHING!", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(MainActivity.this, "Shake your phone quickly", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            getAccelerometer(event);
        }/**/
    }

    private void getAccelerometer(SensorEvent event) {
        /**/if (epreuveChoisi == 5) {
            float[] values = event.values;
            // Movement
            float x = values[0];
            float y = values[1];
            float z = values[2];

            float accelationSquareRoot = (x * x + y * y + z * z)
                    / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            long actualTime = event.timestamp;
            if (accelationSquareRoot >= 2) //
            {
                if (actualTime - lastUpdate < 200) {
                    return;
                }
                debut = true;
                lastUpdate = actualTime;
                cptPoint++;
                cntdowntimer.cancel();
                progbar.setProgress(0);
                cntdowntimer.start();
                epreuveChoisi = spacesolonew.info.dicj.spacesolo.epreuve.choixEpreuve();
            }

        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume() {
        super.onResume();
        /**/mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void endGame(){
        FrameLayout fLayout = (FrameLayout) findViewById(R.id.endLayout);
        fLayout.setVisibility(fLayout.VISIBLE);
        TextView TView = (TextView) findViewById(R.id.ScoreFinal);
        TView.setText("\n"+cptPoint);
        Button btnYes = (Button) findViewById(R.id.btnYes);
        Button btnNo = (Button) findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
}
