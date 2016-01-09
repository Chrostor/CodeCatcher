package headfracturestudios.codecatcher;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {
// TODO: 11/11/2015 1) Randomize button colors and check box against button color
// TODO: 11/11/2015 2) Add a timer and time limit

    public boolean thread1Running, thread2Running, thread3Running, thread4Running;
    public FrameLayout box1, box2, box3, box4, stopButton1, stopButton2, stopButton3, stopButton4;
    public Button startButton;
    public int scoreCount = 0;
    public int strikeCount = 0;
    public int sleepTimer = 600;
    public TextView score, stopTest, highScore;
    public ColorWheel colorWheel = new ColorWheel();
    public ImageView strike1, strike2, strike3;
    public int colorCycle1, colorCycle2, colorCycle3, colorCycle4;
    public Random randomStarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stopButton1 = (FrameLayout) findViewById(R.id.stopButton1);
        stopButton2 = (FrameLayout) findViewById(R.id.stopButton2);
        stopButton3 = (FrameLayout) findViewById(R.id.stopButton3);
        stopButton4 = (FrameLayout) findViewById(R.id.stopButton4);
        startButton = (Button) findViewById(R.id.startButton);
        box1 = (FrameLayout) findViewById(R.id.box1);
        box2 = (FrameLayout) findViewById(R.id.box2);
        box3 = (FrameLayout) findViewById(R.id.box3);
        box4 = (FrameLayout) findViewById(R.id.box4);
        strike1 = (ImageView) findViewById(R.id.strike1);
        strike2 = (ImageView) findViewById(R.id.strike2);
        strike3 = (ImageView) findViewById(R.id.strike3);
        stopTest = (TextView) findViewById(R.id.successTest);
        score = (TextView) findViewById(R.id.scoreText);
        strike1 = (ImageView) findViewById(R.id.strike1);
        strike2 = (ImageView) findViewById(R.id.strike2);
        strike3 = (ImageView) findViewById(R.id.strike3);
        strike1.setVisibility(View.INVISIBLE);
        strike2.setVisibility(View.INVISIBLE);
        strike3.setVisibility(View.INVISIBLE);
        colorCycle1 = 0;
        highScore = (TextView) findViewById(R.id.highScore);
        stopButton1.setEnabled(false);
        stopButton2.setEnabled(false);
        stopButton3.setEnabled(false);
        stopButton4.setEnabled(false);

        final View.OnClickListener stopper1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread1Running = false;
                stopButton1.setEnabled(false);
                ColorDrawable box1Color = (ColorDrawable) box1.getBackground();
                int box1colorId = box1Color.getColor();

                if(box1colorId == Color.parseColor(colorWheel.mColors[1])){
                    if(!thread2Running && !thread3Running && !thread4Running){
                        startButton.setVisibility(View.VISIBLE);
                        stopTest.setText("Score");
                        highScore.setVisibility(View.VISIBLE);
                        highScore.setText("Success!");
                        scoreCount++;
                        score.setText(scoreCount + "");
                        sleepTimer -= 20;
                    } else {

                    }
                } else {
                    startButton.setVisibility(View.VISIBLE);
                    thread2Running = false;
                    thread3Running = false;
                    thread4Running = false;
                    stopButton2.setEnabled(false);
                    stopButton3.setEnabled(false);
                    stopButton4.setEnabled(false);
                    if(scoreCount > 0){
                        stopTest.setText("Score");
                    } else {
                        stopTest.setText("");
                    }
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Failure!");
                    strikeCount++;
                }
                if (strikeCount == 1) {
                    strike1.setVisibility(View.VISIBLE);
                } else if (strikeCount == 2) {
                    strike2.setVisibility(View.VISIBLE);
                } else if (strikeCount == 3) {
                    strike3.setVisibility(View.VISIBLE);
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Final Score " + scoreCount);
                    scoreCount = 0;
                    stopTest.setText("Game");
                    score.setText("Over");
                    sleepTimer = 600;
                    startButton.setText("Start Game");
                }
            }
        };
        stopButton1.setOnClickListener(stopper1);

        View.OnClickListener stopper2 = new View.OnClickListener(){
            public void onClick(View view){
                thread2Running = false;
                stopButton2.setEnabled(false);
                ColorDrawable box2Color = (ColorDrawable) box2.getBackground();
                int box2colorId = box2Color.getColor();

                if(box2colorId == Color.parseColor(colorWheel.mColors[1])){
                    if(thread1Running || thread3Running || thread4Running){

                    } else {
                        startButton.setVisibility(View.VISIBLE);
                        stopTest.setText("Score");
                        highScore.setVisibility(View.VISIBLE);
                        highScore.setText("Success!");
                        scoreCount++;
                        score.setText(scoreCount + "");
                        sleepTimer -= 20;
                    }
                } else {
                    startButton.setVisibility(View.VISIBLE);
                    thread1Running = false;
                    thread3Running = false;
                    thread4Running = false;
                    stopButton1.setEnabled(false);
                    stopButton3.setEnabled(false);
                    stopButton4.setEnabled(false);
                    if(scoreCount > 0){
                        stopTest.setText("Score");
                    } else {
                        stopTest.setText("");
                    }
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Failure!");
                    strikeCount++;
                }
                if (strikeCount == 1) {
                    strike1.setVisibility(View.VISIBLE);
                } else if (strikeCount == 2) {
                    strike2.setVisibility(View.VISIBLE);
                } else if (strikeCount == 3) {
                    strike3.setVisibility(View.VISIBLE);
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Final Score " + scoreCount);
                    scoreCount = 0;
                    stopTest.setText("Game");
                    score.setText("Over");
                    sleepTimer = 600;
                    startButton.setText("Start Game");
                }
            }
        };
        stopButton2.setOnClickListener(stopper2);

        View.OnClickListener stopper3 = new View.OnClickListener(){
            public void onClick(View view){
                thread3Running = false;
                stopButton3.setEnabled(false);
                ColorDrawable box3Color = (ColorDrawable) box3.getBackground();
                int box3colorId = box3Color.getColor();

                if(box3colorId == Color.parseColor(colorWheel.mColors[1])){
                    if(!thread1Running && !thread2Running && !thread4Running){
                        startButton.setVisibility(View.VISIBLE);
                        stopTest.setText("Score");
                        highScore.setVisibility(View.VISIBLE);
                        highScore.setText("Success!");
                        scoreCount++;
                        score.setText(scoreCount + "");
                        sleepTimer -= 20;
                    } else {

                    }
                } else {
                    startButton.setVisibility(View.VISIBLE);
                    thread1Running = false;
                    thread2Running = false;
                    thread4Running = false;
                    stopButton1.setEnabled(false);
                    stopButton2.setEnabled(false);
                    stopButton4.setEnabled(false);
                    if(scoreCount > 0){
                        stopTest.setText("Score");
                    } else {
                        stopTest.setText("");
                    }
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Failure!");
                    strikeCount++;
                }
                if (strikeCount == 1) {
                    strike1.setVisibility(View.VISIBLE);
                } else if (strikeCount == 2) {
                    strike2.setVisibility(View.VISIBLE);
                } else if (strikeCount == 3) {
                    strike3.setVisibility(View.VISIBLE);
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Final Score " + scoreCount);
                    scoreCount = 0;
                    stopTest.setText("Game");
                    score.setText("Over");
                    sleepTimer = 600;
                    startButton.setText("Start Game");
                }
            }
        };
        stopButton3.setOnClickListener(stopper3);

        View.OnClickListener stopper4 = new View.OnClickListener(){
            public void onClick(View view){
                thread4Running = false;
                stopButton4.setEnabled(false);
                ColorDrawable box4Color = (ColorDrawable) box4.getBackground();
                int box4colorId = box4Color.getColor();

                if(box4colorId == Color.parseColor(colorWheel.mColors[1])){
                    if(!thread1Running && !thread2Running && !thread3Running){
                        startButton.setVisibility(View.VISIBLE);
                        stopTest.setText("Score");
                        highScore.setVisibility(View.VISIBLE);
                        highScore.setText("Success!");
                        scoreCount++;
                        score.setText(scoreCount + "");
                        sleepTimer -= 20;
                    } else {

                    }
                } else {
                    startButton.setVisibility(View.VISIBLE);
                    thread1Running = false;
                    thread2Running = false;
                    thread3Running = false;
                    stopButton2.setEnabled(false);
                    stopButton3.setEnabled(false);
                    stopButton1.setEnabled(false);
                    if(scoreCount > 0){
                        stopTest.setText("Score");
                    } else {
                        stopTest.setText("");
                    }
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Failure!");
                    strikeCount++;
                }
                if (strikeCount == 1) {
                    strike1.setVisibility(View.VISIBLE);
                } else if (strikeCount == 2) {
                    strike2.setVisibility(View.VISIBLE);
                } else if (strikeCount == 3) {
                    strike3.setVisibility(View.VISIBLE);
                    highScore.setVisibility(View.VISIBLE);
                    highScore.setText("Final Score " + scoreCount);
                    scoreCount = 0;
                    stopTest.setText("Game");
                    score.setText("Over");
                    sleepTimer = 600;
                    startButton.setText("Start Game");
                }
            }
        };
        stopButton4.setOnClickListener(stopper4);

        View.OnClickListener starterButton = new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (strikeCount >= 3) {
                    strike1.setVisibility(View.INVISIBLE);
                    strike2.setVisibility(View.INVISIBLE);
                    strike3.setVisibility(View.INVISIBLE);
                    highScore.setVisibility(View.INVISIBLE);
                    strikeCount = 0;
                    stopTest.setText("");
                    score.setText("");
                }

                highScore.setVisibility(View.INVISIBLE);
                thread1Running = true;
                thread2Running = true;
                thread3Running = true;
                thread4Running = true;
                startButton.setVisibility(View.INVISIBLE);
                startButton.setText("Continue");
                stopButton1.setEnabled(true);
                stopButton2.setEnabled(true);
                stopButton3.setEnabled(true);
                stopButton4.setEnabled(true);
                randomStarter = new Random();
                colorCycle1 = randomStarter.nextInt(3);
                colorCycle2 = randomStarter.nextInt(3);
                colorCycle3 = randomStarter.nextInt(3);
                colorCycle4 = randomStarter.nextInt(3);






                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        while (thread1Running) {
                            if (thread1Running == false) {break;}

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    box1.setBackgroundColor(Color.parseColor(colorWheel.mColors[colorCycle1]));
                                }
                            });

                            try {
                                Thread.sleep(sleepTimer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(scoreCount < 3){
                                if(colorCycle1 == (colorWheel.mColors.length -5)){
                                    colorCycle1 = 0;
                                } else {
                                    colorCycle1++;
                                }
                            } else if(scoreCount >=3 && scoreCount<6){
                                if(colorCycle1 == (colorWheel.mColors.length -4)){
                                    colorCycle1 = 0;
                                } else {
                                    colorCycle1++;
                                }
                            } else if(scoreCount >=6 && scoreCount<9){
                                if(colorCycle1 == (colorWheel.mColors.length -3)){
                                    colorCycle1 = 0;
                                } else {
                                    colorCycle1++;
                                }
                            } else if(scoreCount >=9 && scoreCount<12){
                                if(colorCycle1 == (colorWheel.mColors.length -2)){
                                    colorCycle1 = 0;
                                } else {
                                    colorCycle1++;
                                }
                            } else if(scoreCount >=12){
                                if(colorCycle1 == (colorWheel.mColors.length -1)){
                                    colorCycle1 = 0;
                                } else {
                                    colorCycle1++;
                                }
                            }


                        }
                    }
                }).start();
                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        while (thread2Running) {
                            if (thread2Running == false) {break;}

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    box2.setBackgroundColor(Color.parseColor(colorWheel.mColors[colorCycle2]));
                                }
                            });

                            try {
                                Thread.sleep(sleepTimer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(scoreCount < 3){
                                if(colorCycle2 == (colorWheel.mColors.length -5)){
                                    colorCycle2 = 0;
                                } else {
                                    colorCycle2++;
                                }
                            } else if(scoreCount >=3 && scoreCount<6){
                                if(colorCycle2 == (colorWheel.mColors.length -4)){
                                    colorCycle2 = 0;
                                } else {
                                    colorCycle2++;
                                }
                            } else if(scoreCount >=6 && scoreCount<9){
                                if(colorCycle2 == (colorWheel.mColors.length -3)){
                                    colorCycle2 = 0;
                                } else {
                                    colorCycle2++;
                                }
                            } else if(scoreCount >=9 && scoreCount<12){
                                if(colorCycle2 == (colorWheel.mColors.length -2)){
                                    colorCycle2 = 0;
                                } else {
                                    colorCycle2++;
                                }
                            } else if(scoreCount >=12){
                                if(colorCycle2 == (colorWheel.mColors.length -1)){
                                    colorCycle2 = 0;
                                } else {
                                    colorCycle2++;
                                }
                            }

                        }
                    }
                }).start();
                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        while (thread3Running) {
                            if (thread3Running == false) {break;}

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    box3.setBackgroundColor(Color.parseColor(colorWheel.mColors[colorCycle3]));
                                }
                            });

                            try {
                                Thread.sleep(sleepTimer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(scoreCount < 3){
                                if(colorCycle3 == (colorWheel.mColors.length -5)){
                                    colorCycle3 = 0;
                                } else {
                                    colorCycle3++;
                                }
                            } else if(scoreCount >=3 && scoreCount<6){
                                if(colorCycle3 == (colorWheel.mColors.length -4)){
                                    colorCycle3 = 0;
                                } else {
                                    colorCycle3++;
                                }
                            } else if(scoreCount >=6 && scoreCount<9){
                                if(colorCycle3 == (colorWheel.mColors.length -3)){
                                    colorCycle3 = 0;
                                } else {
                                    colorCycle3++;
                                }
                            } else if(scoreCount >=9 && scoreCount<12){
                                if(colorCycle3 == (colorWheel.mColors.length -2)){
                                    colorCycle3 = 0;
                                } else {
                                    colorCycle3++;
                                }
                            } else if(scoreCount >=12){
                                if(colorCycle3 == (colorWheel.mColors.length -1)){
                                    colorCycle3 = 0;
                                } else {
                                    colorCycle3++;
                                }
                            }

                        }
                    }
                }).start();
                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        while (thread4Running) {
                            if (thread4Running == false) {break;}

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    box4.setBackgroundColor(Color.parseColor(colorWheel.mColors[colorCycle4]));
                                }
                            });

                            try {
                                Thread.sleep(sleepTimer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            if(scoreCount < 3){
                                if(colorCycle4 == (colorWheel.mColors.length -5)){
                                    colorCycle4 = 0;
                                } else {
                                    colorCycle4++;
                                }
                            } else if(scoreCount >=3 && scoreCount<6){
                                if(colorCycle4 == (colorWheel.mColors.length -4)){
                                    colorCycle4 = 0;
                                } else {
                                    colorCycle4++;
                                }
                            } else if(scoreCount >=6 && scoreCount<9){
                                if(colorCycle4 == (colorWheel.mColors.length -3)){
                                    colorCycle4 = 0;
                                } else {
                                    colorCycle4++;
                                }
                            } else if(scoreCount >=9 && scoreCount<12){
                                if(colorCycle4 == (colorWheel.mColors.length -2)){
                                    colorCycle4 = 0;
                                } else {
                                    colorCycle4++;
                                }
                            } else if(scoreCount >=12){
                                if(colorCycle4 == (colorWheel.mColors.length -1)){
                                    colorCycle4 = 0;
                                } else {
                                    colorCycle4++;
                                }
                            }

                        }
                    }
                }).start();
            }
        };
        startButton.setOnClickListener(starterButton);
    }
}



