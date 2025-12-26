public class Car extends Vehicle{
    private int numberOfDoors;

    //constructor
    public Car(String model, int year, double basePrice, int numberOfDoors){
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee(){
        int currentYear = java.time.Year.now().getValue(); //dynamic
        int age = getAge(currentYear);

        //Insurance fee = 5% of base price per year of vehicle age + extra $100 per door
        return basePrice * 0.05 * age + numberOfDoors * 100;
    }
}
