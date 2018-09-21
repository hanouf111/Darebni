package com.example.nouratamimi.darbni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchScreen extends AppCompatActivity {

    private Button logIn;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        logIn=(Button)findViewById(R.id.logIn);
        register=(Button)findViewById(R.id.register);

        logIn.setOnClickListener(new View.OnClickListener()

        {
   @Override
            public void onClick(View view ){
                Intent a = new Intent(LaunchScreen.this, LOGIN.class);
       startActivity(a);
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view ){
                Intent a = new Intent(LaunchScreen.this, registeration.class) ;
                      startActivity(a);
            }
        });

    }




}
