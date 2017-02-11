package com.example.donista.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //firebase variables
    private FirebaseDatabase grantDB;
    private DatabaseReference grantsReference;

    //interface
    private EditText grantName;
    private EditText grantDescription;
    private Button publishButton;
    private EditText grantDeadlineEdit;
    private EditText grantTagsEdit;
    private ListView grantListView;
    private GrantsListAdapter grantsListAdapter;
    private Button transButton;
    private EditText linkEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiaiza Firebase database and reference

        grantDB=(FirebaseDatabase.getInstance());
        grantsReference=grantDB.getReference().child("grants");

        //intialitize interface
        grantName=(EditText)findViewById(R.id.grantName);
        grantDescription=(EditText)findViewById(R.id.grantDescription);
        publishButton=(Button)findViewById(R.id.publishButton);
        grantTagsEdit=(EditText) findViewById(R.id.grantTagsEdit);
        grantDeadlineEdit=(EditText)findViewById(R.id.grantDeadlineEdit);
        grantListView=(ListView)findViewById(R.id.grantListView);
        grantsListAdapter = new GrantsListAdapter(MainActivity.this);
        grantListView.setAdapter(grantsListAdapter);
        transButton=(Button)findViewById(R.id.transButton);
        linkEditText = (EditText)findViewById(R.id.linkEditText);



        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grant grant=new Grant(grantName.getText().toString(),
                                      grantDescription.getText().toString(),
                                      grantDeadlineEdit.getText().toString(),
                                      grantTagsEdit.getText().toString(),
                                      linkEditText.getText().toString());

                grantsReference.push().setValue(grant);
            }

        });
        //monitoring
        grantsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Grant grant=dataSnapshot.getValue(Grant.class);
                grant.setId(dataSnapshot.getKey());
                grantsListAdapter.add(grant);


                /*grantsText.append(grant.getGrantName()+"\n");
                grantsText.append(grant.getGrantDescription()+"\n\n\n");*/

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

        grantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grant grant=(Grant) grantsListAdapter.getItem(position);
                Intent intent=new Intent(MainActivity.this, GrantActivity.class);
                intent.putExtra("grantId",grant.getId());
                startActivity(intent);
            }
        });

        transButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });


    }
}
