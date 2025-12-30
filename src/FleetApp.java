import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    //default constructor
    public FleetApp() {}

    //methods
    public void run() {
        boolean running = true;
        do {
            System.out.println("""
                    Fleet Management System\s
                    1. Print all vehicles\s
                    2. Add new car\s
                    3. Add new bus\s
                    4. Show total yearly insurance fees\s
                    5. Show vehicles older than N years\s
                    6. Perform service for all vehicles\s
                    7. Quit\s
                    """);
            System.out.print("Enter the number of your choice:  ");
            int choice = scan.nextInt();
            scan.nextLine(); //clean leftover
            //check validation
            if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice.");
                quit();
            }
            //apply the choice from the menu
            switch (choice) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    addNewBus();
                    break;
                case 4:
                    totalYearlyInsuranceFees();
                    break;
                case 5:
                    vehiclesOlderThanNYears();
                    break;
                case 6:
                    performServiceForAllVehicles();
                    break;
                case 7:
                    quit();
                    break;
            }
            //asking if user want to return to menu
            System.out.print("Do you want to return to menu Y/N: ");
            String YorN = scan.nextLine().toLowerCase();

            if(YorN.equals("n"))
            {
                running = false;
                quit();
            }
            //keep looping until is false
        }while (running);
    }
    //menu methods
    private void printAllVehicles(){
        if( vehicles == null||vehicles.isEmpty())
        {
            System.out.println("There are no vehicles in the fleet");
            return;
        }
        for(Vehicle v : vehicles)
        {
            System.out.println(v.toString());
        }
    }

    private void addNewCar(){
        System.out.print("Enter car's model: ");
        String model = scan.nextLine();
        System.out.print("Enter car's year: ");
        int year = scan.nextInt();
        System.out.print("Enter car's base price: ");
        double basePrice = scan.nextDouble();
        System.out.print("Enter car's number of doors: ");
        int doors = scan.nextInt();
        scan.nextLine(); //cleaning before reading answer later...
        //assign the inputted info into the object
        Vehicle newCar = new Car(model,year,basePrice,doors);
        vehicles.add(newCar);//add the new car
    }

    private void addNewBus(){
        System.out.print("Enter bus's model: ");
        String model = scan.nextLine();
        System.out.print("Enter bus's year: ");
        int year = scan.nextInt();
        System.out.print("Enter bus's base price: ");
        double basePrice = scan.nextDouble();
        System.out.print("Enter the capacity of the bus: ");
        int capacity = scan.nextInt();
        scan.nextLine(); //cleaning before reading answer later...
        //assign the inputted info into the object
        Vehicle newBus = new Bus (model,year,basePrice, capacity);
        vehicles.add(newBus);//add the new bus
    }

    private void totalYearlyInsuranceFees(){
        double totalInsuranceFees = 0;
        for(Vehicle v : vehicles){
            totalInsuranceFees += v.calculateInsuranceFee();
        }
        System.out.println("Total Yearly Insurance Fees: $" + totalInsuranceFees);
    }

    private void vehiclesOlderThanNYears(){
        System.out.println("Enter Current Year: ");
        int currentYear = scan.nextInt();
        System.out.println("Enter N Years: ");
        int nYears = scan.nextInt();
        scan.nextLine(); //cleaning before reading answer later...
        boolean found = false;
        for(Vehicle v : vehicles){
            System.out.println("Vehicles older than " + nYears + " years : ");
            if(v.getAge(currentYear) > nYears){ //vehicles older than N years
                found = true;
                System.out.println(v);
            }
        }
        if(!found){
            System.out.println("None exists");
        }
    }

    private void performServiceForAllVehicles(){
        for(Vehicle v : vehicles){
            if(v instanceof Servicable){ //we don't need to check really here if is it a servicable, just for clear code
                v.performService();
            }
        }
    }

    private void quit(){
        System.exit(0);
    }

}
