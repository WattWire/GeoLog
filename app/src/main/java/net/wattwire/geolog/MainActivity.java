package net.wattwire.geolog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mConditionText;
    Button mButtonSunny;
    Button mButtonRainy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI Elements

        mConditionText = findViewById(R.id.C.id)


    }
}
