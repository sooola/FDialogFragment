package com.wei.library;

import androidx.fragment.app.FragmentManager;

import com.wei.library.Interface.FDialogInterface;

/**
 * Created by wei on 2019/12/27.
 */
public class DialogBuildUtil {

    public static String TAG = DialogBuildUtil.class.getName();

    public static String CONFIRM_TAG = TAG + "confirm";

    public static String LIST_TAG = TAG + "list";

    public static String SINGLE_TAG = TAG + "single";

    public static String MUL_TAG = TAG + "mul";

    public static String LOADING_TAG = TAG + "loading";

    /**
     * 简单确认dialog
     * @param fragmentManager
     * @param message
     * @param confirmListener
     * @return
     */
    public static CommonDialog showSimpleConfirmDialog(FragmentManager fragmentManager, final String message , FDialogInterface.OnClickConfirmListener confirmListener){
        CommonDialog commonDialog =  CommonDialog.newInstance(new SimpleConfirmDialog(message,confirmListener));
        commonDialog.show(fragmentManager, CONFIRM_TAG);
        return commonDialog;
    }

    public static CommonDialog showSimpleConfirmDialog(FragmentManager fragmentManager, final String message ,
                                               FDialogInterface.OnClickConfirmListener confirmListener,
                                               FDialogInterface.OnClickCancelListener cancelListener){
        CommonDialog commonDialog = CommonDialog.newInstance(new SimpleConfirmDialog(message,confirmListener,cancelListener));
        commonDialog.show(fragmentManager, CONFIRM_TAG);
        return commonDialog;
    }

    public static CommonDialog showSimpleConfirmDialog(FragmentManager fragmentManager, final String message ,
                                                       boolean cancelable,
                                                       FDialogInterface.OnClickConfirmListener confirmListener,
                                                       FDialogInterface.OnClickCancelListener cancelListener){
        CommonDialog commonDialog = CommonDialog.newInstance(new SimpleConfirmDialog(message,confirmListener,cancelListener));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, CONFIRM_TAG);
        return commonDialog;
    }

    /**
     * 列表dialog
     * @param fragmentManager
     * @param title
     * @param items
     * @param onDataCallback
     * @return
     */
    public static CommonDialog showListDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                               FDialogInterface.OnDataCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListDialog(title,items,onDataCallback));
        commonDialog.show(fragmentManager, LIST_TAG);
        return commonDialog;
    }

    public static CommonDialog showListDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                              boolean cancelable,
                                              FDialogInterface.OnDataCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListDialog(title,items,onDataCallback));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, LIST_TAG);
        return commonDialog;
    }

    /**
     * 单选dialog
     * @param fragmentManager
     * @param title
     * @param items
     * @param onDataCallback
     * @return
     */
    public static CommonDialog showSingleChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                           FDialogInterface.OnDataCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListSingleChoiceDialog(title,items,onDataCallback));
        commonDialog.show(fragmentManager, SINGLE_TAG);
        return commonDialog;
    }

    public static CommonDialog showSingleChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                                      boolean cancelable,
                                                      FDialogInterface.OnDataCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListSingleChoiceDialog(title,items,onDataCallback));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, SINGLE_TAG);
        return commonDialog;
    }

    public static CommonDialog showSingleChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                                      int defCheckedItem ,
                                                      boolean cancelable,
                                                      FDialogInterface.OnDataCallbackListener onDataCallback,
                                                      FDialogInterface.OnClickCancelListener onClickCancelListener){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListSingleChoiceDialog(title,items,defCheckedItem ,
                onDataCallback ,onClickCancelListener));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, SINGLE_TAG);
        return commonDialog;
    }

    /**
     * 多选dialog
     * @param fragmentManager
     * @param title
     * @param items
     * @param onDataCallback
     * @return
     */
    public static CommonDialog showMulChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                      FDialogInterface.OnMulCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListMultiChoiceDialog(title,items,onDataCallback));
        commonDialog.show(fragmentManager, MUL_TAG);
        return commonDialog;
    }

    public static CommonDialog showMulChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                           boolean cancelable,
                                           FDialogInterface.OnMulCallbackListener onDataCallback){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListMultiChoiceDialog(title,items,onDataCallback));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, MUL_TAG);
        return commonDialog;
    }

    public static CommonDialog showMulChoiceDialog(FragmentManager fragmentManager, final String title , String[] items ,
                                                   boolean cancelable,
                                                   FDialogInterface.OnMulCallbackListener onDataCallback,
                                                   FDialogInterface.OnClickCancelListener onClickCancelListener){
        CommonDialog commonDialog = CommonDialog.newInstance(new ListMultiChoiceDialog(title,items,onDataCallback ,onClickCancelListener));
        commonDialog.setCancelable(cancelable);
        commonDialog.show(fragmentManager, MUL_TAG);
        return commonDialog;
    }

    /**
     * 加载dialog
     * @return
     */
    public static CommonDialog showLoadingDialog(){
        CommonDialog commonDialog = CommonDialog.newInstance(new LoadingDialog("正在加载中..."));
        return commonDialog;
    }

    public static CommonDialog showLoadingDialog(String title , boolean cancelable){
        CommonDialog commonDialog = CommonDialog.newInstance(new LoadingDialog(title));
        commonDialog.setCancelable(cancelable);
        return commonDialog;
    }

    /**
     * 进度条
     * @param cancelable
     * @return
     */
    public static ProgressDialog showProgressDialog(boolean cancelable){
        ProgressDialog progressDialog = new ProgressDialog();
        progressDialog.setCancelable(cancelable);
        return progressDialog;
    }


}
