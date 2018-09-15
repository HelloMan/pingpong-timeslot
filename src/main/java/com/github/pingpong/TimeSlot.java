package com.github.pingpong;

/**
 * Created by chaojun on 18/9/15.
 */
class TimeSlot {

    private int startTime;
    private int endTime;


    public TimeSlot(int startTime, int endTime) throws InvalidTimeSlotException {

        if (endTime - startTime <= 0) {
            throw new InvalidTimeSlotException("Invalid time slot " + startTime + "-" + endTime);
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "" + startTime + " " + endTime;
    }

    @Override
    public int hashCode() {
        int result = startTime;
        result = 31 * result + endTime;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeSlot)) {
            return false;
        }
        TimeSlot ts = (TimeSlot) obj;
        return ts.endTime == this.endTime && ts.startTime == this.startTime;
    }

}
