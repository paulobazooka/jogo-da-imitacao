package apps.poo2017.com.br.jogodaimitao.constats;

/**
 * Enum para controle dos comandos de voz
 */

public enum Comandos {

    MUDAR_A_COR("mudar a cor"),
    MUDAR_COR("mudar cor"),
    TROCAR_A_COR("trocar a cor"),
    TROCAR_COR("trocar cor"),
    AMARELO("amarelo"),
    AZUL_CLARO("azul claro"),
    AZUL_ESCURO("azul escuro"),
    VERMELHO("vermelho"),
    VERDE("verde");



    String valor;

    Comandos(String valor){
        this.valor = valor;
    }


    public String getComando(){
        return this.valor;
    }
}
