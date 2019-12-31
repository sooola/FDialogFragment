package com.wei.library;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.wei.library.Interface.DialogProvider;

/**
 * Created by wei on 2019/12/27.
 */
public class CommonDialog extends DialogFragment {

    public  DialogProvider mDialogProvider;

    public static CommonDialog newInstance(DialogProvider dialogProvider) {
        CommonDialog commonDialog = new CommonDialog();
        commonDialog.mDialogProvider = dialogProvider;
        return commonDialog;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getDialog() != null) {
            try {
                // 解决Dialog内D存泄漏
                getDialog().setOnDismissListener(null);
                getDialog().setOnCancelListener(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return mDialogProvider.getDialog(getActivity());
    }
}
