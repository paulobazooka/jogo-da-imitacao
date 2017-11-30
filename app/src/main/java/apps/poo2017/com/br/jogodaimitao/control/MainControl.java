package apps.poo2017.com.br.jogodaimitao.control;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;

import apps.poo2017.com.br.jogodaimitao.R;
import apps.poo2017.com.br.jogodaimitao.main.MainActivity;

/**
 * Classe para controlar mainActivity
 */

public class MainControl {
    private MainActivity mainActivity;

    public MainControl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void changeColorActionBar(int color){
        android.support.v7.app.ActionBar bar = mainActivity.getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(mainActivity, color)));
    }
}
