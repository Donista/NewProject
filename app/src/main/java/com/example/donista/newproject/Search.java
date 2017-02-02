package com.example.donista.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Search extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;

    private TextView searchTextView;
    private ListView searchListView;
    private GrantsListAdapter grantsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchListView = (ListView) findViewById(R.id.searchListView);
        searchTextView = (TextView) findViewById(R.id. searchTextView);
        grantsListAdapter=new GrantsListAdapter(Search.this);


    }
}
