package apps.poo2017.com.br.jogodaimitao.constants;

import apps.poo2017.com.br.jogodaimitao.R;

/**
 * Enum para padronizar as imagens possíveis para carregamento do microfone
 */

public enum MicrophoneImage {
    NORMAL_MODE(R.mipmap.microphone),
    REC_MODE(R.mipmap.rec2);

    int mic;

    MicrophoneImage(int mic){
        this.mic = mic;
    }

    public int getMicrophoneId(){
        return this.mic;
    }
}
