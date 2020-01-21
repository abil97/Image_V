package com.example.image_gesture_detector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, View.OnTouchListener {

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    private ImageView imageView;
    private TextView textView;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.tvError);
        textView = findViewById(R.id.textView);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        //mDetector.setOnDoubleTapListener(this);
        imageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        //Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
       // Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
        imageView.clearColorFilter();
        textView.setText("Swipe the image to start");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
        //Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        Log.d(DEBUG_TAG, "distance x is: " + distanceX + "; Distance y is: " + distanceY);

        // Swipe to the right
        // color should be blue
        if (distanceX < 0 && (distanceX < distanceY) && (distanceY < 20  && distanceY > -20)){
            imageView.setColorFilter(Color.argb(128 ,102 ,255 ,255));
            textView.setText("Swiped right");
        }
        // Swipe to the left
        // Color should be red
        else if (distanceX > 0 && (distanceX > distanceY) && (distanceY < 20  && distanceY > -20)) {
            imageView.setColorFilter(Color.argb(128 ,255 ,80 ,80));
            textView.setText("Swiped left");
        }
        // Swipe up
        // color should be green
        else if (distanceY > 0 && (distanceY > distanceX) && (distanceX < 20  && distanceX > -20)){
            imageView.setColorFilter(Color.argb(128 ,26 ,255 ,26));
            textView.setText("Swiped up");
        }
        // Swipe down
        // color should be yellow
        else if (distanceY < 0 && (distanceY < distanceX) && (distanceX < 20  && distanceX > -20)) {
            imageView.setColorFilter(Color.argb(128 ,255 ,255 ,26));
            textView.setText("Swiped down");
        }

        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        //Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}