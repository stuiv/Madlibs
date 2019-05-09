package com.example.madlibs3;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Locale;


public class choose_words extends AppCompatActivity {

    private Story story;
    private EditText textInput;
    private int placeholdersRemaining;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_words);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("storyline");

        placeholdersRemaining = story.getPlaceholderRemainingCount();
        initiateNextPlaceholder();

    }

    private void initiateNextPlaceholder() {

        TextView placeholderText;
        TextView remainingText;

        placeholderText = findViewById(R.id.text_Word_Type);
        remainingText = findViewById(R.id.text_Words_Left);
        textInput = findViewById(R.id.edit_Text_Word_Input);

        if (placeholdersRemaining > 0){
            placeholderText.setText(story.getNextPlaceholder());
            textInput.setText("");
            remainingText.setText(String.format(Locale.getDefault(), "%1$d words remaining",
                    placeholdersRemaining));

        } else if (story.isFilledIn()) {
            Intent to_story = new Intent(this, show_story.class);
            to_story.putExtra("storyline", story);
            startActivity(to_story);
        }
    }

    public void onWordFilledClick(View view) {

        String filled_word = textInput.getText().toString();

        if (filled_word.length() > 0) {
            placeholdersRemaining--;
            story.fillInPlaceholder(filled_word);
            initiateNextPlaceholder();
        }
    }

    public void Clear_Click(View view) {
        placeholdersRemaining = story.getPlaceholderRemainingCount();
        story.clear();

    }
}
