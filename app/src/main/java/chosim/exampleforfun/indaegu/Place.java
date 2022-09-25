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

public class Place extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.place);


        Button q=findViewById(R.id.placequestion);
        Button write=findViewById(R.id.placepp);


        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Place.this, Second.class);
                startActivity(i);
            }
        });




        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Place.this, Writing.class);
                startActivity(j);
            }
        });

    }
}
