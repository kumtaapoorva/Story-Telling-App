package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s6 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s6);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "A fox passing through the jungle smells something sweet." +
                        "It follows the scent to find rows of grapes high above in the vines." +
                        "Oh, wouldn’t it be nice to each a bunch of these delicious grapes?” the fox said." +
                        "It jumped this way and that way trying to catch a bunch of grapes." +
                        "It jumped as high as it could. But, the fox couldn’t reach any bunch of grapes." +
                        "Tired from all the jumping, the fox decided to rest for a bit." +
                        "Oh these grapes, wish I could reach them. I will try one more time!” whined the fox aloud." +
                        "It tried again to jump as high as it could muster." +
                        "But, the grapes remained unreachable." +
                        "Maybe the grapes are not sweet but they are sour!” said the fox." +
                        "It turned around and walked away in a sour mood!" +
                        "Moral of the story:" +
                        "It is easy to give up on doing something but it takes hard work and determination to reach goals. When one cannot attain it, one becomes bitter about it.";
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
