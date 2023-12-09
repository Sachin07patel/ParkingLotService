package org.example;

import org.example.models.Car;
import org.example.models.Ticket;

import java.util.*;

public class ParkingLotService {
    private int availableSpots;

    private Map<Integer,Car> parkingSpots;
    private Map<Car, Ticket> carTicketMap;

    public ParkingLotService(int capacity){
        this.availableSpots=capacity;
        parkingSpots=new HashMap<>();
        carTicketMap=new HashMap<>();
    }

    public void parkCar(Car car){
        for(Car parkedCar: carTicketMap.keySet()){
            if(parkedCar.getRegistrationNumber().equalsIgnoreCase(car.getRegistrationNumber())){
                System.out.println("Car with registration number "+ car.getRegistrationNumber()+" already parked");
                return;
            }
        }
        if(availableSpots>0){
            Ticket ticket=new Ticket(UUID.randomUUID().toString(),new Date(),car.getRegistrationNumber(),1);
            parkingSpots.put(availableSpots,car);
            carTicketMap.put(car,ticket);
            availableSpots--;
            System.out.println("Car parked with ticket Number : "+ticket.getTicketNumber());
        }
        else{
            System.out.println("Parking lot is full, Can't park a car");
        }
    }

    public List<String> getRegNumbersByColor(String color){
        List<String> registrationNumbers=new ArrayList<>();
        for(Car car: parkingSpots.values()){
            if(car.getColor().equalsIgnoreCase(color)){
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public String getTicketNumberByRegNumber(String regNumber){
        for(Map.Entry<Car,Ticket> entry: carTicketMap.entrySet()){
            if(entry.getKey().getRegistrationNumber().equalsIgnoreCase(regNumber)){
                return entry.getValue().getTicketNumber();
            }
        }
        return "-1";
    }

    public List<String> getTicketNumbersByColor(String color){
        List<String> ticketNumbers=new ArrayList<>();
        for(Map.Entry<Car,Ticket> entry: carTicketMap.entrySet()){
            if(entry.getKey().getColor().equalsIgnoreCase(color)){
               ticketNumbers.add(entry.getValue().getTicketNumber());
            }
        }
        return ticketNumbers;
    }

}
