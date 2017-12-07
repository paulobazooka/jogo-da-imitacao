package apps.poo2017.com.br.jogodaimitao.speechtotext;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

import apps.poo2017.com.br.jogodaimitao.control.TextUpdate;
import apps.poo2017.com.br.jogodaimitao.control.VoiceControl;
import apps.poo2017.com.br.jogodaimitao.main.MainActivity;
import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.texttoespeech.TexToSpeech;

/**
 * Classe para converter voz em texto
 */

public class SpeechToText implements RecognitionListener{

    private MainActivity mainActivity = null;
    private String final_text = "";
    private SpeechRecognizer speechRecognizer;
    private Intent intent;
    private int MINIMUM_LENGTH_FOR_EXTRA_SPEECH_IN_MILLIS = 3000;
    private Iniciar iniciar;
    private TextUpdate textUpdate;


    public SpeechToText(MainActivity mainActivity){
        this.mainActivity = mainActivity;

        textUpdate = new TextUpdate();
        iniciar = new Iniciar();

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(mainActivity.getApplicationContext());
        speechRecognizer.setRecognitionListener(this);

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, mainActivity.getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, MINIMUM_LENGTH_FOR_EXTRA_SPEECH_IN_MILLIS);
        // intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ouvindo...");
    }



    @Override
    public void onReadyForSpeech(Bundle params) {
      // Pronto para gravar o som
        Log.d("onReadyForSpeech", "" );
    }

    @Override
    public void onBeginningOfSpeech() {
      // Inicio da audição do som
        Log.d("onBeginningOfSpeech()", "" );
    }

    @Override
    public void onRmsChanged(float rmsdB) {
       // retorna o nível de decibéis do som
        Log.d("onRmsChanged", "" + rmsdB);

        int vol = (int)rmsdB + 2;
        vol = vol * 8;

        mainActivity.mViewHolder.progressBar.setProgress(vol);
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
       // Quando o Buffer estiver cheio
        Log.d("onBufferReceived", "" );
    }

    @Override
    public void onEndOfSpeech() {
       // Fim da audição
        Log.d("onEndOfSpeech()", "" );
    }

    @Override
    public void onError(int error) {
      // metodo que retorna o erro
        Log.d("onError", "");
    }

    @Override
    public void onResults(Bundle results) {
         // retorna o resultado final da audição
        mainActivity.mViewHolder.imageButton.setBackgroundResource(R.mipmap.microphone);
        mainActivity.texToSpeech.toPronounce(textUpdate.getText());

        VoiceControl voiceControl = new VoiceControl(mainActivity);
        voiceControl.takesCommand(textUpdate.getText());

        iniciar.parar();
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
       // resultados parciais
        ArrayList matches = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        final_text = "";

        if(matches!=null){
            for(int i=0; i <matches.size(); i++){
                final_text += matches.get(i) + "\n";
            }
        }

        textUpdate.setText(final_text);
        mainActivity.mViewHolder.textView.setText(textUpdate.getText());
    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // evento ativo
    }



    public void speechOn(){
        mainActivity.mViewHolder.textView.setText("");
        iniciar.disparar();
    }

    public void speechStop(){
            iniciar.parar();
    }



    // Classe para disparar uma thread
    private class Iniciar extends Thread{

        private void disparar() {
            this.parar();
            Log.d("Thread","disparar");
            speechRecognizer.startListening(intent);
        }

        private void parar(){
            Log.d("Thread","parar");
            speechRecognizer.stopListening();
            this.interrupt();
        }
    }

}
