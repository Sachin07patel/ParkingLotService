package org.example.models;

import java.util.Date;

public class Ticket {
    private String ticketNumber;
    private Date entryDate;

    private int entryGateNumber;

    private String carRegistrationNumber;

    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public void setEntryGateNumber(int entryGateNumber) {
        this.entryGateNumber = entryGateNumber;
    }

    public Ticket(String ticketNumber, Date entryDate, String carRegistrationNumber,int entryGateNumber) {
        this.ticketNumber = ticketNumber;
        this.entryDate = entryDate;
        this.carRegistrationNumber = carRegistrationNumber;
        this.entryGateNumber=entryGateNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }
}
