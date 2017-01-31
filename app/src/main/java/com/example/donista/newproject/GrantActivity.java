package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GrantActivity extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;
    private String id;


    private TextView singleGrantView;



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

        singleGrantView=(TextView)findViewById(R.id.singleGrantView);

        grantsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Grant grant=dataSnapshot.getValue(Grant.class);
                singleGrantView.append(grant.getGrantName()+"\n" +
                                        grant.getGrantDescription()+"\n" +
                                        grant.getTags()+"\n"+
                                        grant.getGrantDeadline());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    };

    }


