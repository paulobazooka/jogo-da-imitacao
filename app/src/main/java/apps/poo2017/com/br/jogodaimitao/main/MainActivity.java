package apps.poo2017.com.br.jogodaimitao.main;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.constants.Cores;
import apps.poo2017.com.br.jogodaimitao.constants.MicrophoneImage;
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
        mViewHolder = ViewHolder.getInstance();

        //
        this.mViewHolder.imageButton = (ImageButton) findViewById(R.id.imageButton);
        this.mViewHolder.textView = (TextView) findViewById(R.id.textView);
        this.mViewHolder.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.mViewHolder.progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);

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
                    mViewHolder.progressBar.setProgress(0);
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
