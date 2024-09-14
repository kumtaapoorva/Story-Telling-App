package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s4 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s4);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "In Vijayanagara, there were many incidents of thefts lately. King Krishnadevaraya was worried about the thieves." +
                        "Everyone in the court, including Tenali Rama, seemed worried!" +
                        "That evening as he walked back from the court to his home, he noticed two figures hidden behind the big mango tree near the well in his garden." +
                        "Hmmm! I must teach them a lesson, he thought as he reached home." +
                        "Once home, he spoke so loudly that the thieves were startled, but could hear what he was telling his wife:" +
                        "… it’s not safe to keep our jewellery at home. Please fill our iron trunk with your jewellery and we dropped it into the well for safekeeping!" +
                        "As the robbers sniggered at the idea of an idiot’s plan, Tenali Rama whispered to his wife that thieves were hiding in the garden. He asks to fill the trunk with stones and pots." +
                        "Once the trunk was filled, Tenali Rama and his wife drag the trunk and drop it in the well." +
                        "It will be safe here!” he told his wife loudly." +
                        "The two thieves waited for the people at home to sleep. They had a plan!" +
                        "Each robber took turns to draw water from the well." +
                        "Their excitement soon turned into tiredness and they decided to take a break." +
                        "Just then, someone said:" +
                        "That’s all! The garden is watered, you have done the good deed for the day!" +
                        "The robbers looked around to see Tenali Rama holding a shovel and stick." +
                        "Shocked, they rose and ran away!" +
                        "Not long after, the people of Vijayanagara didn’t complain of any robbery." +
                        "Moral of the story:" +
                        "It is better to stay calm and find a solution to a problem.";
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
