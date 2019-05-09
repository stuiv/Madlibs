package com.example.madlibs3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class show_story extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("storyline");

        TextView storyText = findViewById(R.id.storyText);
        storyText.setText(story.toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
