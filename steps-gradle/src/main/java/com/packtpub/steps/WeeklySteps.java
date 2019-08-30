package com.packtpub.steps;

import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeeklySteps {
    List<Steps> dailySteps = new ArrayList<>();
    DailyGoal dailGoal;

    public List<Steps> getDailySteps() {
        return dailySteps;
    }

    public void setDailySteps(List<Steps> dailySteps) {
        this.dailySteps = dailySteps;
    }

    public DailyGoal getDailGoal() {
        return dailGoal;
    }

    public void setDailGoal(DailyGoal dailGoal) {
        this.dailGoal = dailGoal;
    }

    public DayOfWeek bestDay() {
        DayOfWeek best = DayOfWeek.MONDAY;

        int max = 0;
        for (Steps steps : dailySteps) {
            if(steps.getSteps() > max) {
                max = steps.getSteps();
                best = steps.getDate().getDayOfWeek();
            }
        }

        return best;
    }

    public int getTotalSteps() {
        int total = 0;
        for (Steps steps : dailySteps) {
            total += steps.getSteps();
        }
        return total;
    }

    public String format() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total steps: " + getTotalSteps() + "\n");

        for (Steps steps : dailySteps) {
            if (dailGoal.hasMetGoal(steps)) {
                builder.append("YAY! ");
            } else {
                builder.append("     ");
            }

            String day = steps.getDate().getDayOfWeek().toString();

            builder.append(StringUtils.rightPad(day, 11));
            builder.append(" ");
            String stp = Integer.toString(steps.getSteps());
            builder.append(StringUtils.leftPad(stp, 6));

            DayOfWeek best = bestDay();

            if (steps.getDate().getDayOfWeek() == best) {
                builder.append(" ***** BEST DAY!");
            }
            builder.append("\n");

        }

        return builder.toString();
    }

    public void addDailySteps(int steps, LocalDate date) {
        dailySteps.add(new Steps(steps, date));
    }

    public static void main(String[] args) {
        DailyGoal dailyGoal = new DailyGoal(10000);

        WeeklySteps weekly = new WeeklySteps();
        weekly.setDailGoal(dailyGoal);

        int year = 2021;
        int month = 1;
        int day = 4;

        weekly.addDailySteps(11543, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(12112, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(10005, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(10011, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(9000, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(20053, LocalDate.of(year, month, day));
        day++;
        weekly.addDailySteps(20048, LocalDate.of(year, month, day));
        day++;

        System.out.println(weekly.format());
    }

}
