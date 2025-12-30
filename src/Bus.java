public class Bus extends Vehicle {
    private int passengerCapacity;

    Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model,year,basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee(){
        int currentYear = java.time.Year.now().getValue();
        int age = getAge(currentYear);

        // Insurance fee = 3% of base price per year of vehicle age + $50 per passenger
        return basePrice * 0.03 * age + passengerCapacity * 50;
    }

    @Override
    public void performService(){
        System.out.println("Bus service for: " + getModel());
        System.out.println("- Checking brakes");
        System.out.println("- Refilling gas");
        System.out.println("- Inspecting passenger seats");
    }

    @Override
    public int getServiceIntervalKm() {
        return 5000; //Bus needs service after 5,000km
    }
}
