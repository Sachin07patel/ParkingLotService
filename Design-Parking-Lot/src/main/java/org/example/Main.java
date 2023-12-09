package org.example;

import org.example.models.Car;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLot=new ParkingLotService(15);
        while(true){
            System.out.println("Enter 1 to enter car details for parking car");
            System.out.println("Enter 2 to get registration numbers of all cars of specific color");
            System.out.println("Enter 3 to get ticket number of a car by its registration umber");
            System.out.println("Enter 4 to get ticket numbers of all cars of specific color");
            System.out.println("Enter 5 to exit from Parking Lot");
            Scanner sc=new Scanner(System.in);
            String number=sc.nextLine();
            if(number.equals("1")){
                System.out.println("Enter car registration number : ");
                String registrationNumber=sc.nextLine();
                System.out.println("Enter car color : ");
                String color= sc.nextLine();;
                Car car =new Car(registrationNumber,color);
                parkingLot.parkCar(car);
            }else if(number.equals("2")){
                System.out.println("Enter the color : ");
                String color= sc.nextLine();
                List<String> regNumbers=parkingLot.getRegNumbersByColor(color);
                if(regNumbers.isEmpty()){
                    System.out.println("There is no car with color "+color);
                    continue;
                }
                for(String regNumber: regNumbers){
                    System.out.println(regNumber);
                }
            }else if(number.equals("3")){
                System.out.println("Enter the registration number : ");
                String regNumber= sc.nextLine();
                if(parkingLot.getTicketNumberByRegNumber(regNumber).equals("-1")){
                    System.out.println("Ticket number for registration number "+regNumber+" doesn't exist enter correct registration number");
                    continue;
                }
                System.out.println(parkingLot.getTicketNumberByRegNumber(regNumber)) ;
            }else if(number.equals("4")){
                System.out.println("Enter the color : ");
                String color= sc.nextLine();
                List<String> ticketNumbers=parkingLot.getTicketNumbersByColor(color);
                if(ticketNumbers.isEmpty()){
                    System.out.println("There is no car with color "+color);
                    continue;
                }
                for(String ticketNumber: ticketNumbers){
                    System.out.println(ticketNumber);
                }
            }
            else{
                break;
            }
        }
    }
}