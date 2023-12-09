import org.example.ParkingLotService;
import org.example.models.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {
    //for parking car
    @Test
    void testParkCar() {
        ParkingLotService parkingLot = new ParkingLotService(2);
        Car car1 = new Car("ABC123", "Red");
        Car car2 = new Car("XYZ456", "Blue");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);

        assertNotNull(parkingLot.getTicketNumberByRegNumber("XYZ456"));
    }

    //Get Reg number by color
    @Test
    void testGetRegNumbersByColor() {
        ParkingLotService parkingLot = new ParkingLotService(3);
        Car car1 = new Car("ABC123", "Red");
        Car car2 = new Car("XYZ456", "Blue");
        Car car3 = new Car("DEF789", "Red");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);

        assertEquals(2, parkingLot.getRegNumbersByColor("Red").size());
        assertTrue(parkingLot.getRegNumbersByColor("Red").contains("ABC123"));
        assertTrue(parkingLot.getRegNumbersByColor("Red").contains("DEF789"));
        assertFalse(parkingLot.getRegNumbersByColor("Red").contains("XYZ456"));
    }

    @Test
    void testGetTicketNumberByRegNumber() {
        ParkingLotService parkingLot = new ParkingLotService(3);
        Car car1 = new Car("ABC123", "Red");
        Car car2 = new Car("XYZ456", "Blue");
        Car car3 = new Car("DEF789", "Red");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);

        assertNotNull(parkingLot.getTicketNumberByRegNumber("XYZ456"));
        assertEquals ("-1", parkingLot.getTicketNumberByRegNumber("LMN789"));
    }

    @Test
    void testGetTicketNumbersByColor() {
        ParkingLotService parkingLot = new ParkingLotService(3);
        Car car1 = new Car("ABC123", "Red");
        Car car2 = new Car("XYZ456", "Blue");
        Car car3 = new Car("DEF789", "Red");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);

        assertEquals(2, parkingLot.getTicketNumbersByColor("Red").size());
        assertEquals(0,parkingLot.getRegNumbersByColor("Green").size());
        assertNotNull(parkingLot.getTicketNumbersByColor("Red"));
    }
}
