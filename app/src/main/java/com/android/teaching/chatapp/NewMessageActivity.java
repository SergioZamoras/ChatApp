package com.android.teaching.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
    }

        private String messageText;
        private String messageUser;
        private long messageTime;

        public NewMessageActivity(String messageText, String messageUser) {
            this.messageText = messageText;
            this.messageUser = messageUser;


        }


        public String getMessageText() {
            return messageText;
        }

        public void setMessageText(String messageText) {
            this.messageText = messageText;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public void setMessageUser(String messageUser) {
            this.messageUser = messageUser;
        }

        public long getMessageTime() {
            return messageTime;
        }

        public void setMessageTime(long messageTime) {
            this.messageTime = messageTime;
        }
    }

