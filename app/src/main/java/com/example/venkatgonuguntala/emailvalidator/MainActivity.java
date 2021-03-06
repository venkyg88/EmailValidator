package com.example.venkatgonuguntala.emailvalidator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class MainActivity extends Activity {

    //Logger for this class
    private static final String TAG = "MainActivity";

    //Input field where user enters his email address
    private EditText mEmailText;

    private TextView mResultText;

    //The validator for email input field.
    private EmailValidatorClass emailValidatorClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailText = (EditText) findViewById(R.id.emailInput);
        mResultText = (TextView) findViewById(R.id.show_text_view);
        
        emailValidatorClass = new EmailValidatorClass();
        mEmailText.addTextChangedListener(emailValidatorClass);
    }

    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) {
        // Don't save if the fields do not validate.
        if (!emailValidatorClass.ismIsValid()) {
            mEmailText.setError("Invalid email");
            mResultText.setText("");
            Log.w(TAG, "Not saving personal information: Invalid email");
            return;
        }
        //mEmailText.setError("Valid email");
        mResultText.setText("Email format is good");

        // Get the text from the input fields.
        //String email = mEmailText.getText().toString();

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
