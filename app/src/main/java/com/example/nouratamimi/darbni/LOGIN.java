package com.example.nouratamimi.darbni;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LOGIN extends AppCompatActivity {
    private EditText UserName ;
    private EditText password ;
    private Button logIn;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        logIn=(Button)findViewById(R.id.login);
        mQueue = Volley.newRequestQueue(this);


        logIn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view ) {
                JsonLogin();

            }
    });

    }


   private void JsonLogin(){

       String url = "h:\\root\\home\\hatoun-001\\www\\site1\\login.php";

       JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
               new Response.Listener<JSONObject>() {
                   @Override
                   public void onResponse(JSONObject response) {
                       try{
                       JSONObject jsonObject = new JSONObject(response);
                       int statusCode = jsonObject.getInt("status_code")
                       if (statusCode == 200) {
                           Intent a = new Intent(LOGIN.this, LOGIN.class);
                           startActivity(a);

                       }
                       else {
                           print("Error")
                       }
                   }
                       catch {

                       }
               }

               },new Response.ErrorListener() {

           @Override
           public void onErrorResponse(VolleyError error) {
               error.printStackTrace();
           }
       });

       mQueue.add(request);
   }

}
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
