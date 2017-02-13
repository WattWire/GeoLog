package net.wattwire.geolog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mConditionText;
    Button mButtonSunny;
    Button mButtonRainy;

    // Get reference to "Root of Tree" in the Firebase .json file"
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("condition");

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI Elements

        mConditionText = (TextView) findViewById(R.id.textCondition);
        mButtonSunny = (Button) findViewById(R.id.buttonSunny);
        mButtonRainy = (Button) findViewById(R.id.buttonFoggy);
    }

    @Override

    protected void onStart() {

        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
                //*** "Anonymous Inner Class"...is ValueEventListener...
                @Override
                // "Gets fired anytime the 'condition' field ges updated in the database"

                // dataSnapshot "will contain your data and other useful methods"

                public void onDataChange(DataSnapshot dataSnapshot) {

                    // ...So now let's synchronize dataSnapshot with the TextView conditionText
                    String ourText = dataSnapshot.getValue(String.class);
                    mConditionText.setText(ourText);

                }

                @Override
                // "In case we run into any errors"...
                public void onCancelled(DatabaseError databaseError) {

                }
            });


    }
}
