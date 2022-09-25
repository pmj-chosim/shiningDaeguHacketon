package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

class OpenHelper extends SQLiteOpenHelper {
    public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String schema
                = "create table note(_id integer primary key autoincrement," +
                " title text not null , body text not null);";
        sqLiteDatabase.execSQL(schema);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}


public class Guni extends Activity {

    static final int READ = 0;
    static final int WRITE = 1;
    static final int ERROR = 2;

    ListView list;
    SQLiteDatabase sd;
    Cursor c;
    String _id = "";
    SimpleCursorAdapter adapter;
    View v;

    class MyDialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                //DB에서 롱클릭된 현재 메모 _id값을 사용하여 삭제
                String q = "delete from note where _id=" + _id + ";";
                sd.execSQL(q);  //DB에 쿼리문 실행요청

                //삭제 애니메이션 효과 적용
                TranslateAnimation tr
                        = new TranslateAnimation(0, 800, 0, 0);
                tr.setDuration(1000);

                tr.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationStart(Animation animation) {

                        c = sd.query("note", null, null,
                                null, null, null, null);
                    }
                    public void onAnimationEnd(Animation animation) {

                        adapter.changeCursor(c);
                    }
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                v.startAnimation(tr);
            } else if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(Guni.this,
                        "취소하셨습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        c = sd.query("note", null, null,
                null, null, null, null);


        adapter = new SimpleCursorAdapter(this,
                R.layout.line,  //한줄의 모양
                c,//공급되는 데이터
                new String[]{"_id", "title"},//from
                new int[]{R.id.id, R.id.title}//to
        );
        //(4)ListView에 Adapter 적용
        list.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //UI 이외의 자원 해제
        c.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);



        OpenHelper oh = new OpenHelper(this, "test.db", null, 1);
        sd = oh.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("title", "pick our team!");
        values.put("body", "열심히 노력해서 만들었습니다. 좋은 결과가 있었으면 좋겠네요");
        sd.insert("note", null, values);


        setContentView(R.layout.guni);

        list = findViewById(R.id.list);



        Button write = findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Guni.this, Sub.class);
                i.putExtra("action", Guni.WRITE);
                startActivity(i);

                Log.d("##########", "메모작성 버튼 클릭");
            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                LinearLayout layout = (LinearLayout)view;
                TextView t = (TextView)layout.getChildAt(0);
                String _id = t.getText().toString();

                //
                String title = "";
                String body = "";
                c.moveToFirst();
                while ( c.isAfterLast() == false) {
                    if ( _id.equals(c.getString(0)) ) { //listview 선택된 한줄과 _id가 같은가
                        title = c.getString(1);  //찾고자 하는 메모 title
                        body = c.getString(2);  //찾고자 하는 메모 body
                        break;
                    }
                    c.moveToNext();
                }


                Intent intent
                        = new Intent(Guni.this, Sub.class);
                intent.putExtra("action", Guni.READ);
                intent.putExtra("title", title);
                intent.putExtra("body", body);

                startActivity(intent);

                Log.d("##########", "ListView 한 줄 클릭");
            }
        });


        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                v = view;
                LinearLayout layout = (LinearLayout) view;

                TextView temp = (TextView) layout.getChildAt(0);
                _id = temp.getText().toString(); //첫번째 UI가 가지고 있는 _id 값 가져오기

                MyDialogListener m = new MyDialogListener();

                new AlertDialog.Builder(Guni.this)
                        .setMessage("정말 삭제 하시겠습니까?")
                        .setPositiveButton("YES", m)
                        .setNegativeButton("NO", m)
                        .show();


                Log.d("##########", _id + " 롱클릭!!");
                return true;   //true 인 경우 추가적으로 클릭 이벤트는 처리 안됨
            }
        });


    }
}