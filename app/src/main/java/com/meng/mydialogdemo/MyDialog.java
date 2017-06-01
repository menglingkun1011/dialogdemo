package com.meng.mydialogdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;

/**
 * Created by Administrator on 2017/5/31.
 */

public class MyDialog extends NormalDialog {

    private Context context;

    public MyDialog(Context context) {
        super(context);
        this.context = context;
    }


    protected void NormalDialogCustomAttr() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.isTitleShow(false)//
                .bgColor(Color.parseColor("#ffffff"))//
                .cornerRadius(5)//
                .content("\n确定撤消直播预告发布？\n")//
                .contentGravity(Gravity.CENTER)//
                .contentTextColor(Color.parseColor("#222222"))//
                .dividerColor(Color.parseColor("#f5f5f5"))//
                .btnTextSize(15.5f, 15.5f)//
                .btnTextColor(Color.parseColor("#0072ff"), Color.parseColor("#0072ff"))//
                .btnPressColor(Color.parseColor("#f5f5f5"))//
                .widthScale(0.85f)//
//                .showAnim(mBasIn)//
//                .dismissAnim(mBasOut)//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

//        dialog.setCanceledOnTouchOutside(false);
    }


}
