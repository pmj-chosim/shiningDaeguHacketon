package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Tutorial extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        Button b1=findViewById(R.id.tutorialsecondnext);
        Button b2=findViewById(R.id.tutorialthirdgotostart);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Tutorial.this,Tutorial2.class );
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Tutorial.this, Main.class);
                startActivity(j);
            }
        });


    }
}
