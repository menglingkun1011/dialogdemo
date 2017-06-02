package com.meng.mydialogdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.flyco.animation.Attention.Swing;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;

public class CustomBaseDialog extends BaseDialog {
    private final Context context;
    private TextView btn1;
    private TextView btn2;

    public CustomBaseDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        showAnim(new Swing());

        // dismissAnim(this, new ZoomOutExit());
        superDismiss();
        View inflate = View.inflate(context, R.layout.dialog, null);
        btn1 = (TextView) inflate.findViewById(R.id.btn1);
        btn2 = (TextView) inflate.findViewById(R.id.btn2);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));

        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        showAnim(null);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}