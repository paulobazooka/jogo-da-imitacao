package apps.poo2017.com.br.jogodaimitao.control;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.constants.Comandos;
import apps.poo2017.com.br.jogodaimitao.constants.Cores;
import apps.poo2017.com.br.jogodaimitao.main.MainActivity;

/**
 * Classe para controle de voz
 */

public class VoiceControl {

    // Objeto para receber a main
    private MainControl mainControl;


    public VoiceControl(MainActivity mainActivity){
        mainControl = new MainControl(mainActivity);
    }


    public void takesCommand(String command){

          if(command.contains(Comandos.MUDAR_A_COR.getComando()) ||
                  command.contains(Comandos.TROCAR_A_COR.getComando()) ||
                        command.contains(Comandos.TROCAR_COR.getComando()) ||
                              command.contains(Comandos.MUDAR_COR.getComando())){
              Log.e("Comando:", command);

              if(command.contains(Comandos.AMARELO.getComando())){
                 mainControl.changeColors(Cores.AMARELO.getCor());
                 Log.e("Cor:", "Amarelo");
             }else
             if(command.contains(Comandos.VERMELHO.getComando())){
                 mainControl.changeColors(Cores.VERMELHO.getCor());
                 Log.e("Cor:", "Vermelho");
             }else
             if(command.contains(Comandos.VERDE.getComando())){
                 mainControl.changeColors(Cores.VERDE.getCor());
                 Log.e("Cor:", "Verde");
             }else
             if(command.contains(Comandos.AZUL_CLARO.getComando())){
                 mainControl.changeColors(Cores.AZUL_CLARO.getCor());
                 Log.e("Cor:", "Azul Claro");
             }else
             if(command.contains(Comandos.AZUL_ESCURO.getComando())){
                 mainControl.changeColors(Cores.AZUL_ESCURO.getCor());
                 Log.e("Cor:", "Azul Escuro");
             }else
             if(command.contains(Comandos.CINZA.getComando())){
                 mainControl.changeColors(Cores.CINZA.getCor());
                 Log.e("Cor:", "Cinza");
             }else
             if(command.contains(Comandos.PRETO.getComando())){
                 mainControl.changeColors(Cores.PRETO.getCor());
                 Log.e("Cor:", "Preto");
             }

          }
    }

}
