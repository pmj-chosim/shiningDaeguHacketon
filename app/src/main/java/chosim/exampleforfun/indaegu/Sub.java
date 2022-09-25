package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Sub extends Activity {

    SQLiteDatabase sd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        OpenHelper oh = new OpenHelper(this, "test.db", null, 1);
        sd = oh.getWritableDatabase();
        EditText title = findViewById(R.id.title);
        EditText body = findViewById(R.id.body);
        Button save = findViewById(R.id.save);


        Intent i = getIntent();
        int action = i.getIntExtra("action", Guni.ERROR);

        switch (action) {
            case Guni.READ:
                //title, body에 선택된 메모 내용 보여주기
                title.setText( i.getStringExtra("title") );
                body.setText( i.getStringExtra("body") );
                title.setEnabled(false);
                body.setEnabled(false);
                save.setText("BACK");
                break;
            case Guni.WRITE:
                break;
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (action) {
                    case Guni.READ:
                        finish();
                        break;
                    case Guni.WRITE:
                        //저장 버튼을 클릭하면 DB에 화면에 입력된 메모제목/내용 저장
                        ContentValues values = new ContentValues();
                        values.put("title", title.getText() + "");
                        values.put("body", body.getText() + "");
                        sd.insert("note", null, values);
                        Toast.makeText(Sub.this,
                                "저장성공", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
            }
        });

    }
}
