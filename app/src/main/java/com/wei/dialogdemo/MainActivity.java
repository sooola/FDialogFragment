package com.wei.dialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wei.library.CommonDialog;
import com.wei.library.DialogBuildUtil;
import com.wei.library.Interface.FDialogInterface;
import com.wei.library.ProgressDialog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //记录ProgressBar的完成进度
    private int mStatus;

    private Button mBtnConfirmDialog;
    private ProgressBar mProgressBar;
    private Handler mHandler = new Handler();

    //创建一个负责更新进度的Handler
    private Handler mProgressHandler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //表明消息是由该程序发送的
            if(msg.what==0x111){
                mProgressBar.setProgress(mStatus);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnConfirmDialog = findViewById(R.id.btn_confirm_dialog);

        mBtnConfirmDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuildUtil.showSimpleConfirmDialog(getSupportFragmentManager(), "test111", new FDialogInterface.OnClickConfirmListener() {
                    @Override
                    public void onClickConfirm(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_SHORT).show();
                    }
                }, new FDialogInterface.OnClickCancelListener() {
                    @Override
                    public void onClickCancel(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "cancle", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        final String[] city = new String[]{"广州", "北京", "上海", "重庆", "深圳"};
        findViewById(R.id.btn_list_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuildUtil.showListDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnDataCallbackListener() {
                    @Override
                    public boolean onDataCallback(int which) {
                        Toast.makeText(MainActivity.this, "list click " + which, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });

        findViewById(R.id.btn_singelist_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuildUtil.showSingleChoiceDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnDataCallbackListener() {
                    @Override
                    public boolean onDataCallback(int which) {
                        Toast.makeText(MainActivity.this, "list click " + which, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });

        findViewById(R.id.btn_mullist_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuildUtil.showMulChoiceDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnMulCallbackListener() {
                    @Override
                    public boolean onMulDataCallback(List<Integer> selectItems) {

                        Toast.makeText(MainActivity.this, "list click " + selectItems, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        });

        findViewById(R.id.btn_loading_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CommonDialog loadingDialog = DialogBuildUtil.showLoadingDialog();
                loadingDialog.show(getSupportFragmentManager() ,DialogBuildUtil.LOADING_TAG);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismiss();
                    }
                }, 5000);
            }
        });

        findViewById(R.id.btn_progress_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatus = 0;
                ProgressDialog progressDialog = DialogBuildUtil.showProgressDialog(true);
                progressDialog.showNow(getSupportFragmentManager() ,"123");

                mProgressBar = progressDialog.getProgressBar();
//                mProgressBar.setProgress(80);

                //启动线程来执行任务
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while(mStatus < 100){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            mStatus ++;
                            //发送消息
                            mProgressHandler.sendEmptyMessage(0x111);
                        }
                    }
                }.start();

            }
        });
    }
}
