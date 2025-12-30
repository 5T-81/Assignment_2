public abstract class Vehicle implements Servicable {
    protected  int id;
    protected static int idGen = 1;
    protected String model;
    protected int year;
    protected double basePrice;

    //constructor
    Vehicle(String model, int year, double basePrice) {
        this.id = idGen++; //automatic
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    //setters
    protected void setModel(String model) {
        if(model == null || model.isEmpty())
        {
            throw new IllegalArgumentException("Please enter the model");
        }
        this.model = model;
    }
    protected void setYear(int year) {
        if(year < 1886 || year > 2025 ) {
            throw new IllegalArgumentException("Enter a valid year.");
        }
        this.year = year;
    }
    protected void setBasePrice(double basePrice) {
        if(basePrice <= 0) {
            throw new IllegalArgumentException("Enter a valid base price.");
        }
        this.basePrice = basePrice;
    }

    //getters
    protected  String getModel() {
        return model;
    }
    protected int getYear() {
        return year;
    }
    protected double getBasePrice() {
        return basePrice;
    }

    //other method
    public int getAge(int currentYear){
        int year = getYear();
        int age = currentYear - year;
        return age;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return("ID: " + this.id + "\nModel: " + this.model + "\nYear: " + this.year + "\nBase Price: " + this.basePrice);
    }
}

