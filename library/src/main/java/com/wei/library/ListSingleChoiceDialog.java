package com.wei.library;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.wei.library.Interface.DialogProvider;
import com.wei.library.Interface.FDialogInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei on 2019/12/27.
 */
public class ListSingleChoiceDialog implements DialogProvider {

    private String mTitle;
    private String[] mItems;
    private int mDefCheckedItem = -1;
    private boolean mCancelable = true;
    private FDialogInterface.OnDataCallbackListener mDataCallbackListener;
    private FDialogInterface.OnClickCancelListener mOnClickCancelListener;

    public ListSingleChoiceDialog(String title , String[] items , FDialogInterface.OnDataCallbackListener dataCallback){
        mTitle = title;
        mItems = items;
        mDataCallbackListener = dataCallback;
    }

    public ListSingleChoiceDialog(String title , String[] items , int defCheckedItem ,
                                  FDialogInterface.OnDataCallbackListener dataCallback,
                                  FDialogInterface.OnClickCancelListener onClickCancelListener){
        mTitle = title;
        mItems = items;
        mDefCheckedItem = defCheckedItem;
        mDataCallbackListener = dataCallback;
        mOnClickCancelListener = onClickCancelListener;
    }

    @Override
    public Dialog getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final List<Integer> selectedItems = new ArrayList<Integer>();
        final int[] selectedItem = new int[1];
        selectedItem[0] = -1;
        builder.setTitle(mTitle)
                .setSingleChoiceItems(mItems, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                selectedItem[0] = which;
                            }
                        }
                )
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDataCallbackListener.onDataCallback(selectedItem[0]);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (null != mOnClickCancelListener){
                        mOnClickCancelListener.onClickCancel(dialogInterface ,i);
                    }
                }
            });
        builder.setCancelable(mCancelable);
        return builder.create();
    }
}
