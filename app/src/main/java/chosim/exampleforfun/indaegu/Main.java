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

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button weather=findViewById(R.id.weather);
        Button place=findViewById(R.id.place);
        Button food=findViewById(R.id.food);
        Button divide=findViewById(R.id.divide);
        Button givu=findViewById(R.id.givu);
        Button junggo=findViewById(R.id.junggo);
        Button meet=findViewById(R.id.meet);
        Button info=findViewById(R.id.info);
        Button mess=findViewById(R.id.messagehouse);


        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main.this, ZZokji.class);
                startActivity(i);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Main.this, Weather.class);
                startActivity(a);
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(Main.this, Place.class);
                startActivity(b);

            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c=new Intent(Main.this, Food.class);
                startActivity(c);

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(Main.this, Divide.class);
                startActivity(d);

            }
        });

        givu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e=new Intent(Main.this, Givu.class);
                startActivity(e);

            }
        });

        junggo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(Main.this, Junggo.class);
                startActivity(f);

            }
        });

        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g=new Intent(Main.this, Meet.class);
                startActivity(g);

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Main.this, Info.class);
                startActivity(h);

            }
        });




    }
}
