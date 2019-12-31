package com.wei.library;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.wei.library.Interface.DialogProvider;
import com.wei.library.Interface.FDialogInterface;

/**
 * Created by wei on 2019/12/27.
 */
public class ListDialog implements DialogProvider {

    private String mTitle;
    private boolean mCancelable = true;
    private String[] mItems;
    private FDialogInterface.OnDataCallbackListener mDataCallback;

    /**
     *
     * @param title  标题
     * @param items  列表item
     * @param dataCallback
     */
    public ListDialog(String title , String[] items , FDialogInterface.OnDataCallbackListener dataCallback){
        mTitle = title;
        mItems = items;
        mDataCallback = dataCallback;
    }

    /**
     *
     * @param title  标题
     * @param items  列表item
     * @param cancelable    dialog是否可以取消
     * @param dataCallback
     */
    public ListDialog(String title , String[] items ,boolean cancelable , FDialogInterface.OnDataCallbackListener dataCallback){
        mTitle = title;
        mItems = items;
        mCancelable = cancelable;
        mDataCallback = dataCallback;
    }

    @Override
    public Dialog getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(mTitle)
                .setItems(mItems, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (null != mDataCallback)
                            mDataCallback.onDataCallback(which);
                    }
                });
        builder.setCancelable(mCancelable);
        return builder.create();
    }
}
