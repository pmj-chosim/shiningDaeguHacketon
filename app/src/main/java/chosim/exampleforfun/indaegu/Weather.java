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

public class Weather extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);



        setContentView(R.layout.weather);

        TextView t=findViewById(R.id.weathertext);
        Button q=findViewById(R.id.weatherquestion);
        Button write=findViewById(R.id.weatherpp);


        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Weather.this, Second.class);
                startActivity(i);
            }
        });

      t.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              t.setText("57");
          }
      });


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Weather.this, Writing.class);
                startActivity(j);
            }
        });






    }
}
