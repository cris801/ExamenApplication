package com.example.examenapplication.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class CanvasEventoActionMove extends View {
    float x = 50;
    float y = 50;
    String texto="";
    Path path = new Path();
    public CanvasEventoActionMove(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.LTGRAY);

        //creamos un pinchel
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        //dibujamos un circulo
        canvas.drawCircle(x,y,7,paint);

        // personalizamos el pincel
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        if (texto.equalsIgnoreCase("Action Down")){
            // cambiamos la direccion del path
            // movemos el path
            path.moveTo(x,y);
        } else if (texto.equalsIgnoreCase("Action Up")){
            path.lineTo(x,y);
        } else if (texto.equalsIgnoreCase("Action Move")){
            path.lineTo(x,y);
        }

        // dibujamos la ruta conlas propiedades aginadas al pincel
        canvas.drawPath(path, paint);

        // coordenadas del ultimo punto de interacción
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        canvas.drawText("X = "+x,100,50,paint);
        canvas.drawText("Y = "+y,100,90,paint);
        canvas.restoreToCount(1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        x = evento.getX();
        y = evento.getY();

        if (evento.getAction() == MotionEvent.ACTION_DOWN){
            texto = "Action Down";
        }
        if (evento.getAction() == MotionEvent.ACTION_UP){
            texto = "Action Up";
        }
        if (evento.getAction() == MotionEvent.ACTION_MOVE){
            texto = "Action Move";
        }
        invalidate();
        return true;
    }
}
