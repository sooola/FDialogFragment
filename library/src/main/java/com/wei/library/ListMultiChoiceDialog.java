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
public class ListMultiChoiceDialog implements DialogProvider {

    private String mTitle;
    private String[] mItems;
    private boolean[] mDefCheckedItem = null;
    private FDialogInterface.OnMulCallbackListener mMulDataCallback;
    private FDialogInterface.OnClickCancelListener mOnClickCancel;

    public ListMultiChoiceDialog(String title, String[] items, FDialogInterface.OnMulCallbackListener dataCallback) {
        mTitle = title;
        mItems = items;
        mMulDataCallback = dataCallback;
    }

    public ListMultiChoiceDialog(String title, String[] items, FDialogInterface.OnMulCallbackListener dataCallback,
                                 FDialogInterface.OnClickCancelListener onClickCancel) {
        mTitle = title;
        mItems = items;
        mMulDataCallback = dataCallback;
        mOnClickCancel = onClickCancel;
    }

    @Override
    public Dialog getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final List<Integer> selectedItems = new ArrayList<Integer>();
        builder.setTitle(mTitle)
                .setMultiChoiceItems(mItems, mDefCheckedItem,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItems.add(which);
                                } else if (selectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mMulDataCallback.onMulDataCallback(selectedItems);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (null != mOnClickCancel){
                            mOnClickCancel.onClickCancel(dialogInterface ,i);
                        }
                    }
                });
        return builder.create();
    }
}
