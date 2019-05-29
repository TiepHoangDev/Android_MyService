package dell.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_status = findViewById(R.id.editview_status);
        String error = "";
        if (playService(error)) {
            setStatus("Service running...");
        } else {
            setStatus("error = " + error);
        }
    }

    void setStatus(String s) {
        textview_status.setText(s);
    }

    boolean playService(Object error) {
        try {
            startService(new Intent(this, ToastService.class));
            return true;
        } catch (Exception ex) {
            error = ex.getMessage();
            return false;
        }
    }

}
