package apps.poo2017.com.br.jogodaimitao.main;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.constats.MicrophoneImage;
import apps.poo2017.com.br.jogodaimitao.speechtotext.SpeechToText;
import apps.poo2017.com.br.jogodaimitao.texttoespeech.TexToSpeech;
import apps.poo2017.com.br.jogodaimitao.viewholder.ViewHolder;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public ViewHolder mViewHolder;
    private boolean pressed_button = false;
    private SpeechToText speechToText;
    public TexToSpeech texToSpeech;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speechToText = new SpeechToText(this);
        texToSpeech = new TexToSpeech(this);
        mViewHolder = new ViewHolder();

        //
        this.mViewHolder.imageButton = (ImageButton) findViewById(R.id.imageButton);
        this.mViewHolder.textView = (TextView) findViewById(R.id.textView);
        this.mViewHolder.progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if(!pressed_button){
            this.mViewHolder.imageButton.setBackgroundResource(MicrophoneImage.NORMAL_MODE.getMicrophoneId());
        }


        this.mViewHolder.imageButton.setOnClickListener(this);

    }



    // implementação do método onClick para descobrir quem disparou o evento de click
    @Override
    public void onClick(View v) {
        int idView = v.getId();

        switch (idView) {

            case (R.id.imageButton):
                if(!pressed_button){
                    mViewHolder.imageButton.setBackgroundResource(
                            MicrophoneImage.REC_MODE.getMicrophoneId());
                    texToSpeech.stopTalking();
                    speechToText.speechOn();
                    pressed_button = true;
                }else{
                    mViewHolder.imageButton.setBackgroundResource(
                            MicrophoneImage.NORMAL_MODE.getMicrophoneId());
                    texToSpeech.stopTalking();
                    speechToText.speechStop();
                    pressed_button = false;
                }
                break;
        }
    }


    // Sobreposição do método que finaliza/destroi a activity
    @Override
    public void onDestroy(){
        super.onDestroy();
        speechToText.speechStop();
        texToSpeech.stopTalking();
        texToSpeech.destroy();
    }
}
