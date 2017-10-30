package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double a;               // initializing variables for all cases
        double b;
        double c;
        double d;
        double k;
        double m;
        double h;

        double low;
        double high;
        double gx;
        int n;
        boolean degrees;       // degrees or rad
        boolean cont = true;   // decides if they want to continue loop
        int ch;

        ABFunctions f;                      // access enumerated types
        AreaBtwn function = new AreaBtwn(); // access AreaBtwn Class
        Scanner s = new Scanner(System.in); // scanner allowing userinput

        System.out.println("Welcome to Calculating the area under a function");

        System.out.println("Would you like to start?\n 1. Yes\n 2. No");

         ch = s.nextInt();
        if (ch == 1) {
            System.out.println("Lets get started!");
        } else {
            System.out.println(" Have a nice day! ");
        }


        while (cont = true) { // will continue loop again if true
            System.out.println("Please select a function");
            System.out.println("1. Linear: f(x) = mx + b \n" +
                    "2. Quadratic: f(x) = a ( x - h )^2 + c \n" +
                    "3. Sinusoidal: Sine: f(x) = a (sin ( k ( x - c)) + d\n" +
                    "4. Sinusoidal: Cosine: f(x) = a ( cos ( k ( x - c )) + d\n" +
                    "5. Quit\n");


            int fx = s.nextInt();
            switch (fx) {                                         // user decides which function to choose
                case 1:                                           // each case accesses the enumerated variable, f, and specifies their function
                    f = ABFunctions.LINEAR;
                    break;
                case 2:
                    f = ABFunctions.QUADRATIC;
                    break;
                case 3:
                    f = ABFunctions.SINE;
                    break;
                case 4:
                    f = ABFunctions.COSINE;
                    break;
                default:
                    f = ABFunctions.INVALID;
            }
            switch (f) {
                case LINEAR: {                                      // refers to the previous choice
                    System.out.println(" Please input the slope");
                    m = s.nextDouble();

                    System.out.println(" Please input your y-intercept");
                    b = s.nextDouble();


                    System.out.println(" What is the value of g(x)?");
                    gx = s.nextDouble();

                    System.out.println(" Set two domains\n " +
                            "lowerbound domain = ");
                    low = s.nextDouble();

                    System.out.println(" higherbound domain = ");
                    high = s.nextDouble();

                    System.out.println(" How accurate would you like to be\n" +
                            "acc =");
                    n = s.nextInt();

                    function.setDomain(low, high);
                    function.setIterations(n);
                    function.set_Gx(gx);
                    //function.setLineData( m, b);


                    System.out.println(" Calculating the area of a linear function...");
                    function.CalcAreaBetween(m, b);

                    break;
                }
                case QUADRATIC:
                    System.out.println(" Please input an a value");
                    a = s.nextDouble();


                    System.out.println(" What is the value of g(x)?");
                    gx = s.nextDouble();

                    System.out.println(" Please set a c value");
                    c = s.nextDouble();

                    System.out.println(" Set two domains\n " +
                            "lowerbound domain = ");
                    low = s.nextDouble();

                    System.out.println(" higherbound domain = ");
                    high = s.nextDouble();


                case SINE:
                    System.out.println(" Please input an a value");
                    a = s.nextDouble();


                    System.out.println(" What is the value of g(x)?");
                    gx = s.nextDouble();

                    System.out.println(" Please set a c value");
                    c = s.nextDouble();

                    System.out.println(" Please set a k value");
                    k = s.nextDouble();

                    System.out.println(" Please set a d value");
                    d = s.nextDouble();

                    System.out.println(" Set two domains\n " +
                            "lowerbound domain = ");
                    low = s.nextDouble();

                    System.out.println(" higherbound domain = ");
                    high = s.nextDouble();

                case COSINE:
                    System.out.println(" Please input an a value");
                    a = s.nextDouble();

                    System.out.println(" Please set a c value");
                    c = s.nextDouble();

                    System.out.println(" Please set a k value");
                    k = s.nextDouble();

                    System.out.println(" Please set a d value");
                    d = s.nextDouble();

                    System.out.println(" What is the value of g(x)?");
                    gx = s.nextDouble();

                    System.out.println(" Set two domains\n " +
                            "lowerbound domain = ");

                    low = s.nextDouble();

                    System.out.println(" higherbound domain = ");
                    high = s.nextDouble();

                case INVALID: {
                    System.out.println(" INVALID ");
                }
            }

        }
    }
}
