package apps.poo2017.com.br.jogodaimitao;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import apps.poo2017.com.br.jogodaimitao.holderview.HolderView;

public class MainActivity extends AppCompatActivity {

    private HolderView holderView = new HolderView();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holderView.background = findViewById(R.id.title_panel);
        holderView.actionBar = this.getActionBar();
        holderView.imageButton = findViewById(R.id.imageButton);
        holderView.textView = findViewById(R.id.textView);


    }
}
