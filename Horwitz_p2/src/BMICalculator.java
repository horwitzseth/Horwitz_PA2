import java.util.Scanner;
/*
    Set up doubles for weight, height, and bmi; strings for metric or imperial measurements and bmi category; and scanner

    Create reading data functions
        readUserData()
            readUnitType() determines metric or imperial system & repeats if not given one of options
            readMeasurementData() depending on metric or imperial system, points code to correct method
                readMetricData() reads in weight in kilograms and height in meters
                readImperialData() reads in weight in pounds and height in inches
                    setWeight() assigns weight value to private double weight and exits program if less than zero
                    setHeight() assigns height value to private double height and exits program if less than zero
        calculateBmi() calculates bmi based on imperial or metric system
            getWeight() returns weight
            getHeight() returns height
            calculateBmiCategory() depending on bmi value, assigns bmiCategory the correct string
        displayBmi() displays bmi value and bmi category
            getBmi() returns bmi value
            getBmiCategory() returns bmi category
*/

public class BMICalculator {

    private double weight = 0;
    private double height = 0;
    private String readMOrI;

    public static Scanner scan = new Scanner(System.in);
    public static double bmi = 0;
    public static String bmiCategory;

    private void readMetricData () {
        System.out.print("Please enter your weight in kilograms: ");
        setWeight(scan.nextInt());

        System.out.print("Please enter your height in meters: ");
        setHeight(scan.nextInt());
    }

    private void readImperialData () {
        System.out.print("Please enter your weight in pounds: ");
        setWeight(scan.nextInt());

        System.out.print("Please enter your height in inches: ");
        setHeight(scan.nextInt());
    }

    private void readUnitType () {
        System.out.print("Please input M for Metric or I for Imperial units (case-sensitive): ");
        readMOrI = scan.nextLine();
        if (!readMOrI.equals("M") && !readMOrI.equals("I")) {
            readUnitType();
        }
    }

    private void readMeasurementData () {
        if (readMOrI.equals("M")) {
            readMetricData();
        }
        else if  (readMOrI.equals("I")) {
            readImperialData();
        }
    }

    public void readUserData () {
        readUnitType();
        readMeasurementData();
    }

    public double getWeight () {
        return weight;
    }

    private void setWeight (int weight) {
        this.weight = weight;

        if (this.weight < 0) {
            System.out.println("Invalid weight");
            System.exit(0);
        }
    }

    public double getHeight () {
        return height;
    }

    private void setHeight (int height) {
        this.height = height;

        if (this.height < 0) {
            System.out.println("Invalid height");
            System.exit(0);
        }
    }

    private void calculateBmiCategory () {
        if (bmi < 18.5) {
            bmiCategory = "Underweight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            bmiCategory = "Normal weight";
        }
        else if (bmi >= 25 && bmi <= 29.9) {
            bmiCategory = "Overweight";
        }
        else if (bmi >= 30) {
            bmiCategory = "Obesity";
        }
    }

    public void calculateBmi () {
        double weight = getWeight();
        double height = getHeight();

        if (readMOrI.equals("M")) {
            bmi =  Math.round((weight / (height * height)) * 10) / 10;
        }
        else if (readMOrI.equals("I")) {
            bmi = Math.round(((703 * weight) / (height * height)) * 10) /10;
        }

        calculateBmiCategory();
    }

    public double getBmi () {
        return bmi;
    }

    public String getBmiCategory () {
        return bmiCategory;
    }

    public void displayBmi () {
        System.out.println("Underweight: < 18.5");
        System.out.println("Normal weight: 18.5 - 24.9");
        System.out.println("Overweight: 25 - 29.9");
        System.out.println("Obesity: 30 or greater");
        System.out.println("Your bmi is " + getBmi());
        System.out.println("Your bmi category is " + getBmiCategory());
    }
}
