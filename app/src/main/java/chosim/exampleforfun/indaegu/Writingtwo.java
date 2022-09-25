package chosim.exampleforfun.indaegu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class Writingtwo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writingtwo);
    }
}
