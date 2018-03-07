package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int totalScoreTeamA;
    int totalScoreTeamB;

    static final String SCORE_A_ID = "TeamAScore";
    static final String SCORE_B_ID = "TeamBScore";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    //for saving data when app crushes or orientation of phone changes
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(SCORE_A_ID, totalScoreTeamA);
        savedInstanceState.putInt(SCORE_B_ID, totalScoreTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        // Always call the superclass so it can restore the view hierarchy
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // Restore state members from saved instance
//        totalScoreTeamA = savedInstanceState.getInt(SCORE_A_ID);
//        totalScoreTeamB = savedInstanceState.getInt(SCORE_B_ID);
//
//        //but then you have to make a workaround for displaying '0' at the app start
//        displayForTeamA(totalScoreTeamA);
//        displayForTeamB(totalScoreTeamB);
//    }


    //one way of restroing value -> overriding onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Always call the superclass first

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            totalScoreTeamA = savedInstanceState.getInt(SCORE_A_ID);
            totalScoreTeamB = savedInstanceState.getInt(SCORE_B_ID);
        } else {
            // Probably initialize members with default values for a new instance
            totalScoreTeamA = 0;
            totalScoreTeamB = 0;
        }
        setContentView(R.layout.activity_main);

        displayForTeamA(totalScoreTeamA);
        displayForTeamB(totalScoreTeamB);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeTeamA(View v){
        totalScoreTeamA += 3;
        displayForTeamA(totalScoreTeamA);
    }

    public void addTwoTeamA(View v){
        totalScoreTeamA += 2;
        displayForTeamA(totalScoreTeamA);
    }

    public void addOneTeamA(View v){
        totalScoreTeamA += 1;
        displayForTeamA(totalScoreTeamA);
    }


    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeTeamB(View v){
        totalScoreTeamB += 3;
        displayForTeamB(totalScoreTeamB);
    }

    public void addTwoTeamB(View v){
        totalScoreTeamB += 2;
        displayForTeamB(totalScoreTeamB);
    }

    public void addOneTeamB(View v){
        totalScoreTeamB += 1;
        displayForTeamB(totalScoreTeamB);
    }

    public void reset(View v){
        totalScoreTeamA = 0;
        totalScoreTeamB = 0;
        displayForTeamA(totalScoreTeamA);
        displayForTeamB(totalScoreTeamB);
    }
}
