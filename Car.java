package lab5cardealerapp;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author XuHai Huang
 */
public class Car {

    //fields
    private String model;
    private int[] yearRange;
    private int year;
    private double[] priceRange;
    private double price;
    private String[] allowedColor;
    private String color;
    private String defaultColor;
    private String[] standardAccessories;
    private String[] optionalAccessories;
    private String[] accessories;
    Scanner sc = new Scanner(System.in);

    //constructors
    public Car(String model, int year, double price, String color) {
        boolean exit = false;
        if (!model.equalsIgnoreCase("Corolla")
                && !model.equalsIgnoreCase("camry")
                && !model.equalsIgnoreCase("sienna")) {
            System.out.println("This dealer doesn't work with this car model: " + model);
            System.exit(1);
        }
        this.model = model;
        modelSpecs(model);
        setYear(year);

        if (price < priceRange[0] || price > priceRange[1]) {
            System.out.println("We cannot sell a " + model
                    + " for the requested price of " + price);
            exit = true;
        }
        setColor(color);
        accessories = standardAccessories;
        if (exit) {
            System.exit(1);
        }
        setPrice(price);

    }

    //methods
    public void setColor(String color) {
        modelSpecs(model);
        if (!color.equalsIgnoreCase(allowedColor[0]) && !color.equalsIgnoreCase(allowedColor[1])) {
            System.out.println("The color " + color
                    + " that you have requested is not "
                    + "available for car model: " + model);
            System.out.println("Available colors " + allowedColor[0] + " and " + allowedColor[1]);
        }
        this.color = color;
    }

    public void setYear(int year) {
        modelSpecs(model);
        if (year < yearRange[0] || year > yearRange[1]) {
            System.out.println("Unfortunately we do not work with " + model + " in the given year: " + year);
            System.out.println("We work with cars from " + yearRange[0] + " to " + yearRange[1]);
        }
        this.year = year;
    }

    public void setPrice(double price) {
        modelSpecs(model);
        while (price < priceRange[0] || price > priceRange[1]) {
            System.out.println("Make a better offer");
            System.out.println("Price range: " + priceRange[0] + " - " + priceRange[1]);
            price = sc.nextDouble();
        }
        this.price = price;
    }

    public void setAccessories() {
        modelSpecs(model);
        accessories = standardAccessories;
    }

    public void modelSpecs(String model) {
        if (model.equalsIgnoreCase("Corolla")) {
            yearRange = new int[]{2016, 2018};
            priceRange = new double[]{18000, 20000};
            allowedColor = new String[]{"Black", "Blue"};
            standardAccessories = new String[]{"none"};

        } else if (model.equalsIgnoreCase("Camry")) {
            yearRange = new int[]{2015, 2017};
            priceRange = new double[]{20000, 22000};
            allowedColor = new String[]{"Red", "White"};
            standardAccessories = new String[]{"Power Lock", "Power Window"};

        } else if (model.equalsIgnoreCase("Sienna")) {
            yearRange = new int[]{2015, 2018};
            priceRange = new double[]{25000, 30000};
            allowedColor = new String[]{"Silver", "Black"};
            standardAccessories = new String[]{"Media Player", "Heated-seat"};

        }

    }

    public String getColor() {
        return color;

    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public void printInfo() {
        System.out.println("Car Model: " + model);
        System.out.println("Built Year: " + year);
        System.out.println("tag price: " + price);
        System.out.println("Color: " + color);
        System.out.println("Accessories: " + Arrays.toString(accessories));
    }

}
