/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rezervatsiyagithub.testing;

import com.mycompany.rezervatsiyagithub.testing.musteri;
import com.mycompany.rezervatsiyagithub.testing.admin;
import com.mycompany.rezervatsiyagithub.testing.firma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.*;


interface ILoginable {

}

interface IReservable {

}

interface IProfitable {

}

abstract class User implements ILoginable {

}
// Vehicle class

// AdminObject class
class AdminObject extends User {

    private String adminUsername = "admin";
    private String adminPassword = "12345";
    private HashMap<String, Company> firms;
    private int handlingFee;

    public AdminObject(HashMap firms) {
        this.firms = firms;
    }

    public HashMap<String, Company> showFirms() {
        return this.firms;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    // Getters and Setters
    public int getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(int handlingFee) {
        this.handlingFee = handlingFee;
    }

    public void addNewFirm(String name, Company newFirm) {
        firms.put(name, newFirm);
    }

    public void delFirm(Object delFirm) {
        firms.remove(delFirm);
    }
}

// Company class
class Company extends User implements IProfitable {

    String password, userName;
    LinkedList<Vehicle> vehicles;
  

    public Company(String password, String userName) {
        this.vehicles = new LinkedList<>();
        this.password = password;
        this.userName = userName;
    }

    void addNewVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    void removeAVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return this.userName;
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
// Customer class
class Customer {

    String customerName;
    String customerSurname;
    String tcNo;

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    void listVehiclesOnADay() {

    }

    void reserve() {

    }

    void payTicket() {

    }
}

// Trip class
// Route class
class Route {

    String from;
    String to;
    ArrayList<Vehicle> vehiclesList;
    int distance;
    int cost;
    private Company firm;  // Add this line
    private Vehicle vehicle;  // Add this line
    public Route(String from, String to, ArrayList<Vehicle> vehiclesList, int distance) {
        this.from = from;
        this.to = to;
        this.vehiclesList = vehiclesList;
        this.distance = distance;
        this.cost = calculateCost();
        this.firm = firm;
        this.vehicle = vehicle;
    }
    
    public String getDeparture() {
        return from;
    }

    public String getDestination() {
        return to;
    }
    public Company getFirm() {
        if (!vehiclesList.isEmpty()) {
            Vehicle firstVehicle = vehiclesList.get(0);
            return firstVehicle.getFirm();
        }
        return null;
    }
    
    
    public Vehicle getVehicle() {
        if (!vehiclesList.isEmpty()) {
            return vehiclesList.get(0);
        }
        return null;
    }

    public int getCapacity() {
        if (!vehiclesList.isEmpty()) {
            Vehicle mainVehicle = vehiclesList.get(0);
            return mainVehicle.getCapacity();
        }
        return 0; 
    }

    public int getPrice() {
        return cost;
    }
    private int calculateCost() {
        int cost = 0;
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle instanceof Bus) {
                cost += getBusCost();
            } else if (vehicle instanceof Train) {
                cost += getTrainCost();
            } else if (vehicle instanceof Airplane) {
                cost += getAirplaneCost();
            }
        }
        return cost;
    }
  public int getFuelCost() {
        int totalFuelCost = 0;
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle instanceof Bus) {
                totalFuelCost += getBusCost();
            } else if (vehicle instanceof Train) {
                totalFuelCost += getTrainCost();
            } else if (vehicle instanceof Airplane) {
                totalFuelCost += getAirplaneCost();
            }
        }
        return totalFuelCost;
    }

    private int getBusCost() {
        if (from.equals("Istanbul") && to.equals("Kocaeli")) {
            return 50;
        } else if (from.equals("Istanbul") && to.equals("Ankara")) {
            return 300;
        } else if (from.equals("Istanbul") && to.equals("Eskisehir")) {
            return 150;
        } else if (from.equals("Istanbul") && to.equals("Konya")) {
            return 300;
        } else if (from.equals("Kocaeli") && to.equals("Ankara")) {
            return 400;
        } else if (from.equals("Kocaeli") && to.equals("Eskisehir")) {
            return 100;
        } else if (from.equals("Kocaeli") && to.equals("Konya")) {
            return 250;
        }
        return 0; 
    }

    private int getTrainCost() {
        if (from.equals("Istanbul") && to.equals("Kocaeli")) {
            return 50;
        } else if (from.equals("Istanbul") && to.equals("Bilecik")) {
            return 150;
        } else if (from.equals("Istanbul") && to.equals("Ankara")) {
            return 250;
        } else if (from.equals("Istanbul") && to.equals("Eskisehir")) {
            return 200;
        } else if (from.equals("Istanbul") && to.equals("Konya")) {
            return 300;
        } else if (from.equals("Kocaeli") && to.equals("Bilecik")) {
            return 50;
        } else if (from.equals("Kocaeli") && to.equals("Ankara")) {
            return 200;
        } else if (from.equals("Kocaeli") && to.equals("Eskisehir")) {
            return 100;
        } else if (from.equals("Kocaeli") && to.equals("Konya")) {
            return 250;
        } else if (from.equals("Bilecik") && to.equals("Ankara")) {
            return 150;
        } else if (from.equals("Bilecik") && to.equals("Eskisehir")) {
            return 50;
        } else if (from.equals("Bilecik") && to.equals("Konya")) {
            return 200;
        } else if (from.equals("Eskisehir") && to.equals("Konya")) {
            return 150;
        }
        return 0; 
    }

    private int getAirplaneCost() {
        if (from.equals("Istanbul") && to.equals("Ankara")) {
            return 1000;
        } else if (from.equals("Istanbul") && to.equals("Konya")) {
            return 1200;
        }
        return 0; 
    }


    }

// Trip class
class Trip {

    int day;
    int month = 12;
    int year = 2023;
    ArrayList<Route> route = new ArrayList<>();
    ArrayList<Vehicle> vehiclesList = new ArrayList<>();

    public Trip(int day, ArrayList<Vehicle> vehiclesList) {
        this.day = day;
        this.vehiclesList = vehiclesList;
    }

    public static double calculateFuelCost(Trip trip) {
        double totalFuelCost = 0.0;

        for (Route route : trip.route) {
            totalFuelCost += route.getFuelCost();
        }

        return totalFuelCost;
    }
}

// Person class

abstract class Person {

    String name, surName;

    String getName() {
        return this.name;
    }

    String getSurName() {
        return this.surName;
    }

    String setName(String newName) {
        this.name = newName;
        return newName;
    }

    String setSurName(String newSurName) {
        this.surName = newSurName;
        return newSurName;
    }
}

class FuelList {

    private Map<String, Double> fuelCosts = new HashMap<>();

    public FuelList() {
        fuelCosts.put("benzin", 5.0);
        fuelCosts.put("motorin", 5.0);
        fuelCosts.put("motorin6", 6.0);
        fuelCosts.put("elektrik", 3.0);
        fuelCosts.put("gaz20", 20.0);
        fuelCosts.put("gaz25", 25.0);
    }

    public double getFuelCost(String fuelType) {
        return fuelCosts.getOrDefault(fuelType, 0.0);
    }
}
// Personel class

class Personel extends Person {

}

// DriverPersonel class
class DriverPersonel extends Personel {

    int wageForVoyage;

    DriverPersonel(int wageFor) {
        this.wageForVoyage = wageFor;
    }

    public int getWageForVoyage() {
        return wageForVoyage;
    }

    public void setWageForVoyage(int wageForVoyage) {
        this.wageForVoyage = wageForVoyage;
    }
}

// NonDriverPersonel class
class NonDriverPersonel extends Personel {

    int wageForVoyage;

    NonDriverPersonel(int wageFor) {
        this.wageForVoyage = wageFor;
    }

    public int getWageForVoyage() {
        return wageForVoyage;
    }

    public void setWageForVoyage(int wageForVoyage) {
        this.wageForVoyage = wageForVoyage;
    }
}

// Passenger class
class Passenger extends Person {

}

// Reservation class
class Reservation {

    Passenger passenger;
    Vehicle vehicle;
    int seatNo;

    public Passenger getPassenger() {
        return passenger;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
// Transport class
class Transport implements IReservable {

}

abstract class Vehicle {

    static Object getCapacity;

    int vehicleID;
    String typeOfFuel;
    int capacity;
    HashMap<Integer, Boolean> seat = new HashMap<>();
    FuelList fuelList = new FuelList();
    String vehicleName;

    // Constructor
    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
                
    }

    abstract void calculateFuelCost();

    boolean isSeatFull(int no) {
        return seat.get(no);
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    Company getFirm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

// Bus class
class Bus extends Vehicle {

    LinkedList<Object> personals;
    Bus(String fuelType, String vehicleName) {
        super(vehicleName);
        this.typeOfFuel = fuelType;
        this.personals = new LinkedList<>();
    }
 Bus(String vehicleName,String fuelType, int capacity, int driverWage1, int driverWage2, int nonDriverWage1, int nonDriverWage2) {
        super(vehicleName);
        this.typeOfFuel = fuelType;
        this.capacity = capacity;

        addPersonal(new DriverPersonel(driverWage1));
        addPersonal(new DriverPersonel(driverWage2));
        addPersonal(new NonDriverPersonel(nonDriverWage1));
        addPersonal(new NonDriverPersonel(nonDriverWage2));
    }
    void addPersonal(Personel p) {
        personals.add(p);
    }

    void addPersonal() {
    }

    @Override
    void calculateFuelCost() {
    }
}

// Train class
class Train extends Vehicle {

  LinkedList<Object> personals;

    Train(String fuelType, String vehicleName) {
        super(vehicleName);
        this.typeOfFuel = fuelType;
        this.personals = new LinkedList<>();
    }

    Train(String vehicleName, String fuelType, int capacity, int driverWage1, int driverWage2, int nonDriverWage1, int nonDriverWage2) {
        this(fuelType, vehicleName);
        this.capacity = capacity;

        addPersonal(new DriverPersonel(driverWage1));
        addPersonal(new DriverPersonel(driverWage2));
        addPersonal(new NonDriverPersonel(nonDriverWage1));
        addPersonal(new NonDriverPersonel(nonDriverWage2));
    }

    void addPersonal(Personel p) {
        personals.add(p);
    }

    @Override
    void calculateFuelCost() {
    }
}

// Airplane class
class Airplane extends Vehicle {

    LinkedList<Object> personals;

    Airplane(String fuelType, String vehicleName) {
        super(vehicleName);
        this.typeOfFuel = fuelType;
        this.personals = new LinkedList<>();
    }

    Airplane(String vehicleName, String fuelType, int capacity, int driverWage1, int driverWage2, int nonDriverWage1, int nonDriverWage2) {
        this(fuelType, vehicleName);
        this.capacity = capacity;

        addPersonal(new DriverPersonel(driverWage1));
        addPersonal(new DriverPersonel(driverWage2));
        addPersonal(new NonDriverPersonel(nonDriverWage1));
        addPersonal(new NonDriverPersonel(nonDriverWage2));
    }

    void addPersonal(Personel p) {
        personals.add(p);
    }
    @Override
    void calculateFuelCost() {
    }
}

/**
 *
 * @author Emircan & Çağrı
 */
public class testinghanif extends javax.swing.JFrame {

    static HashMap<String, Company> firms = new HashMap<String, Company>();
    static AdminObject adminObject = new AdminObject(firms);
    static HashMap<String, Integer> fuelList = new HashMap<>();
    static HashMap<String, Trip> TripList = new HashMap<>();
    static Company A = new Company("admin", "firmA");
    static Company B = new Company("admin", "firmB");
    static Company C = new Company("admin", "firmC");
    static Company D = new Company("admin", "firmD");
    static Company F = new Company("admin", "firmF");

    static Bus bus1 = new Bus("benzin","Otobüs 1");
    static Bus bus2 = new Bus("benzin","Otobüs 2");
    static Bus bus3 = new Bus("motorin","Otobüs 3");
    static Bus bus4 = new Bus("motorin","Otobüs 4 ");
    static Bus bus5 = new Bus("motorin6", "Otobüs 5");

    static Airplane airplane1 = new Airplane("gaz20","Uçak 1");
    static Airplane airplane2 = new Airplane("gaz20","Uçak 2");
    static Airplane airplane3 = new Airplane("gaz25","Uçak 3");
    static Airplane airplane4 = new Airplane("gaz25","Uçak 4");
    static Train train1 = new Train("elektrik","Tren 1");
    static Train train2 = new Train("elektrik","Tren 2");
    static Train train3 = new Train("elektrik", "Tren 3");
    
    public static HashMap<String, Trip> getTripList() {
        return TripList;
    }
    
    static Trip trip1 = new Trip(1, new ArrayList<Vehicle>() {
        {
            add(bus1);
            add(train1);
        }
    });

    static Trip trip2 = new Trip(2, new ArrayList<Vehicle>() {
        {
            add(train2);
            add(train3);

        }
    });

    static Trip trip3 = new Trip(3, new ArrayList<Vehicle>() {
        {
            add(bus1);
            add(bus2);
            add(bus3);
        }
    });

    static Trip trip4 = new Trip(4, new ArrayList<Vehicle>() {
        {
            add(bus4);
            add(bus5);

        }
    });

    static Trip trip5 = new Trip(5, new ArrayList<Vehicle>() {
        {
            add(airplane1);
            add(airplane2);

        }
    });

    static Trip trip6 = new Trip(6, new ArrayList<Vehicle>() {
        {
            add(airplane3);
            add(airplane4);

        }
    });
    

    public testinghanif() {
        adminObject = new AdminObject(firms);

        bus1.capacity = 40;
        bus1.addPersonal(new DriverPersonel(5000));
        bus1.addPersonal(new DriverPersonel(5000));
        bus1.addPersonal(new NonDriverPersonel(2000));
        bus1.addPersonal(new NonDriverPersonel(2000));

        bus2.capacity = 30;
        bus2.addPersonal(new DriverPersonel(5000));
        bus2.addPersonal(new DriverPersonel(5000));
        bus2.addPersonal(new NonDriverPersonel(2000));
        bus2.addPersonal(new NonDriverPersonel(2000));

        bus3.capacity = 30;
        bus3.addPersonal(new DriverPersonel(3000));
        bus3.addPersonal(new DriverPersonel(3000));
        bus3.addPersonal(new NonDriverPersonel(1500));
        bus3.addPersonal(new NonDriverPersonel(1500));

        bus4.capacity = 40;
        bus4.addPersonal(new DriverPersonel(3000));
        bus4.addPersonal(new DriverPersonel(3000));
        bus4.addPersonal(new NonDriverPersonel(1500));
        bus4.addPersonal(new NonDriverPersonel(1500));

        bus5.capacity = 40;
        bus5.addPersonal(new DriverPersonel(4000));
        bus5.addPersonal(new DriverPersonel(4000));
        bus5.addPersonal(new NonDriverPersonel(2000));
        bus5.addPersonal(new NonDriverPersonel(2000));

        airplane1.capacity = 60;
        airplane1.addPersonal(new DriverPersonel(10000));
        airplane1.addPersonal(new DriverPersonel(10000));
        airplane1.addPersonal(new NonDriverPersonel(6000));
        airplane1.addPersonal(new NonDriverPersonel(6000));

        airplane2.capacity = 60;
        airplane2.addPersonal(new DriverPersonel(10000));
        airplane2.addPersonal(new DriverPersonel(10000));
        airplane2.addPersonal(new NonDriverPersonel(6000));
        airplane2.addPersonal(new NonDriverPersonel(6000));

        airplane3.capacity = 60;

        airplane3.addPersonal(new DriverPersonel(7500));
        airplane3.addPersonal(new DriverPersonel(7500));
        airplane3.addPersonal(new NonDriverPersonel(4000));
        airplane3.addPersonal(new NonDriverPersonel(4000));

        airplane4.capacity = 60;

        airplane4.addPersonal(new DriverPersonel(7500));
        airplane4.addPersonal(new DriverPersonel(7500));
        airplane4.addPersonal(new NonDriverPersonel(4000));
        airplane4.addPersonal(new NonDriverPersonel(4000));

        train1.capacity = 50;
        train1.addPersonal(new DriverPersonel(2000));
        train1.addPersonal(new DriverPersonel(2000));
        train1.addPersonal(new NonDriverPersonel(1000));
        train1.addPersonal(new NonDriverPersonel(1000));

        train2.capacity = 50;

        train2.addPersonal(new DriverPersonel(2000));
        train2.addPersonal(new DriverPersonel(2000));
        train2.addPersonal(new NonDriverPersonel(2000));
        train2.addPersonal(new NonDriverPersonel(2000));

        train3.capacity = 50;

        train3.addPersonal(new DriverPersonel(2000));
        train3.addPersonal(new DriverPersonel(2000));
        train3.addPersonal(new NonDriverPersonel(1000));
        train3.addPersonal(new NonDriverPersonel(1000));

        // Trip 1
        trip1.route.add(new Route("Istanbul", "Kocaeli", trip1.vehiclesList, 75));
        trip1.route.add(new Route("Istanbul", "Ankara", trip1.vehiclesList, 250));
        trip1.route.add(new Route("Istanbul", "Eskisehir", trip1.vehiclesList, 75));
        trip1.route.add(new Route("Istanbul", "Konya", trip1.vehiclesList, 300));
        trip1.route.add(new Route("Kocaeli", "Ankara", trip1.vehiclesList, 300));
        trip1.route.add(new Route("Kocaeli", "Eskisehir", trip1.vehiclesList, 150));
        trip1.route.add(new Route("Kocaeli", "Konya", trip1.vehiclesList, 350));

// Trip 2
        trip2.route.add(new Route("Istanbul", "Kocaeli", trip2.vehiclesList, 50));
        trip2.route.add(new Route("Istanbul", "Bilecik", trip2.vehiclesList, 150));
        trip2.route.add(new Route("Istanbul", "Ankara", trip2.vehiclesList, 250));
        trip2.route.add(new Route("Istanbul", "Eskisehir", trip2.vehiclesList, 200));
        trip2.route.add(new Route("Istanbul", "Konya", trip2.vehiclesList, 300));
        trip2.route.add(new Route("Kocaeli", "Bilecik", trip2.vehiclesList, 50));
        trip2.route.add(new Route("Kocaeli", "Ankara", trip2.vehiclesList, 200));
        trip2.route.add(new Route("Kocaeli", "Eskisehir", trip2.vehiclesList, 100));
        trip2.route.add(new Route("Kocaeli", "Konya", trip2.vehiclesList, 250));
        trip2.route.add(new Route("Bilecik", "Ankara", trip2.vehiclesList, 150));
        trip2.route.add(new Route("Bilecik", "Eskisehir", trip2.vehiclesList, 50));
        trip2.route.add(new Route("Bilecik", "Konya", trip2.vehiclesList, 200));
        trip2.route.add(new Route("Eskisehir", "Konya", trip2.vehiclesList, 150));

// Trip 3
        trip3.route.add(new Route("Istanbul", "Kocaeli", trip3.vehiclesList, 50));
        trip3.route.add(new Route("Kocaeli", "Ankara", trip3.vehiclesList, 400));
        trip3.route.add(new Route("Ankara", "Kocaeli", trip3.vehiclesList, 400));
        trip3.route.add(new Route("Kocaeli", "Istanbul", trip3.vehiclesList, 50));

// Trip 4
        trip4.route.add(new Route("Istanbul", "Kocaeli", trip4.vehiclesList, 50));
        trip4.route.add(new Route("Kocaeli", "Eskisehir", trip4.vehiclesList, 100));
        trip4.route.add(new Route("Eskisehir", "Konya", trip4.vehiclesList, 250));
        trip4.route.add(new Route("Konya", "Eskisehir", trip4.vehiclesList, 250));
        trip4.route.add(new Route("Eskisehir", "Kocaeli", trip4.vehiclesList, 100));
        trip4.route.add(new Route("Kocaeli", "Istanbul", trip4.vehiclesList, 50));

// Trip 5
        trip5.route.add(new Route("Istanbul", "Ankara", trip5.vehiclesList, 1000));
        trip5.route.add(new Route("Istanbul", "Konya", trip5.vehiclesList, 1200));

// Trip 6
        trip6.route.add(new Route("Istanbul", "Ankara", trip6.vehiclesList, 1000));
        trip6.route.add(new Route("Istanbul", "Konya", trip6.vehiclesList, 1200));

        TripList.put("trip1", trip1);
        TripList.put("trip2", trip2);
        TripList.put("trip3", trip3);
        TripList.put("trip4", trip4);
        TripList.put("trip5", trip5);
        TripList.put("trip6", trip6);

        A.addNewVehicle(bus1);
        A.addNewVehicle(bus2);

        B.addNewVehicle(bus3);
        B.addNewVehicle(bus4);

        C.addNewVehicle(airplane1);
        C.addNewVehicle(airplane2);
        C.addNewVehicle(bus5);

        D.addNewVehicle(train1);
        D.addNewVehicle(train2);
        D.addNewVehicle(train3);

        F.addNewVehicle(airplane4);
        F.addNewVehicle(airplane3);

        System.out.println(adminObject.showFirms());

        System.out.println(adminObject.showFirms());

        firms.put("firmA", A);

        firms.put("firmB", B);

        firms.put("firmC", C);

        firms.put("firmD", D);

        firms.put("firmF", F);
        
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 250, 237));

        jTextField1.setBackground(new java.awt.Color(255, 250, 237));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setToolTipText("");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(255, 250, 237));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(10, 5, 2));
        jSeparator1.setForeground(new java.awt.Color(140, 140, 140));

        jSeparator2.setBackground(new java.awt.Color(10, 5, 2));
        jSeparator2.setForeground(new java.awt.Color(140, 140, 140));

        jPanel5.setBackground(new java.awt.Color(255, 250, 237));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 2, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Login");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 250, 237));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 2, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("I forgot my password?");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin and Company");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Login");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Username:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 201, 60));
        jPanel4.setForeground(new java.awt.Color(255, 201, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 250, 237));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\OneDrive\\Belgeler\\NetBeansProjects\\rezervatsiyagithub\\src\\main\\java\\com\\mycompany\\rezervatsiyagithub\\testing\\350pxRezervatsiya (1).png")); // NOI18N
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 250, 237));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer Panel");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.orange, java.awt.Color.yellow, java.awt.Color.orange, java.awt.Color.orange));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String enteredUsername = jTextField1.getText();
    }                                           

    
    
    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        char[] enteredPassword = jPasswordField1.getPassword();
        String passwordString = new String(enteredPassword);
    }                                               

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(WIDTH);
    }                                    

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {                                         
    }                                        

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {                                     
        String enteredUsername = jTextField1.getText();
        String enteredPassword = new String(jPasswordField1.getPassword());
        String ADMIN_USERNAME = adminObject.getAdminUsername();
        String ADMIN_PASSWORD = adminObject.getAdminPassword();
        System.out.println("admin pass : " + adminObject.getAdminPassword());
        System.out.println("admin name : " + adminObject.getAdminUsername());
        System.out.println("Size of list : " + testinghanif.adminObject.showFirms());

        int[] c = {0}; 

        if (enteredUsername.equals(ADMIN_USERNAME) && enteredPassword.equals(ADMIN_PASSWORD)) {
            c[0]++;
            admin adminFrame = new admin();
            adminFrame.setVisible(true);
            this.dispose(); 
        }

        firms.forEach((key, value) -> {
            System.out.println("value : " + value.password);
            System.out.println("key : " + key);
            System.out.println("enteredUsername : " + enteredUsername);
            System.out.println("enteredPass : " + enteredPassword);

            if (enteredUsername.equals(value.userName) && enteredPassword.equals(value.password)) {
                c[0]++;
                System.out.println("yeni firmaaaaaaa " + key);
                firma firmaFrame = new firma(value);
                firmaFrame.setVisible(true);
                this.dispose(); 
            }
        });

        if (c[0] == 0) {
            JOptionPane.showMessageDialog(this, "Username or User Password is incorrect", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }

    }                                    

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
        musteri1 musteripanel = new musteri1();
        musteripanel.show(true);
        this.dispose();
    }                                   

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
        musteri1 musteripanel = new musteri1();
        musteripanel.show(true);
        this.dispose();
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
             
              
        adminObject = new AdminObject(firms);
        
   

            
        bus1.capacity = 40;
        bus1.addPersonal(new DriverPersonel(5000));
        bus1.addPersonal(new DriverPersonel(5000));
        bus1.addPersonal(new NonDriverPersonel(2000));
        bus1.addPersonal(new NonDriverPersonel(2000));

        
        bus2.capacity = 30;
        bus2.addPersonal(new DriverPersonel(5000));
        bus2.addPersonal(new DriverPersonel(5000));
        bus2.addPersonal(new NonDriverPersonel(2000));
        bus2.addPersonal(new NonDriverPersonel(2000));
        
        bus3.capacity = 30;
        bus3.addPersonal(new DriverPersonel(3000));
        bus3.addPersonal(new DriverPersonel(3000));
        bus3.addPersonal(new NonDriverPersonel(1500));
        bus3.addPersonal(new NonDriverPersonel(1500));
        
        bus4.capacity = 40;
        bus4.addPersonal(new DriverPersonel(3000));
        bus4.addPersonal(new DriverPersonel(3000));
        bus4.addPersonal(new NonDriverPersonel(1500));
        bus4.addPersonal(new NonDriverPersonel(1500));
        
        bus5.capacity = 40;
        bus5.addPersonal(new DriverPersonel(4000));
        bus5.addPersonal(new DriverPersonel(4000));
        bus5.addPersonal(new NonDriverPersonel(2000));
        bus5.addPersonal(new NonDriverPersonel(2000));
           
        
        airplane1.capacity = 60;
        airplane1.addPersonal(new DriverPersonel(10000));
        airplane1.addPersonal(new DriverPersonel(10000));
        airplane1.addPersonal(new NonDriverPersonel(6000));
        airplane1.addPersonal(new NonDriverPersonel(6000));
        
        airplane2.capacity = 60;
        airplane2.addPersonal(new DriverPersonel(10000));
        airplane2.addPersonal(new DriverPersonel(10000));
        airplane2.addPersonal(new NonDriverPersonel(6000));
        airplane2.addPersonal(new NonDriverPersonel(6000));


        
        airplane3.capacity = 60;

        airplane3.addPersonal(new DriverPersonel(7500));
        airplane3.addPersonal(new DriverPersonel(7500));
        airplane3.addPersonal(new NonDriverPersonel(4000));
        airplane3.addPersonal(new NonDriverPersonel(4000));

        
        airplane4.capacity = 60;

        airplane4.addPersonal(new DriverPersonel(7500));
        airplane4.addPersonal(new DriverPersonel(7500));
        airplane4.addPersonal(new NonDriverPersonel(4000));
        airplane4.addPersonal(new NonDriverPersonel(4000));


                
        train1.capacity = 50;
        train1.addPersonal(new DriverPersonel(2000));
        train1.addPersonal(new DriverPersonel(2000));
        train1.addPersonal(new NonDriverPersonel(1000));
        train1.addPersonal(new NonDriverPersonel(1000));

        
        train2.capacity = 50;

        train2.addPersonal(new DriverPersonel(2000));
        train2.addPersonal(new DriverPersonel(2000));
        train2.addPersonal(new NonDriverPersonel(2000));
        train2.addPersonal(new NonDriverPersonel(2000));

        
        train3.capacity = 50;

        train3.addPersonal(new DriverPersonel(2000));
        train3.addPersonal(new DriverPersonel(2000));
        train3.addPersonal(new NonDriverPersonel(1000));
        train3.addPersonal(new NonDriverPersonel(1000));


        
        A.addNewVehicle(bus1);
        A.addNewVehicle(bus2);
        
        B.addNewVehicle(bus3);
        B.addNewVehicle(bus4);
        
        C.addNewVehicle(airplane1);
        C.addNewVehicle(airplane2);
        C.addNewVehicle(bus5);
        
        D.addNewVehicle(train1);
        D.addNewVehicle(train2);
        D.addNewVehicle(train3);
        
        F.addNewVehicle(airplane4);
        F.addNewVehicle(airplane3);

        System.out.println(adminObject.showFirms());
        
        System.out.println(adminObject.showFirms());
        
        firms.put("firmA",A);

        firms.put("firmB",B);

        firms.put("firmC",C);

        firms.put("firmD",D);

        firms.put("firmF",F);
        System.out.println(firms.size());
                
        

                                                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testinghanif().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}