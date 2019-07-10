package eu.sk.jakab.circularprogressbarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jakab on 7/10/2019.
 */
public class CircleProgressBarWithText extends RelativeLayout {

    private CircleProgressBar circleProgressBar;
    private TextView txtTitle;
    private TextView txtSubtitle;

    private LayoutInflater mInflater;
    private float strokeWidth = 4;
    private float progress = 0;
    private int min = 0;
    private int max = 100;
    private int color = Color.DKGRAY;
    private String title = "";
    private String subtitle = "";
    private float titleSize;
    private float subTitleSize;
    private int titleColor = Color.DKGRAY;
    private int subtitleColor = Color.LTGRAY;

    public CircleProgressBarWithText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View v = mInflater.inflate(R.layout.pb_with_text_view, this, true);
        circleProgressBar = v.findViewById(R.id.progress_circle);
        txtTitle = v.findViewById(R.id.txt_title);
        txtSubtitle = v.findViewById(R.id.txt_subtitle);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircleProgressBarWithText,
                0, 0);
        //Reading values from the XML layout
        try {
            strokeWidth = typedArray.getDimension(R.styleable.CircleProgressBarWithText_pbThickness, strokeWidth);
            progress = typedArray.getFloat(R.styleable.CircleProgressBarWithText_pbCurrentProgress, progress);
            color = typedArray.getInt(R.styleable.CircleProgressBarWithText_pbColor, color);
            min = typedArray.getInt(R.styleable.CircleProgressBarWithText_pbMin, min);
            max = typedArray.getInt(R.styleable.CircleProgressBarWithText_pbMax, max);
            titleSize = typedArray.getDimension(R.styleable.CircleProgressBarWithText_titleSize, 22);
            subTitleSize = typedArray.getDimension(R.styleable.CircleProgressBarWithText_subtitleSize, 16);
            titleColor = typedArray.getColor(R.styleable.CircleProgressBarWithText_titleColor, titleColor);
            subtitleColor = typedArray.getColor(R.styleable.CircleProgressBarWithText_subtitleColor, subtitleColor);
            title = typedArray.getString(R.styleable.CircleProgressBarWithText_titleText) == null ?
                    "" : typedArray.getString(R.styleable.CircleProgressBarWithText_titleText);
            subtitle = typedArray.getString(R.styleable.CircleProgressBarWithText_subtitleText) == null ?
                    "" : typedArray.getString(R.styleable.CircleProgressBarWithText_subtitleText);
        } finally {
            typedArray.recycle();
        }

        circleProgressBar.setStrokeWidth(strokeWidth);
        circleProgressBar.setColor(color);
        circleProgressBar.setMax(max);
        circleProgressBar.setMin(min);
        circleProgressBar.setProgressWithAnimation(progress);

        txtTitle.setText(title);
        txtTitle.setTextColor(titleColor);
        txtTitle.setTextSize(titleSize);

        txtSubtitle.setText(subtitle);
        txtSubtitle.setTextColor(subtitleColor);
        txtSubtitle.setTextSize(subTitleSize);
    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public void setSubtitle(String subtitle) {
        txtSubtitle.setText(subtitle);
    }

    public int getMin() {
        return circleProgressBar.getMin();
    }

    public void setMin(int min) {
        circleProgressBar.setMin(min);
        invalidate();
    }

    public int getMax() {
        return circleProgressBar.getMax();
    }

    public void setMax(int max) {
        circleProgressBar.setMax(max);
        invalidate();
    }

    public int getColor() {
        return circleProgressBar.getColor();
    }

    public void setColor(int color) {
        circleProgressBar.setColor(color);
        invalidate();
        requestLayout();
    }

    public float getStrokeWidth() {
        return circleProgressBar.getStrokeWidth();
    }

    public void setStrokeWidth(float strokeWidth) {
        circleProgressBar.setStrokeWidth(strokeWidth);
        invalidate();
        requestLayout();//Because it should recalculate its bounds
    }

    public void setProgressWithAnimation(float progress) {
        circleProgressBar.setProgressWithAnimation(progress);
    }

    public void setProgress(float progress) {
        circleProgressBar.setProgress(progress);
    }

    public void setTitleColor (int color){
        txtTitle.setTextColor(color);
    }

    public void setSubtitleColor (int color){
        txtSubtitle.setTextColor(color);
    }

    public void setTitleText(String title){
        txtTitle.setText(title);
    }

    public void setsubtitleText(String subtitle){
        txtSubtitle.setText(subtitle);
    }
}
