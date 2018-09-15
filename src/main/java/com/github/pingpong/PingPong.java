package com.github.pingpong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chaojun on 18/9/15.
 */
class PingPong {

    private HashMap<TimeSlot, Set<Player>> mapOfficeTimeSlot;

    public PingPong(TimeSlot timeSlot, Player[] players) throws InvalidTimeSlotException {

        mapOfficeTimeSlot = new HashMap<>();
        for (int i = timeSlot.getStartTime(); i < timeSlot.getEndTime(); i++) {

            mapOfficeTimeSlot.put(new TimeSlot(i, i + 1), new HashSet<>());
        }
        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            //put players availability in office time slot
            for (int j = p.getTimeSlot().getStartTime(); j < p.getTimeSlot().getEndTime(); j++) {
                TimeSlot ts = new TimeSlot(j, j + 1);
                mapOfficeTimeSlot.get(ts).add(p);
            }
        }
    }


    public Result calculateResult() {
        int countSingles = 0;
        int countDoubles = 0;
        Iterator<TimeSlot> iterator = mapOfficeTimeSlot.keySet().iterator();
        while (iterator.hasNext()) {
            TimeSlot timeSlot = iterator.next();
            int size = mapOfficeTimeSlot.get(timeSlot).size();
            if (size >= 4) {
                countDoubles++;
            } else if (size > 1 && size < 4) {
                countSingles++;
            }
        }
        return new Result(countSingles, countDoubles);
    }


}
