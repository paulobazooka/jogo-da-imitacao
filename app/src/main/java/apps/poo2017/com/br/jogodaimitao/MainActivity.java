package apps.poo2017.com.br.jogodaimitao;

import android.app.ActionBar;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import apps.poo2017.com.br.jogodaimitao.speechtotext.SpeechToText;
import apps.poo2017.com.br.jogodaimitao.viewholder.ViewHolder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public ViewHolder mViewHolder;
    private boolean pressed_button = false;
    private SpeechToText speechToText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speechToText = new SpeechToText(this);
        mViewHolder = new ViewHolder();

        this.mViewHolder.actionBar = (ActionBar) getActionBar();
        this.mViewHolder.imageButton = (ImageButton) findViewById(R.id.imageButton);
        this.mViewHolder.textView = (TextView) findViewById(R.id.textView);

        if(!pressed_button){
            this.mViewHolder.imageButton.setBackgroundResource(R.mipmap.microphone);
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
                    mViewHolder.imageButton.setBackgroundResource(R.mipmap.rec);
                    speechToText.speechOn();
                    pressed_button = true;
                }else{
                    mViewHolder.imageButton.setBackgroundResource(R.mipmap.microphone);
                    speechToText.speechStop();
                    pressed_button = false;
                }
                break;
        }
    }
}
