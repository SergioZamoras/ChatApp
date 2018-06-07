package com.android.teaching.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
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