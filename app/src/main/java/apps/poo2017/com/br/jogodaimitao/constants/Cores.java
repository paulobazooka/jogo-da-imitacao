package apps.poo2017.com.br.jogodaimitao.constants;

import apps.poo2017.com.br.jogodaimitao.R;

/**
 * Enum para controle das cores do texto
 */

public enum Cores {
    AZUL_ESCURO(R.color.dark_blue),
    AZUL_CLARO(R.color.light_blue),
    VERMELHO(R.color.red),
    AMARELO(R.color.yellow),
    VERDE(R.color.green),
    CINZA(R.color.gray),
    PRETO(R.color.black);

    int cor;

    Cores(int cor){
        this.cor = cor;
    }

    public int getCor(){
        return this.cor;
    }

}
