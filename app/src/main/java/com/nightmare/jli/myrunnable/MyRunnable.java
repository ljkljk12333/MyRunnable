package com.nightmare.jli.myrunnable;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

/**
 * Created by J.Li on 2016/6/8.
 */
public class MyRunnable implements Runnable {

    static final String TAG="Fruit";

    private int fruitCount =30;

    private Activity mContext;

    private MainActivity.UIHandler mUIHandler;
//    private TextView text;

    private RefrashRunnable mRunnable;

    public MyRunnable(Activity context,RefrashRunnable runnable,MainActivity.UIHandler uiHandler){
        this.mContext=context;
        this.mRunnable=runnable;
        this.mUIHandler=uiHandler;
//        text=(TextView)mContext.findViewById(R.id.text);
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(fruitCount >0){

//                    mRunnable.setStr("第" + (30 - fruitCount + 1) + "个水果被【"+Thread.currentThread().getName() + "】吃了");
//                    mContext.runOnUiThread(mRunnable);

                    Message msg=new Message();
                    Bundle bundle=new Bundle();
                    bundle.putString("text","第" + (30 - fruitCount + 1) + "个水果被【"+Thread.currentThread().getName() + "】吃了");
                    msg.setData(bundle);

                    mUIHandler.sendMessage(msg);

                    Log.d(TAG, "第" + (30 - fruitCount + 1) + "个水果被【"+Thread.currentThread().getName() + "】吃了");
                    fruitCount--;
                }else {
                    break;
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
