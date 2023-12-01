package org.example.homeworks.oop.additional;

import org.example.homeworks.oop.additional.exception.FullDateValidationException;

import java.util.Objects;

public class FullDate {
    private byte day;
    private byte month;
    private short year;

    public static FullDate plusYears(FullDate date, short years) {
        FullDate newDate = new FullDate(
                date.getDay(),
                date.getMonth(),
                date.getYear());

        newDate.plusYears(years);
        return newDate;
    }

    public FullDate() {

    }
    public FullDate(byte day, byte month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;

        checkTheDate();
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
        checkTheDate();
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
        checkTheDate();
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
        checkTheDate();
    }

    private void checkTheDate() {
        if (day <= 0 || month <= 0 || year <= 0) {
            generateException("Задан неверный формат даты");
        }
        if (day > 31) {
            generateException("Указано неверное значение дня");
        }
        if (month > 12) {
            generateException("Указано неверное значение месяца");
        }
        if (year < 1900 || year > 3000) {
            generateException("Указано неверное значение года");
        }
    }

    private void plusYears(short years) {
        year += years;
        checkTheDate();
    }

    private void generateException(String message) {
        throw new FullDateValidationException(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullDate fullDate = (FullDate) o;
        return day == fullDate.day && month == fullDate.month && year == fullDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%s.%s.%s", day, month, year);
    }
}
