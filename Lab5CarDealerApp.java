package lab5cardealerapp;

import java.util.Scanner;

/**
 *
 * @author XuHai Huang
 */
public class Lab5CarDealerApp {

    public static void main(String[] args) {
        new Lab5CarDealerApp();

    }

    public Lab5CarDealerApp() {

        Car car01 = new Car("Corolla", 2016, 18500, "Black");
        Car car02 = new Car("Corolla", 2017, 19500, "Blue");
        Car car03 = new Car("Camry", 2016, 22000, "Red");
        Car car04 = new Car("Camry", 2015, 20500, "White");
        Car car05 = new Car("Sienna", 2017, 27000, "Silver");
        //Car car06 = new Car("corolla", 2000, 100, "Green");

        Car[] availableCars = {car01, car02, car03, car04, car05};
        Car pickedCar;
        //printAvailableCars(availableCars);
        menu();
        int option;
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        boolean cont = true;
        while (cont) {
            switch (option) {
                case 1:
                    printAvailableCars(availableCars);
                    menu();
                    option = sc.nextInt();
                    break;
                case 2:
                    System.out.print("Choose a Available Car: 1-5: ");
                    int carOption;
                    carOption = sc.nextInt();
                    System.out.println("\n************************* ");

                    pickedCar = availableCars[carOption - 1];
                    for (int i = 1; i < availableCars.length + 1; i++) {
                        if (carOption == i) {
                            availableCars[i - 1].printInfo();
                        }
                    }
                    System.out.print("\nMake your best offer ");
                    double offer;
                    offer = sc.nextDouble();
                    pickedCar.setPrice(offer);
                    System.out.println("Deal! Sold!");
                    System.out.println("\n************************* ");
                    pickedCar.printInfo();
                    cont = false;
                    break;
                case 3:
                    System.exit(1);
            }

        }
    }

    private void menu() {
        System.out.println("Choose Option:");
        System.out.println("1: List of Available cars");
        System.out.println("2: Choose Car");
        System.out.println("3: Exit");
    }

    private void printAvailableCars(Car[] availableCars) {
        System.out.print("*************************\n");
        for (int i = 0; i < availableCars.length; i++) {
            System.out.println("Option " + (i + 1));
            availableCars[i].printInfo();
            System.out.print("*************************\n");
        }

    }
}
