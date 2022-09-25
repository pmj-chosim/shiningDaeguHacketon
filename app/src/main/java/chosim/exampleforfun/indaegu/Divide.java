package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Divide extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.divide);

        TextView t=findViewById(R.id.dividetext);
        Button q=findViewById(R.id.dividequestion);
        Button write=findViewById(R.id.dividepp);


        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Divide.this, Tutorial.class);
                startActivity(i);
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Divide.this, Writing.class);
                startActivity(k);
            }
        });


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Divide.this, Writing.class);
                startActivity(j);
            }
        });




    }

}
