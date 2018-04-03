package com.example.tj.individualassignment42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Bvalues)
        {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }

        if(v.getId() == R.id.Bfind)
        {
            EditText a = (EditText)findViewById(R.id.TFword);

            String str = a.getText().toString();

            String word = helper.searchWord(str);

            if(str.equals(word))
            {
                Intent i = new Intent(MainActivity.this, Results.class);
                i.putExtra("Result", str);
                startActivity(i);
            }
            else
            {
                Intent i = new Intent(MainActivity.this, Results.class);
                i.putExtra("Result", "Word not found");
                startActivity(i);
            }

        }
    }
}
