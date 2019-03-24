package com.example.msit_placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class CompanyInfo extends AppCompatActivity {
//    Intent intent = getIntent();
//    Bundle Company_Info = intent.getExtras();

//    String name = Company_Info.getString("CompanyName");
//    Log.i("hello",zzz/+" ");
//    Log.i("hello", "name");


//    String web1 = Company_Info.getString("Website");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_info);
        Intent intent = getIntent();
        Bundle Company_Info = intent.getExtras();
        TextView cn = (TextView) findViewById(R.id.tv1);
        cn.setText(Company_Info.getString("CompanyName"));

        TextView cn2 = (TextView) findViewById(R.id.tv2);
        cn2.setText(Company_Info.getString("Website"));

        TextView cn3 = (TextView) findViewById(R.id.tv3);
        cn3.setText(Company_Info.getString("Headquarters"));

        TextView cn4 = (TextView) findViewById(R.id.tv4);
        cn4.setText(Company_Info.getString("Size"));

        TextView cn5 = (TextView) findViewById(R.id.tv5);
        cn5.setText(Company_Info.getString("Founded"));

        TextView cn6 = (TextView) findViewById(R.id.tv6);
        cn6.setText(Company_Info.getString("Type"));

        TextView cn7 = (TextView) findViewById(R.id.tv7);
        cn7.setText(Company_Info.getString("Industry"));

        TextView cn8 = (TextView) findViewById(R.id.tv8);
        cn8.setText(Company_Info.getString("Revenue"));

        TextView cn9 = (TextView) findViewById(R.id.tv9);
        cn9.setText(Company_Info.getString("Location"));

        TextView cn10 = (TextView) findViewById(R.id.tv10);
        cn10.setText(Company_Info.getString("Benefits"));

    }


}
