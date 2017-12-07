package apps.poo2017.com.br.jogodaimitao.control;

/**
 * Classe para receber e fornecer o texto falado
 */

public class TextUpdate {

    private String text = "";
    private static TextUpdate textUpdate;

    protected TextUpdate(){

    }


    public static TextUpdate getInstance(){
        if(textUpdate == null){
            textUpdate = new TextUpdate();
        }

        return textUpdate;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
