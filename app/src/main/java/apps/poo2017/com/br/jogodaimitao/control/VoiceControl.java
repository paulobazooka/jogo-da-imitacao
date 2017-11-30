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
 * Created by bazooka on 30/11/17.
 */

public class VoiceControl {

    // Objeto para receber a main
    MainActivity mainActivity;
    Context context;


    public VoiceControl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.context = mainActivity.getApplicationContext();
    }


    public void takesCommand(String command){

          if(command.contains(Comandos.MUDAR_A_COR.getComando()) ||
                  command.contains(Comandos.TROCAR_A_COR.getComando()) ||
                        command.contains(Comandos.TROCAR_COR.getComando()) ||
                              command.contains(Comandos.MUDAR_COR.getComando())){
              Log.e("Comando:", command);

              if(command.contains(Comandos.AMARELO.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.yellow));
                 Log.e("Cor:", "Amarelo");
             }else
             if(command.contains(Comandos.VERMELHO.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.red));
                 Log.e("Cor:", "Vermelho");
             }else
             if(command.contains(Comandos.VERDE.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.green));
                 Log.e("Cor:", "Verde");
             }else
             if(command.contains(Comandos.AZUL_CLARO.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.light_blue));
                 Log.e("Cor:", "Azul Claro");
             }else
             if(command.contains(Comandos.AZUL_ESCURO.getComando())){
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.dark_blue));
                 Log.e("Cor:", "Azul Escuro");
             }
          }
    }

}
