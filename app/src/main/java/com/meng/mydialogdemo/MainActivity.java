package com.meng.mydialogdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalDialog;


public class MainActivity extends AppCompatActivity {

    private Button btn;

    BounceTopEnter mBasIn = new BounceTopEnter();
    SlideBottomExit mBasOut = new SlideBottomExit();
    private CustomBaseDialog cbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbd = new CustomBaseDialog(this);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActionSheetDialog(MainActivity.this);
//                NormalDialogCustomAttr(MainActivity.this);
                cbd.show();

            }
        });
    }

    private void ActionSheetDialog(final Context ctx) {
        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(ctx, stringItems, null);
        dialog
//                .title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                .isTitleShow(false)
                .titleTextSize_SP(14.5f)//
                .itemTextColor(Color.parseColor("#222222"))
                .cancelText(Color.parseColor("#222222"))
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ctx, stringItems[position], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
//        dialog.setCancelable(false);
    }

    protected void NormalDialogCustomAttr(final Context context) {
        final NormalDialog dialog = new NormalDialog(context);

        dialog.isTitleShow(false)//
                .bgColor(Color.parseColor("#ffffff"))//
                .cornerRadius(5)//
                .content("\n确定撤消直播预告发布？\n")//
                .contentGravity(Gravity.CENTER)//
                .contentTextColor(Color.parseColor("#222222"))//
                .dividerColor(Color.parseColor("#ececec"))//
                .btnTextSize(15.5f, 15.5f)//
                .btnTextColor(Color.parseColor("#0072ff"), Color.parseColor("#0072ff"))//
                .btnPressColor(Color.parseColor("#f5f5f5"))//
//                .widthScale(1.0f)//
                .heightScale(0.8f)
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
//        LinearLayout ll = (LinearLayout) dialog.onCreateView();
//        ViewGroup.LayoutParams lp = ll.getLayoutParams();
//        lp.height = 400;
//        dialog.onCreateView().setLayoutParams(lp);
    }

}
