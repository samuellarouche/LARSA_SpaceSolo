package spacesolo.info.dicj.spacesolo1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
    CountDownTimer countdowntimer;
    int cptBtn1 = 0;
    int cptBtn2 = 0;
    int cptBtn3 = 0;
    int cptBtn4 = 0;
    public boolean btn1onoff = false;
    int epreuveChoisi = 0;
    Random rndEpreuve = new Random();
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progbar = (ProgressBar) findViewById(R.id.ProgressBar);
        int rndEp = rndEpreuve.nextInt(4)+1;
        epreuveChoisi = spacesolo.info.dicj.spacesolo1.epreuve.choixEpreuve(rndEp);

        countdowntimer = new CountDownTimer(10000,1000) {

            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished/1000);

               progbar.setProgress(progbar.getMax()-progress);
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Count Down Finish", Toast.LENGTH_SHORT).show();
                countdowntimer.cancel();
                progbar.setProgress(0);
                countdowntimer.start();
            }
        }.start();


        /*Use the shake in the phone*/
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                Toast.makeText(MainActivity.this, "epreuve 5", Toast.LENGTH_SHORT).show();
                countdowntimer.cancel();
                progbar.setProgress(0);
                countdowntimer.start();
                if(epreuveChoisi == 5) {
                    Toast.makeText(MainActivity.this, "epreuve 5", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
                    countdowntimer.cancel();
                    progbar.setProgress(0);
                    countdowntimer.start();
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
                    countdowntimer.cancel();
                    progbar.setProgress(0);
                    countdowntimer.start();
                }
            }
        });

        final ImageButton button3 = (ImageButton) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cptBtn3++;
                if (cptBtn3 % 2 == 0) {
                    button3.setBackgroundResource(R.drawable.interupteurresverse);
                    boolean btn3onoff = false;
                } else {
                    button3.setBackgroundResource(R.drawable.interupteur);
                    boolean btn3onoff = true;
                }
                if(epreuveChoisi == 2) {
                    countdowntimer.cancel();
                    progbar.setProgress(0);
                    countdowntimer.start();
                }
            }
        });

        final ImageButton button4 = (ImageButton) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                cptBtn4++;
                if (cptBtn4 % 2 == 0) {
                    button4.setBackgroundResource(R.drawable.interupteur);
                    boolean btn4onoff = true;
                } else {
                    button4.setBackgroundResource(R.drawable.interupteurresverse);
                    boolean btn4onoff = false;
                }
                if(epreuveChoisi == 2) {
                    countdowntimer.cancel();
                    progbar.setProgress(0);
                    countdowntimer.start();
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://spacesolo.info.dicj.spacesolo1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://spacesolo.info.dicj.spacesolo1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
