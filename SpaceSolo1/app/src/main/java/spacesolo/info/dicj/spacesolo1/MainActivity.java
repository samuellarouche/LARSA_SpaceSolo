package spacesolo.info.dicj.spacesolo1;

import android.graphics.drawable.Drawable;
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

import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
    CountDownTimer countdowntimer;
    int cptBtn2 = 0;
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

        countdowntimer = new CountDownTimer(10000, 10) {

            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished/1000);

               progbar.setProgress(progbar.getMax()-progress);
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Count Down Finish", Toast.LENGTH_SHORT).show();
            }
        }.start();


        ImageButton button = (ImageButton) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "very nice", Toast.LENGTH_SHORT).show();
                progbar.setProgress(0);
                countdowntimer.start();
            }
        });

        final ImageButton button2 = (ImageButton) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cptBtn2++;
                if (cptBtn2 % 2 == 0) {
                    button2.setBackgroundResource(R.drawable.darkredbutton);
                } else {
                    button2.setBackgroundResource(R.drawable.redbutton);
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
