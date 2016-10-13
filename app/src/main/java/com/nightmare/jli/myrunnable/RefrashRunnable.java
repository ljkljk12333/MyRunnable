package com.nightmare.jli.myrunnable;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by J.Li on 2016/6/8.
 */
public class RefrashRunnable implements Runnable {

    private String Str;

    private Activity mContext;

    private TextView text;

    public RefrashRunnable(Activity context){
        this.mContext=context;
        text=(TextView)mContext.findViewById(R.id.text);

    }

    public void setStr(String str) {
        Str = str+"\r\n"+Str;
    }

    @Override
    public void run() {
        text.setText(Str);
    }
}
