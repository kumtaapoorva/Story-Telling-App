package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s3 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s3);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "During the summer season, many ponds and lake beds lay dry. Birds flew far and wide in search of water." +
                        "such bird was this crow who saw a pot filled with water at the bottom." +
                        "It try to reach for the water with its beak, but the neck of the pot was narrow." +
                        "The crow tried to jostle the pot again and again but to no avail." +
                        "Soon, as the crow was too tired to try. It was too thirsty to fly." +
                        "Suddenly, the thirsty crow had an idea!" +
                        "Plop! Plip! Plop! It began to drop pebbles into the pot." +
                        "Slowly, the water rose up and up." +
                        "The crow continued to drop the pebbles until its beak could reach the water." +
                        "At last, the thirsty crow was able to quench its thirst!" +
                        "Moral of the story:" +
                        "No matter what you face, patience and intelligence can always help you find your solution! Never give up easily!";
                convertTextToSpeech(text);
            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language not supported
                // Handle the error accordingly
            } else {
                // Text-to-speech initialization successful
            }
        } else {
            // Text-to-speech initialization failed
            // Handle the error accordingly
        }
    }

    private void convertTextToSpeech(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "UtteranceID");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
