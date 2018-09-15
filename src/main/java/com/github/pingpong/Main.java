package com.github.pingpong;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InvalidTimeSlotException, IOException {

        String data = "2\n" +
                "9 10\n" +
                "9 12\n" +
                "4\n" +
                "9 10\n" +
                "9 12\n" +
                "13 15\n" +
                "10 18\n" +
                "7\n" +
                "9 11\n" +
                "12 14\n" +
                "13 15\n" +
                "11 18\n" +
                "14 18\n" +
                "10 14\n" +
                "15 18\n" +
                "9\n" +
                "9 10\n" +
                "9 12\n" +
                "14 15\n" +
                "16 18\n" +
                "14 18\n" +
                "10 13\n" +
                "15 18\n" +
                "10 14\n" +
                "9 13\n" +
                "8\n" +
                "9 14\n" +
                "15 17\n" +
                "12 13\n" +
                "16 18\n" +
                "10 15\n" +
                "14 16\n" +
                "9 13\n" +
                "9 15";

        TimeSlot officeTimeSlot = new TimeSlot(9, 18);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                int player = Integer.parseInt(line);
                Player[] players = new Player[player];
                for (int i = 0; i < player; i++) {
                    String[] slot = br.readLine().split("\\s+");
                    players[i] = new Player("Player" + (i + 1), Integer.parseInt(slot[0]), Integer.parseInt(slot[1]));
                }
                try {
                    PingPong pingPong = new PingPong(officeTimeSlot, players);
                    Result result = pingPong.calculateResult();
                    System.out.println("INPUT");
                    System.out.println(players.length);
                    Arrays.stream(players).forEach(System.out::println);
                    System.out.println("OUTPUT");
                    System.out.println(result.getSingles() + " " + result.getDoubles());

                } catch (InvalidTimeSlotException e) {
                    System.out.println(e.getMessage());
                }

            }

        }
    }
}
