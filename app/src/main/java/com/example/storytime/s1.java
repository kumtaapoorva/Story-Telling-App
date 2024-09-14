package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s1 extends AppCompatActivity  implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s1);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "One day in the jungle, the lion lay asleep. A little mouse playing about runs up and down on the sleeping lion." +
                        "“Aaargh!” roared the lion and held up the squeaking little mouse." +
                        "Please let me go! Let me go! I will help you one day for your kindness today!” squealed the little mouse." +
                        "You’re too tiny to help me! Off you go,” said the lion amused as the little mouse ran away." +
                        "A few days go by when the little mouse heard a roar: “Help me!”" +
                        "The little mouse was scared but it walked on and on until it came across the lion caught in the net!" +
                        "I see you need my help now!” it said." +
                        "Please help me!” groaned the lion in pain." +
                        "The little one immediately chewed across the net until the lion was free." +
                        "From that day on the lion and the mouse remained friends!";
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
