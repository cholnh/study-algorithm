package com.nzzi.study.date;

public class DateExample {

    private int fine;
    private int dueDay;
    private int dueMonth;
    private int dueYear;
    private int retDay;
    private int retMonth;
    private int retYear;

    private DateExample(int d1, int m1, int y1, int d2, int m2, int y2) {
        fine = 0;
        dueDay = d2;
        dueMonth = m2;
        dueYear = y2;
        retDay = d1;
        retMonth = m1;
        retYear = y1;
    }

    public static DateExample of(int d1, int m1, int y1, int d2, int m2, int y2) {
        return new DateExample(d1,m1,y1,d2,m2,y2);
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        return DateExample.of(d1,m1,y1,d2,m2,y2)
                .libraryFine();
    }

    private int libraryFine() {
        if (isLate())
            calculateFine();
        return fine;
    }

    private void calculateFine() {
        calculateFineInYear();
        calculateFineInMonth();
        calculateFineInDay();
    }

    private void calculateFineInYear() {
        if (dueYear < retYear)
            fine = 10000;
    }

    private void calculateFineInMonth() {
        if (dueYear < retYear) return;
        if (dueMonth < retMonth)
            fine = 500 * (retMonth - dueMonth);
    }

    private void calculateFineInDay() {
        if (dueYear < retYear ||
                dueMonth < retMonth) return;
        if (dueDay < retDay)
            fine = 15 * (retDay - dueDay);
    }

    private boolean isLate() {
        return dueYear < retYear ||
                (dueYear == retYear && dueMonth < retMonth) ||
                (dueYear == retYear && dueMonth == retMonth && dueDay < retDay);
    }
}
