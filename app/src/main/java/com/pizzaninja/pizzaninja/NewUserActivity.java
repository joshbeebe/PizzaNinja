package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public void Submit(View view) {
        EditText textID = (EditText) findViewById(R.id.textUser);
        EditText textPassword1 = (EditText) findViewById(R.id.textPassword1);
        EditText textPassword2 = (EditText) findViewById(R.id.textPassword2);
        if (textID.getText().length() > 3)
        {
            if (textPassword1.getText().length() > 3)
            {
                String pw1 = textPassword1.getText().toString();
                String pw2 = textPassword2.getText().toString();
                if (pw1.equals(pw2))
                {
                    String login = textID.getText() + ":" + textPassword1.getText();
                    Intent intent = new Intent();
                    intent.putExtra("newlogin", login);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Passwords must match!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "Password must be longer than 3 characters!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "User ID must be longer than 3 characters!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void Cancel(View view)
    {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
