package com.wei.library.Interface;

import android.content.DialogInterface;

import java.util.List;

/**
 * Created by wei on 2019/12/27.
 */
public interface FDialogInterface {

    public interface OnClickCancelListener {
        public void onClickCancel(DialogInterface dialog, int id);
    }

    public interface OnClickConfirmListener {
        public void onClickConfirm(DialogInterface dialog, int id);
    }


    public interface OnDataCallbackListener {
        boolean onDataCallback(int which);
    }

    public interface OnMulCallbackListener {
        boolean onMulDataCallback(List<Integer> selectItems);
    }
}
