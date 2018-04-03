package com.example.tj.individualassignment42;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        String result = getIntent().getStringExtra("Result");

        TextView tv = (TextView)findViewById(R.id.TVresults);
        tv.setText(result);
    }

}
