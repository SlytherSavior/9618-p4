//here is a simple syntax to declare a class in java

// public, private, protected are access modifiers in java

//public class access modifier ensures that the class is accessible by other classes

// public class Car {}

class Car {
    private String name; // private access modifier ensures that this 'name' property of any object of
                         // car class is accessible only inside the class
    public String brandName; // we will see what happens when a property is declared as public
    private String color;
    private int price;

    public Car(String inputName, String inputBrandName, String inputColor, int inputPrice) {
        this.brandName = inputBrandName;
        this.name = inputName;
        this.color = inputColor;
        this.price = inputPrice;
    } // here we have declared a constructor method, constructor methods in java are methods declared with class name inside the class


}