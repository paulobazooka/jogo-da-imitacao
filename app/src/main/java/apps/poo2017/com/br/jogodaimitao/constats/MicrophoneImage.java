package apps.poo2017.com.br.jogodaimitao.constats;

import apps.poo2017.com.br.jogodaimitao.R;

/**
 * Enum para padronizar as imagens possíveis para carregamento do microfone
 */

public enum MicrophoneImage {
    NORMAL_MODE(R.mipmap.microphone),
    REC_MODE(R.mipmap.rec);

    int mic;

    MicrophoneImage(int mic){
        this.mic = mic;
    }

    public int getMicrophoneId(){
        return this.mic;
    }
}
