package apps.poo2017.com.br.jogodaimitao.speechtotext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

import apps.poo2017.com.br.jogodaimitao.MainActivity;
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
    private int MINIMUM_LENGTH_FOR_EXTRA_SPEECH_IN_MILLIS = 2000;



    public SpeechToText(MainActivity mainActivity){
        this.mainActivity = mainActivity;

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
    }

    @Override
    public void onBeginningOfSpeech() {
      // Inicio da audição do som
    }

    @Override
    public void onRmsChanged(float rmsdB) {
       // retorna o nível de decibéis do som
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
       // Quando o Buffer estiver cheio
    }

    @Override
    public void onEndOfSpeech() {
       // Fim da audição
    }

    @Override
    public void onError(int error) {
      // metodo que retorna o erro
        Log.d("onError", "");
        speechRecognizer.stopListening();
    }

    @Override
    public void onResults(Bundle results) {
       // retorna o resultado final da audição
    mainActivity.mViewHolder.imageButton.setBackgroundResource(R.mipmap.microphone);
        TexToSpeech texToSpeech = new TexToSpeech(mainActivity);

        texToSpeech.toPronounce(final_text);
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
       // resultados parciais
        ArrayList matches = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String result="";

        if(matches!=null){
            for(int i=0; i <matches.size(); i++){
                result += matches.get(i) + "\n";
            }
        }
        final_text = result;
        mainActivity.mViewHolder.textView.setText(final_text);
    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // evento ativo
    }



    public void speechOn(){
        mainActivity.mViewHolder.textView.setText("");
        speechRecognizer.stopListening();
        speechRecognizer.startListening(intent);
    }

    public void speechStop(){
        speechRecognizer.stopListening();
    }

}
