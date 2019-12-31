package com.wei.library;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.wei.library.Interface.DialogProvider;

/**
 * Created by wei on 2019/12/28.
 */
public class LoadingDialog implements DialogProvider {

    private String mMessage = null;

    public LoadingDialog(){

    }

    public LoadingDialog(String message){
        mMessage = message;
    }

    @Override
    public Dialog getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Get the layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View progressView = inflater.inflate(R.layout.dialog_progress ,null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        TextView tvMessage = progressView.findViewById(R.id.tv_message);
        if (null != mMessage){
            tvMessage.setText(mMessage);
        }
        builder.setView(progressView);
        return builder.create();
    }
}
