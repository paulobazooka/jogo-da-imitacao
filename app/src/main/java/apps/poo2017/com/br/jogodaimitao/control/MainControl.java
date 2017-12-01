package apps.poo2017.com.br.jogodaimitao.control;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.main.MainActivity;

/**
 * Classe para controlar mainActivity
 *  Responsável pela mudança das cores e da imagem do ImageButton
 */

public class MainControl {

    private MainActivity mainActivity;
    private static boolean changedButtonImage = false;


    public MainControl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void changeColorActionBar(int color){
        android.support.v7.app.ActionBar bar = mainActivity.getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(mainActivity, color)));
    }

    public void changeColorText(int color){
        mainActivity.mViewHolder.textView.setTextColor(ContextCompat.getColor(mainActivity, color));
    }

    public void changeColorStatusBar(int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mainActivity.getWindow().setStatusBarColor(mainActivity.getResources().getColor(color));
        }
    }

    public void changeButtonImage(){
        // implementar...
    }
}
