package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s2 extends AppCompatActivity  implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s2);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Once, a group of frogs was roaming around the forest in search of water. Suddenly, two frogs in the group accidentally fell into a deep pit." +
                        "The other frogs worried about their friends in the pit." +
                        "Seeing how deep the pit was, they told the two frogs that there was no way they could escape the deep pit and that there was no point in trying." +
                        "They continued to constantly discourage them as the two frogs tried to jump out of the pit. But keep falling back." +
                        "Soon, one of the two frogs started to believe the other frogs — that they’ll never be able to escape the pit and eventually died after giving up." +
                        "The other frog keeps trying and eventually jumps so high that he escapes the pit. The other frogs were shocked at this and wondered how he did it." +
                        "The difference was that the second frog was deaf and couldn’t hear the discouragement of the group. He simply thought they were cheering him on!" +
                        "Moral of the story:" +
                        "People’s opinion of you will affect you, only if you believe it to be so. It’s better to believe in yourself";
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
