package com.android.teaching.chatapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;



public class ChatActivity extends AppCompatActivity {

    private FirebaseListAdapter<NewMessageActivity> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.input);


                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getDisplayName())
                        );

                // LIADA GRANDE
                input.setText("");
            }
        });


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
    public void onClick(View view) {


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ChatActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ChatActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ChatActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ChatActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ChatActivity", "onDestroy");
    }
}
}



