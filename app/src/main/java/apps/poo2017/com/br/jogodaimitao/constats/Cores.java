package apps.poo2017.com.br.jogodaimitao.constats;

/**
 * Enum para controle das cores do texto
 */

public enum Cores {
    AZUL_ESCURO("dark_blue"),
    AZUL_CLARO("light_blue"),
    VERMELHO("red"),
    AMARELO("yellow"),
    VERDE("green");

    String cor;

    Cores(String cor){
        this.cor = cor;
    }

}
