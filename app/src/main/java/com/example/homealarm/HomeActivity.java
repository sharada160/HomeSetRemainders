package com.example.homealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lst;
    String[] months = new String[]{"Insurance", "Bills", "Loan", "Credit", "AutomobileExpenditure", "Rent"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lst = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,months);
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view;
        Intent mySuperIntent = new Intent(HomeActivity.this, DataActivity.class);
        startActivity(mySuperIntent);
    }

}

