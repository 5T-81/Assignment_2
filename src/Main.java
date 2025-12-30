//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Car myCar = new Car("Toyota", 2013, 29000, 4);
    Bus myBus = new Bus("BMW", 2002, 34000, 20);
    System.out.println(myBus.toString());
    System.out.println(myCar.toString());

    Vehicle[] vehicles = {
            new Car("Toyota", 2020, 20000, 4),
            new Bus("Mercedes", 2018, 50000, 30)
    };
    for (Vehicle v : vehicles) {
        System.out.println("Insurance Fee: " + v.calculateInsuranceFee());
    }

    Servicable car = new Car("Morsidis", 2020, 80000, 6);
    car.performService();


}
