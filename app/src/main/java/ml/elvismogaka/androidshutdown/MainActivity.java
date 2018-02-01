package ml.elvismogaka.androidshutdown;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView shutdown;
    private TextView shutdowntext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shutdown= findViewById(R.id.shutdown);
        shutdowntext= findViewById(R.id.shutdowntext);




        shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Process proc = Runtime.getRuntime()
                            .exec(new String[]{ "su", "-c", "reboot -p" });


                    proc.waitFor();
                    shutdown.setColorFilter(getResources().getColor(R.color.colorPrimary));
                    Toast.makeText(getApplicationContext(),"Shutting down ...",Toast.LENGTH_LONG).show();

                } catch (Exception ex) {

                    Toast.makeText(getApplicationContext(),"This application only works with rooted devices. Root your device to be able to use this application",Toast.LENGTH_LONG).show();

                    ex.printStackTrace();
                }


            }
        });
    }

}
