package com.example.msit_placement;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Company> companyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button ge = (Button)findViewById(R.id.button2);

        Button amazon = (Button)findViewById(R.id.button1);



        Button americanexpress = (Button)findViewById(R.id.button3);

        Button paytm = (Button)findViewById(R.id.button4);


        Button american = (Button)findViewById(R.id.button5);



        Button johncontrols = (Button)findViewById(R.id.button6);



//


        ge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callJson("GE India");
//

            }

//
        });

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("IIIT=H");
                callJson("Amazon");

            }
        });

        american.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callJson("Johnson Controls");

            }
        });

        americanexpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callJson("American Express");

            }
        });

        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Hello", Toast.LENGTH_SHORT).show();

                callJson("Paytm");

            }
        });
        johncontrols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callJson("Johnson Controls");
//
            }
        });
    }
    public  void callJson(String Com) {

        System.out.println("Company : "+Com);
        String json;
        try {
            InputStream is = getAssets().open("Companydatabase.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            JSONObject obj = new JSONObject(json);
            JSONArray m_jarray = obj.getJSONArray(Com);

            Log.i("Json Length", m_jarray.length() + " ");
            JSONObject j_inside = m_jarray.getJSONObject(0);
            System.out.println("MSIT123");
            System.out.println(j_inside.getString("CompanyName"));
            Intent it = new Intent(HomeActivity.this,CompanyInfo.class);
            String namecompany = j_inside.getString("CompanyName");
            System.out.print("ppppp "+namecompany);
            it.putExtra("CompanyName",namecompany);
            it.putExtra("Website",j_inside.getString("Website"));
            it.putExtra("Headquarters",j_inside.getString("Headquarters"));
            it.putExtra("Size",j_inside.getString("Size"));
            it.putExtra("Founded",j_inside.getString("Founded"));
            it.putExtra("Type",j_inside.getString("Type"));
            it.putExtra("Industry",j_inside.getString("Industry"));
            it.putExtra("Revenue",j_inside.getString("Revenue"));
            it.putExtra("Location",j_inside.getString("Location"));
            it.putExtra("Benefits",j_inside.getString("Benefits"));
            startActivity(it);

        } catch(IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
