package com.example.donista.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private EditText grantDeadline;
    private TextView grantsText;


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
        grantDeadline=(EditText)findViewById(R.id.grantDeadline);
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grant grant=new Grant(grantName.getText().toString(),grantDescription.getText().toString(),grantDeadline.getText().toString());
                grantsReference.push().setValue(grant);

            }

        });
        //monitoring
        grantsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Grant grant=dataSnapshot.getValue(Grant.class);
                grantsText.append(grant.getGrantName()+"\n");
                grantsText.append(grant.getGrantDescription()+"\n\n\n");

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


    }
}
