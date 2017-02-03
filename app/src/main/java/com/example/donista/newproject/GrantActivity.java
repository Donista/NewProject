package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GrantActivity extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;
    private String id;



    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView deadlineTextView;
    private TextView tagsTextView;
    private TextView linkTextView;
    private Button saveButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant);

        Intent intent=getIntent();
        id=intent.getExtras().getString("grantId");

        //initiaiza Firebase database and reference

        grantDB=(FirebaseDatabase.getInstance());
        grantsReference=grantDB.getReference().child("grants").child(id);

        //initialize interface

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
        deadlineTextView = (TextView)findViewById(R.id.deadlineTextView);
        tagsTextView = (TextView)findViewById(R.id.tagsTextView);
        linkTextView = (TextView)findViewById(R.id.linkTextView);
        saveButton = (Button)findViewById(R.id.saveButton);

        nameTextView.setText(nameTextView.getText().toString());
        descriptionTextView.setText(descriptionTextView.getText().toString());
        deadlineTextView.setText(deadlineTextView.getText().toString());
        tagsTextView.setText(tagsTextView.getText().toString());
        linkTextView.setText(linkTextView.getText().toString());

    };

    }


