package com.nightmare.jli.myrunnable;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button btn;

    private TextView text;

    private UIHandler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiHandler=new UIHandler();

        text=(TextView)findViewById(R.id.text);

        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RefrashRunnable refrashRunnable=new RefrashRunnable(MainActivity.this);

                MyRunnable myRunnable = new MyRunnable(MainActivity.this,refrashRunnable,uiHandler);

                Thread t1 = new Thread(myRunnable, "李雷");
                Thread t2 = new Thread(myRunnable, "韩梅梅");
                Thread t3 = new Thread(myRunnable, "Jim");
                Thread t4 = new Thread(myRunnable, "Lily");
                t1.start();
                t2.start();
                t3.start();
                t4.start();
            }
        });

    }

    public UIHandler getUiHandler() {
        return uiHandler;
    }

    public class UIHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            String Str=bundle.getString("text");
            text.setText(Str+"\r\n"+text.getText());
        }
    }


}
