import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String id;
    private String model;
    private int year;

    public Vehicle(String id, String model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public abstract double calculateBill();
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String id, String model, int year, int numDoors) {
        super(id, model, year);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public double calculateBill() {
        return 50.0 + (10.0 * numDoors);
    }
}

class Motorbike extends Vehicle {
    private int engineCapacity;

    public Motorbike(String id, String model, int year, int engineCapacity) {
        super(id, model, year);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public double calculateBill() {
        return 30.0 + (0.2 * engineCapacity);
    }
}

class Garage {
    private List<Vehicle> vehicles;

    public Garage() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicleById(String id) {
        vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    public void removeVehiclesByType(Class<?> type) {
        vehicles.removeIf(vehicle -> vehicle.getClass().equals(type));
    }

    public void calculateBills() {
        for (Vehicle vehicle : vehicles) {
            double bill = vehicle.calculateBill();
            System.out.println("Bill for " + vehicle.getClass().getSimpleName() + " (" + vehicle.getModel() + "): £" + bill);
        }
    }

    public void fixVehicle(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                System.out.println("Fixing vehicle: " + vehicle.getModel());
                System.out.println("Bill: £" + vehicle.calculateBill());
                return;
            }
        }
        System.out.println("Vehicle with ID " + id + " not found.");
    }

    public void emptyGarage() {
        vehicles.clear();
        System.out.println("Garage is now empty.");
    }
}

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Car("C001", "Toyota Corolla", 2020, 4);
        Motorbike bike1 = new Motorbike("M001", "Yamaha R3", 2019, 300);

        garage.addVehicle(car1);
        garage.addVehicle(bike1);
        garage.calculateBills();
        garage.fixVehicle("C001");
        garage.removeVehicleById("M001");
        garage.removeVehiclesByType(Car.class);
        garage.emptyGarage();
    }
}
