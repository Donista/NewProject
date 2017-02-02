package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    private Button favoriteButton;
    private EditText searchText;
    private Button showButton;
    private ListView listView;
    private GrantsListAdapter grantsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        favoriteButton = (Button)findViewById(R.id.favoriteButton);
        searchText = (EditText)findViewById(R.id.searchText);
        showButton = (Button)findViewById(R.id.showButton);
        listView = (ListView)findViewById(R.id.listView);
        grantsListAdapter = new GrantsListAdapter(HomePageActivity.this);
        listView.setAdapter(grantsListAdapter);


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent intent=new Intent(HomePageActivity.this, ShowAll.class);
                        startActivity(intent);
                    }
        });
    }

}
