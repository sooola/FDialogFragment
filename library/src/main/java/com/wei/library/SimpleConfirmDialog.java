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
public class SimpleConfirmDialog implements DialogProvider {

    private String mMessage;
    private boolean mCancelable = true;
    private FDialogInterface.OnClickConfirmListener mConfirmListener;
    private FDialogInterface.OnClickCancelListener mCancelListener;




    public SimpleConfirmDialog(String message ,FDialogInterface.OnClickConfirmListener confirmListener){
        mMessage = message;
        mConfirmListener = confirmListener;
    }
    public SimpleConfirmDialog(String message ,FDialogInterface.OnClickConfirmListener confirmListener ,
                               FDialogInterface.OnClickCancelListener cancelListener){
        mMessage = message;
        mConfirmListener = confirmListener;
        mCancelListener = cancelListener;
    }

    public SimpleConfirmDialog(String message , boolean cancelable ,FDialogInterface.OnClickConfirmListener confirmListener ,
                               FDialogInterface.OnClickCancelListener cancelListener){
        mMessage = message;
        mCancelable = cancelable;
        mConfirmListener = confirmListener;
        mCancelListener = cancelListener;
    }

    @Override
    public Dialog getDialog(Context context) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mMessage)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (null != mConfirmListener)
                            mConfirmListener.onClickConfirm(dialog ,id);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (null != mCancelListener)
                            mCancelListener.onClickCancel(dialog ,id);
                        dialog.dismiss();
                    }
                });
        builder.setCancelable(mCancelable);
        return builder.create();
    }
}
