package com.android.teaching.chatapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;



public class ChatActivity extends AppCompatActivity {

    private FirebaseListAdapter<NewMessageActivity> adapter;
    RelativeLayout activity_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    private void displayChatMessage() {

        ListView listOfMessage = (ListView) findViewById(R.id.list_of_message);
        adapter = new FirebaseListAdapter<NewMessageActivity>(this, NewMessageActivity.class, R.layout.activity_new_message,
                FirebaseDatabase.getInstance().getReference()) {


            protected void NewMessageActivity(View v, NewMessageActivity model, int position) {


                TextView messageText, messageUser;
                messageText = (TextView) v.findViewById(R.id.message_text);
                messageUser = (TextView) v.findViewById(R.id.message_user);


                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

            }
        };
        listOfMessage.setAdapter(adapter);
    }
}



