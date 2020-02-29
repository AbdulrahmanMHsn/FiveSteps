package olgor.fivesteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class FirstStep extends AppCompatActivity {

    /* Get the signal strength (dBm) of the device's WiFi connection (Use Android's WifiInfo class)
     * And create a Timer to refresh its value once each 5 seconds.
     *  */

    TextView signalStrength;

    Timer timer;
    Handler handler;

    WifiManager mainWifi;
    WifiInfo currentWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step);

        signalStrength = findViewById(R.id.signalStrength);

        // Refresh activity every 5 sec
        handler = new Handler();
        timer = new Timer();
        TimerTask doTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            Toast.makeText(FirstStep.this, "refresh", Toast.LENGTH_SHORT).show();
                            signalStrength.setText(String.valueOf(getSignalStrength()));
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doTask, 0, 5000);

    }

    // Returns the received signal strength
    private int getSignalStrength() {
        mainWifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        currentWifi = mainWifi.getConnectionInfo();

        return currentWifi.getRssi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }
}
