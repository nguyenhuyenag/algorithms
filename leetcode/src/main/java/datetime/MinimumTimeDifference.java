package datetime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] minutesList = new int[size];
        for (int i = 0; i < size; i++) {
            String[] parts = timePoints.get(i).split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList[i] = totalMinutes;
        }

        Arrays.sort(minutesList);

        // Calculate the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            int diff = minutesList[i] - minutesList[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Consider circular time
        int circularDiff = 24 * 60 + minutesList[0] - minutesList[size - 1];
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    @Test
    public void test() {
        assertEquals(1, findMinDifference(List.of("23:59", "00:00")));
    }

}
