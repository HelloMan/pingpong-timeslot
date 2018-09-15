package com.github.pingpong;

/**
 * Created by chaojun on 18/9/15.
 */
class Result {

    private int singles;
    private int doubles;


    public Result(int singles, int doubles) {
        this.singles = singles;
        this.doubles = doubles;
    }

    public int getSingles() {
        return singles;
    }

    public int getDoubles() {
        return doubles;
    }
}
