package org.algos.ic;

import java.util.*;

public class MeetingsMerger {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    //O(n2)
    public static List<Meeting> mergeMeetings(List<Meeting> meetings) {

        List<Meeting> result = new ArrayList<Meeting>();
        result.add(meetings.get(0));

        for (Meeting prev : result) {

            for(Meeting curr : meetings){

                if (curr.getStartTime() <= prev.getEndTime()) {
                    prev.setEndTime(Math.max(prev.getEndTime(), curr.getEndTime()));
                } else {
                    result.add(curr);
                }

            }
        }

        return new ArrayList<Meeting>(result);
    }

    //O(n)
    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        List<Meeting> mergedMeetings = new ArrayList<Meeting>();

        //make a copy
        List<Meeting> sortedMeetings = new ArrayList<Meeting>();
        for (Meeting m : meetings) {
            sortedMeetings.add(m);
        }
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {

            public int compare(Meeting o1, Meeting o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });

        //initialize the mergeMeetings with the earlier meeting

        mergedMeetings.add(sortedMeetings.get(0));
        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            if (currentMeeting.getStartTime() <= lastMeeting.getEndTime()) {
                lastMeeting.setEndTime(Math.max(lastMeeting.getEndTime(), currentMeeting.getEndTime()));
            } else
                mergedMeetings.add(currentMeeting);
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(2, 4), new Meeting(1,6), new Meeting(1,4), new Meeting(1,10));
        final List<Meeting> result = mergeRanges(meetings);
        final List<Meeting> result1 = mergeMeetings(meetings);
        System.out.println("O(n) -> "+ result);
        System.out.println("O(n2) -> "+ result1);

    }
}
