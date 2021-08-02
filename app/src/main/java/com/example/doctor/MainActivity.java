package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayDeque;
import java.util.HashMap;

public
class MainActivity extends AppCompatActivity {
    private EditText mName , mSurname , mdate;
    private Button button , button2 ;
    private FirebaseDatabase  db   = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child( "Users");

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        mName    = findViewById ( R.id.name );
        mSurname = findViewById ( R.id.surname );
        mdate   = findViewById ( R.id.date );
        button   = findViewById ( R.id.button );
        button2  = findViewById ( R.id.button2 );

        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public
            void onClick ( View v ) {
                String                  name    = mName.getText ( ).toString ( );
                String                  email   = mdate.getText ( ).toString ( );
                String                  surname = mSurname.getText ( ).toString ( );



                insertData();
                Toast.makeText ( MainActivity.this , "DATA INSERTED!!" , Toast.LENGTH_SHORT ).show ( );

            }
        } );
        button2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public
            void onClick ( View v ) {
                startActivity ( new Intent ( MainActivity.this , userList.class ) );
            }
        } );

    }

    private
    void insertData ( ) {

        String fname   = mName.getText ( ).toString ( );
        String sname = mSurname.getText ( ).toString ( );
        String mail    = mdate.getText ( ).toString ( );


        user us = new user ( fname , sname , mail );
        root.push ( ).setValue ( us );

        Toast.makeText ( this , "DATA SUCCESSFULLY INSERTED" , Toast.LENGTH_SHORT ).show ( );


    }

}