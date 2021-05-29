package com.ljw.tddjavatest;

public class Study {

//    private StudyStatus status = StudyStatus.DRAFT;
    private StudyStatus status;
    private int limit;

    public Study(int limit) {
        if(limit <0 ){
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }
}
