package edu.iu.smart.assistance.model;

/**
 * Created by Sujeet on 4/29/17.
 */

public class WeekModel {

    private static DayModel[] days;

    public static DayModel[] getDays() {
        if (days != null) return days;

        days = new DayModel[7];

        for(int i =0; i < days.length; i++){
            days[i] = new DayModel();
        }
        return days;
    }

    public static void setDays(DayModel[] days) {
        days = days;
    }

    private WeekModel() {

    }

    public static class DayModel{

        public boolean[] hours;

        public boolean[] getHours() {
            return hours;
        }

        public void setHours(boolean[] hours) {
            this.hours = hours;
        }

        public DayModel() {
            this.hours = new boolean[24];
        }
    }
}
