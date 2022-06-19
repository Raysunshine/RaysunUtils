package com.raysun.utils.ToastUtils;

import android.content.Context;
import android.widget.Toast;

public class Toasts {

    public static void showLong(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
