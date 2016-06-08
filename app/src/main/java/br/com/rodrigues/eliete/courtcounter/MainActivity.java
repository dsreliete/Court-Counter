package br.com.rodrigues.eliete.courtcounter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getName();
    public static final String TEAM_A = "teamA";
    public static final String TEAM_B = "teamB";

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    TextView scoreViewA;
    TextView scoreViewB;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on Resume");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "on Configuration Change");

        if (newConfig.orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);

        } else if (newConfig.orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);

        }

        initTextView();

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "on Create");
        setContentView(R.layout.activity_main);

        initTextView();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "on Saved Instance State");

        outState.putInt(TEAM_A, scoreTeamA);
        outState.putInt(TEAM_B, scoreTeamB);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamA = savedInstanceState.getInt(TEAM_A);
        scoreTeamB = savedInstanceState.getInt(TEAM_B);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "on Destroy");
    }

    public void initTextView(){
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
    }


    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    public void addThreePointsTeamA(View view){
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoPointsTeamA(View view){
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addFreeThrowPointsTeamA(View view){
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreePointsTeamB(View view){
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoPointsTeamB(View view){
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addFreeThrowPointsTeamB(View view){
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetButton(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
