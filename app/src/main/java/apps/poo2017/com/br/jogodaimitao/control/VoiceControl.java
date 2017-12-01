package apps.poo2017.com.br.jogodaimitao.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.constats.Comandos;
import apps.poo2017.com.br.jogodaimitao.constats.Cores;
import apps.poo2017.com.br.jogodaimitao.main.MainActivity;

/**
 * Classe para controle de voz
 */

public class VoiceControl {

    // Objeto para receber a main
    MainActivity mainActivity;
    Context context;
    MainControl mainControl;


    public VoiceControl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.context = mainActivity.getApplicationContext();
        mainControl = new MainControl(mainActivity);
    }


    public void takesCommand(String command){

          if(command.contains(Comandos.MUDAR_A_COR.getComando()) ||
                  command.contains(Comandos.TROCAR_A_COR.getComando()) ||
                        command.contains(Comandos.TROCAR_COR.getComando()) ||
                              command.contains(Comandos.MUDAR_COR.getComando())){
              Log.e("Comando:", command);

              if(command.contains(Comandos.AMARELO.getComando())){
                // mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.yellow));
                 mainControl.changeColorActionBar(Cores.AMARELO.getCor());
                 mainControl.changeColorText(Cores.AMARELO.getCor());
                 mainControl.changeColorStatusBar(Cores.AMARELO.getCor());
                 Log.e("Cor:", "Amarelo");
             }else
             if(command.contains(Comandos.VERMELHO.getComando())){
                // mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.red));
                 mainControl.changeColorActionBar(Cores.VERMELHO.getCor());
                 mainControl.changeColorText(Cores.VERMELHO.getCor());
                 mainControl.changeColorStatusBar(Cores.VERMELHO.getCor());
                 Log.e("Cor:", "Vermelho");
             }else
             if(command.contains(Comandos.VERDE.getComando())){
                // mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.green));
                 mainControl.changeColorActionBar(Cores.VERDE.getCor());
                 mainControl.changeColorText(Cores.VERDE.getCor());
                 mainControl.changeColorStatusBar(Cores.VERDE.getCor());
                 Log.e("Cor:", "Verde");
             }else
             if(command.contains(Comandos.AZUL_CLARO.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.light_blue));
                 mainControl.changeColorText(Cores.AZUL_CLARO.getCor());
                 mainControl.changeColorStatusBar(Cores.AZUL_CLARO.getCor());
                 Log.e("Cor:", "Azul Claro");
             }else
             if(command.contains(Comandos.AZUL_ESCURO.getComando())){
                // mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.dark_blue));
                 mainControl.changeColorActionBar(Cores.AZUL_ESCURO.getCor());
                 mainControl.changeColorText(Cores.AZUL_ESCURO.getCor());
                 mainControl.changeColorStatusBar(Cores.AZUL_ESCURO.getCor());
                 Log.e("Cor:", "Azul Escuro");
             }
          }
    }

}
