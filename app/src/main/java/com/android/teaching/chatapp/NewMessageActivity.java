package com.android.teaching.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.firebase.database.FirebaseDatabase;

public class NewMessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
    }

        private String messageText;
        private String messageUser;


        public NewMessageActivity(String messageText, String messageUser) {
            this.messageText = messageText;
            this.messageUser = messageUser;



            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText input = (EditText)findViewById(R.id.input);

                    //A saber que ostia me falta aquí

                    FirebaseDatabase.getInstance()
                            .getReference()
                            .push()
                            .setValue(new NewMessageActivity(input.getText().toString(),
                                    FirebaseAuth.getInstance()
                                            .getCurrentUser()
                                            .getDisplayName())
                            );

                    input.setText("");
                }
            });
        }


        public String getMessageText() {
            return messageText;
        }

        public void setMessage_Text(String messageText) {
            this.messageText = messageText;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public void setMessageUser(String messageUser) {
            this.messageUser = messageUser;
        }

    }

