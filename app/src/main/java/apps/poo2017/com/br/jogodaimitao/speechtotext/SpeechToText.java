package apps.poo2017.com.br.jogodaimitao.speechtotext;

import android.os.Bundle;
import android.speech.RecognitionListener;

/**
 * Classe para converter voz em texto
 */

public class SpeechToText implements RecognitionListener{

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
    }

    @Override
    public void onResults(Bundle results) {
       // retorna o resultado final da audição
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
       // resultados parciais
    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // evento ativo
    }
}
