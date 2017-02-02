package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Favorites extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;


    private ListView favoriteListView;
    private GrantsListAdapter grantsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        favoriteListView=(ListView)findViewById(R.id.favoriteListView);
        grantsListAdapter=new GrantsListAdapter(Favorites.this);


        //initiaiza Firebase database and reference

        grantDB=(FirebaseDatabase.getInstance());
        grantsReference=grantDB.getReference().child("grants");

        favoriteListView.setAdapter(grantsListAdapter);

        //monitoring
        grantsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Grant grant=dataSnapshot.getValue(Grant.class);
                grant.setId(dataSnapshot.getKey());
                grantsListAdapter.add(grant);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        favoriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grant grant=(Grant) grantsListAdapter.getItem(position);
                Intent intent=new Intent(Favorites.this, GrantActivity.class);
                intent.putExtra("grantId",grant.getId());
                startActivity(intent);

            }
        });
    }
}
