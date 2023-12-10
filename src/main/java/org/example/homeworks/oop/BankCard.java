package org.example.homeworks.oop;

import org.example.homeworks.oop.additional.FullDate;

import java.util.Objects;

public class BankCard {
    private static final byte VALIDITY_PERIOD = 2;

    private String FullNameOfClient;
    private FullDate birthDate;
    private FullDate registrationDate;
    private FullDate expirationDate;

    public BankCard() {

    }

    public BankCard(String fullNameOfClient, FullDate birthDate, FullDate registrationDate) {
        FullNameOfClient = fullNameOfClient;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;

        calculateExpirationDate();
    }

    public String getFullNameOfClient() {
        return FullNameOfClient;
    }

    public void setFullNameOfClient(String fullNameOfClient) {
        FullNameOfClient = fullNameOfClient;
    }

    public FullDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(FullDate birthDate) {
        this.birthDate = birthDate;
    }

    public FullDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(FullDate registrationDate) {
        this.registrationDate = registrationDate;
        calculateExpirationDate();
    }

    public FullDate getExpirationDate() {
        return expirationDate;
    }

    private void calculateExpirationDate() {
        expirationDate = FullDate.plusYears(registrationDate, VALIDITY_PERIOD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(FullNameOfClient, bankCard.FullNameOfClient)
                && Objects.equals(birthDate, bankCard.birthDate)
                && Objects.equals(registrationDate, bankCard.registrationDate)
                && Objects.equals(expirationDate, bankCard.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FullNameOfClient, birthDate, registrationDate, expirationDate);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "\nFIO='" + FullNameOfClient + '\'' +
                ",\n birth date=" + birthDate +
                ",\n registration date=" + registrationDate +
                ",\n expiration date=" + expirationDate +
                '}';
    }
}
