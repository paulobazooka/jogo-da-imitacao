package apps.poo2017.com.br.jogodaimitao.viewholder;

import android.app.ActionBar;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 *  Classe para obter os objetos
 */

public class ViewHolder {

    protected static ViewHolder viewHolder;

    public static TextView textView;
    public static ActionBar actionBar;
    public static ImageButton imageButton;
    public static ProgressBar progressBar;


    protected ViewHolder(){

    }

    public static ViewHolder getInstance(){
        if(viewHolder == null){
            viewHolder = new ViewHolder();
        }

        return viewHolder;
    }
    
}
