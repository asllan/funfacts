package com.asllan.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    private static final String TAG = FunFactsActivity.class.getSimpleName();
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout factLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        factTextView = (TextView) findViewById(R.id.factTextView);
        showFactButton = (Button) findViewById(R.id.showFactButton);
        factLayout = (RelativeLayout) findViewById(R.id.activity_fun_facts);

        showFactButton.setOnClickListener(new View.OnClickListener() {
            private FactBook factBook = new FactBook();
            private ColorWheel colorWheel = new ColorWheel();

            @Override
            public void onClick(View v) {
                factTextView.setText(factBook.getFact());
                int randomColor = colorWheel.getColor();
                factLayout.setBackgroundColor(randomColor);
                showFactButton.setTextColor(randomColor);
            }
        });

//        Toast.makeText(FunFactsActivity.this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}
