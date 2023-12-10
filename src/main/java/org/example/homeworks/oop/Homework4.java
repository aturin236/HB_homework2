package org.example.homeworks.oop;

import org.example.homeworks.oop.additional.FullDate;

public class Homework4 {
    public static void runHomework() {
        BankCard bankCard = new BankCard(
                "Иванов Иван Иванович",
                new FullDate((byte) 14, (byte) 2, (short) 1980),
                new FullDate((byte) 1, (byte) 12, (short) 2023)
        );

        System.out.println(bankCard);
    }
}
