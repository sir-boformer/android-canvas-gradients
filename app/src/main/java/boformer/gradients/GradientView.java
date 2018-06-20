package boformer.gradients;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class GradientView extends View {

    private Paint gradientPaint;

    public GradientView(Context context) {
        super(context);
        init();
    }

    public GradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, metrics);

        gradientPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        gradientPaint.setTextAlign(Paint.Align.CENTER);
        gradientPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        canvas.drawRect(0, 0, getWidth() / 2, getHeight(), gradientPaint);

        canvas.drawText("TEST", getWidth() * 0.75f, getHeight() * 0.33f, gradientPaint);

        canvas.drawText("TEST", getWidth() * 0.75f, getHeight() * 0.66f, gradientPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int[] colors = new int[]{
                0xffff0000,
                0xffffff00,
                0xff00ff00,
                0xff00ffff,
                0xff0000ff,
                0xffff00ff,
                0xffff0000
        };

        float[] positions = new float[] {
                0 / 6f,
                1.5f / 6f,
                2 / 6f,
                3.5f / 6f,
                4 / 6f,
                5 / 6f,
                6 / 6f
        };

        LinearGradient gradient = new LinearGradient(0f, 0f, 0f, (float)h,
                colors, positions, Shader.TileMode.CLAMP);
        this.gradientPaint.setShader(gradient);
    }
}
