import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();
            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);
            displayBmiInfo(bmi);


        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.println("recorded BMIs "+ bmiData);
        /*
        for(int i = 0; i < bmiData.size(); i++) {
            sum = bmiData.get(i);
        }*/



    }

    private static double getUserHeight() {
        System.out.print("Please enter your height: ");
        Scanner readUserHeight = new Scanner(System.in);
        return readUserHeight.nextDouble();
    }

    private static double getUserWeight() {
        System.out.print("Please enter your weight: ");
        Scanner readUserWeight = new Scanner(System.in);
        return readUserWeight.nextDouble();
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.print("Calculated BMI: ");
        System.out.println(bmi.getBmi());
        System.out.println("Underweight < 18.5");
        System.out.println("Normal weight = 18.5–24.9");
        System.out.println("Overweight = 25–29.9");
        System.out.println("Obesity >= 30");

    }

    private static boolean moreInput() {
       /* Scanner myObj = new Scanner(System.in);
        boolean t = Boolean.parseBoolean(myObj.nextLine());*/
        return true;
    }


}
