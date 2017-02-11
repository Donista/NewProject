package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class GrantActivity extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;
    private String id;



    private TextView grantName;
    private TextView grantDescription;
    private TextView grantDeadlineEdit;
    private TextView grantTagsEdit;
    private TextView linkTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant);

        Intent intent=getIntent();
        id=intent.getExtras().getString("grantId");

        //initiaiza Firebase database and reference

        grantDB=(FirebaseDatabase.getInstance());
        grantsReference=grantDB.getReference().child("grants").child(id);

        grantName = (TextView)findViewById(R.id.grantName);
        grantDescription = (TextView)findViewById(R.id.grantDescription);
        grantDeadlineEdit = (TextView)findViewById(R.id.grantDeadlineEdit);
        grantTagsEdit = (TextView)findViewById(R.id.grantTagsEdit);
        linkTextView = (TextView)findViewById(R.id.linkTextView);

        //initialize interface

        grantsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Grant grant = dataSnapshot.getValue(Grant.class);

                grantName.setText(grant.getGrantName().toString());
                grantDescription.setText(grant.getGrantDescription().toString());
                grantDeadlineEdit.setText(grant.getGrantDeadlineEdit().toString());
                grantTagsEdit.setText(grant.getGrantTagsEdit().toString());
                linkTextView.setText(grant.getLinkTextView().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    };

    }


