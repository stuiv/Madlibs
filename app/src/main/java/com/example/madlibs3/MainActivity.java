package com.example.madlibs3;

import android.content.Intent;
import android.content.res.AssetManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choose_words(View view) {

        RadioGroup stories = findViewById(R.id.radioStories);

        int story_ID = stories.getCheckedRadioButtonId();
        String storyResource = "madlib0_simple.txt";

        switch(story_ID) {
            case R.id.radioTarzan:
                storyResource = "madlib1_tarzan.txt";
                break;
            case R.id.radioUniversity:
                storyResource = "madlib2_university.txt";
                break;
            case R.id.radioClothes:
                storyResource = "madlib3_clothes.txt";
                break;
            case R.id.radioDance:
                storyResource = "madlib4_dance.txt";
                break;
            default:
                storyResource = "madlib0_simple.txt";
        }

        AssetManager assetManager = getResources().getAssets();
        try {
            InputStream inputStream = assetManager.open(storyResource);
            Story story = new Story(inputStream);

            Intent intent = new Intent(this, choose_words.class);
            intent.putExtra("storyline", story);
            startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
