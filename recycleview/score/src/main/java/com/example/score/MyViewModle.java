package com.example.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModle extends ViewModel {
    private MutableLiveData<Integer> ateamScore;
    private MutableLiveData<Integer> bteamScore;
    private int aBack,bBack;

    public MutableLiveData<Integer> getAteamScore() {
        if(ateamScore==null){
            ateamScore=new MutableLiveData<>();
            ateamScore.setValue(0);
        }
        return ateamScore;
    }

    public MutableLiveData<Integer> getBteamScore() {
        if(bteamScore==null){
            bteamScore=new MutableLiveData<>();
            bteamScore.setValue(0);
        }
        return bteamScore;
    }
    public void aTeamAdd(int n){
        aBack=ateamScore.getValue();
        bBack=bteamScore.getValue();
        ateamScore.setValue(ateamScore.getValue()+n);
    }
    public void bTeamAdd(int n){
        aBack=ateamScore.getValue();
        bBack=bteamScore.getValue();
        bteamScore.setValue(bteamScore.getValue()+n);
    }
    public void reset(){
        aBack=ateamScore.getValue();
        bBack=bteamScore.getValue();
        ateamScore.setValue(0);
        bteamScore.setValue(0);
    }
    public void undo(){
        ateamScore.setValue(aBack);
        bteamScore.setValue(bBack);
    }
}
