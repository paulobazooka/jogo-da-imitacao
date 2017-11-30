package apps.poo2017.com.br.jogodaimitao.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
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
    private String color = "";

    public VoiceControl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.context = mainActivity.getApplicationContext();
    }

    @SuppressLint("ResourceAsColor")
    public void takesCommand(String command){

          if(command.contains(Comandos.MUDAR_A_COR.toString()) ||
                  command.contains(Comandos.TROCAR_A_COR.toString())){


             if(command.contains(Comandos.AMARELO.toString())){
                 color = Cores.AMARELO.toString();
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.yellow));

             }else
             if(command.contains(Comandos.VERMELHO.toString())){
                 color = Cores.VERMELHO.toString();
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.red));

             }else
             if(command.contains(Comandos.VERDE.toString())){
                 color = Cores.VERDE.toString();
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.green));

             }else
             if(command.contains(Comandos.AZUL_CLARO.toString())){
                 color = Cores.AZUL_CLARO.toString();
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.light_blue));

             }else
             if(command.contains(Comandos.AZUL_ESCURO.toString())){
                 color = Cores.AZUL_ESCURO.toString();
                 mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.dark_blue));
             }
          }
    }

}
