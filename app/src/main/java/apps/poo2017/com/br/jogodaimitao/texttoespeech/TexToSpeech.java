package apps.poo2017.com.br.jogodaimitao.texttoespeech;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import apps.poo2017.com.br.jogodaimitao.MainActivity;

/**
 * Classe para converter texto em voz
 */

public class TexToSpeech {

    // Objeto da classe que converte texto em voz
    private TextToSpeech textToSpeech;
    private MainActivity mainActivity;
    private Context context;

    public TexToSpeech(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.context = mainActivity.getApplicationContext();
    }


    public void toPronounce(String text){
      textToSpeech.speak(text, 0, null);
    }

    public void stopTalking(){
        textToSpeech.stop();
    }
}
