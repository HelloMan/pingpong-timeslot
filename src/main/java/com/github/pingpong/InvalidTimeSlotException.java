package com.github.pingpong;

/**
 * Created by chaojun on 18/9/15.
 */
class InvalidTimeSlotException extends Exception {
    private static final long serialVersionUID = -3637558947470656433L;

    public InvalidTimeSlotException(String msg) {
        super(msg);
    }

}
