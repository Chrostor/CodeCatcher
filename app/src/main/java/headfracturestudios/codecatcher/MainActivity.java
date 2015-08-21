package headfracturestudios.codecatcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FrameLayout box1 = (FrameLayout) findViewById(R.id.box1);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        Button startButton = (Button) findViewById(R.id.startButton);
        boolean threadRunning = false;
        //Thread colorChanger = new Thread();

        /*startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        stopButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()== MotionEvent.ACTION_DOWN){

                       box1.setBackgroundColor(Color.BLUE);
                       box1.setBackgroundColor(Color.CYAN);


               }
               if (motionEvent.getAction()== MotionEvent.ACTION_UP){
                   box1.setBackgroundColor(Color.BLACK);
               }
                return true;
            }

        });
    }
}
