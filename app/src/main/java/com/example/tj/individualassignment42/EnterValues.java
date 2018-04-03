package com.example.tj.individualassignment42;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entervalues);
    }

    public void onSubmitClick(View v)
    {
        if(v.getId() == R.id.Bsubmit)
        {
            EditText firstWord = (EditText)findViewById(R.id.TFword1);
            EditText secondWord = (EditText)findViewById(R.id.TFword2);

            String firststr = firstWord.getText().toString();
            String secondstr = secondWord.getText().toString();


            Contact c = new Contact();
            c.setFirst(firststr);
            c.setSecond(secondstr);

            helper.insertContact(c);

            Intent i = new Intent(EnterValues.this, MainActivity.class);
            startActivity(i);

        }
    }
}
