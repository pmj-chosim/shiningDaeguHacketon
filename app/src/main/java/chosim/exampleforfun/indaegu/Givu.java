package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Givu extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.givu);

        TextView t=findViewById(R.id.givutext);
        Button q=findViewById(R.id.givuquestion);
        Button write=findViewById(R.id.givutogivuwrite);
        Button site=findViewById(R.id.givusite);


        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Givu.this, Tutorial.class);
                startActivity(i);
            }
        });

        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent URL=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chosun.com/national/regional/2022/03/09/GR2CYILGTBE4LIR74LFD47VBGE/"));
                startActivity(URL);
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("320,0000"
                );
            }
        });


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Givu.this, Writing.class);
                startActivity(j);
            }
        });




    }
}
