package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class s5 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s5);

        tts = new TextToSpeech(this, this);

        Button speakButton = findViewById(R.id.speak_button);
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "There lived a goose, special one as that, in a lake. It had beautiful golden feathers." +
                        "Near the lake lived an old woman with her daughters. Even though they worked hard, they remained poor." +
                        "One day, the goose thought: Maybe I can give one golden feather every day so that these women can sell it and have enough money to live." +
                        "The next day, the goose went to the old woman." +
                        "I have nothing to give you!” said the old woman." +
                        "But, I have something for you!” said the goose and explained what she can do!" +
                        "The old woman and her daughters went to the market to sell the golden feather. That day, they came back happy with enough money on hand." +
                        "Day after day, the goose continued to help the old woman and her daughters. The daughters loved to play with the bird and would take care of it on rainy and cold days!" +
                        "As time went by, the old woman became more greedy! How can one feather help her?" +
                        "When the goose comes by tomorrow, we should pluck all of its feathers!” she told her daughters." +
                        "Aghast, they refused to help her with this." +
                        "The next day, the old woman waited for the goose to arrive. As soon as the bird arrived, it held by its next and began to pluck at its feathers." +
                        "As soon as she plucked them, the feathers turned white. The old woman wailed and let go of the goose." +
                        "You have been greedy! When you plucked my golden feathers without my wish, they turned white!" +
                        "The angry goose flew away never to be seen again!" +
                        "Moral of the story" +
                        "Too much greed leads to a lot of loss. It is good to not steal from others or wish for others out of selfishness.";
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
