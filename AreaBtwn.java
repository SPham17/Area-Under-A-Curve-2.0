package com.company;

/**
 * Created by 07517pha on 11/10/2017.
 */
public class AreaBtwn {
    private double area1;        //area
    private double area2;
    private double area;

    private double length;      // height
    private double width;       // length

    private int N;              // number of rectangles
    private double rectangle1;   // area of rectangle
    private double rectangle2;
    private double rectangle;

    private double Low;         // lowerbound domain
    private double High;        // higherbound domain

    private double gx;          // gx

    private boolean Degrees;    // degrees or radiant
    //functions variables
    private double M;           // slope
    private double B;           // y-intercept
    private double A;           // stretch or compression
    private double C;           // sine / cos horizontal translation
    private double H;           // horizontal translation quadratics
    private double D;           //
    private double K;           // sine/ cos horizontal compression or stretch
    private double side1;
    private double side2;

    ABFunctions F;  //for sine and cosine

    public void resetData() {                                        // that will reset all of the private data in the AreaBtwn object to 0, zero

        area = 0;
        length = 0;
        width = 0;
        N = 0;
        Low = 0;
        High = 0;
        gx = 0;
        rectangle1 = 0;
        M = 0;
        B = 0;
        A = 0;
        C = 0;
        H = 0;
        D = 0;
        K = 0;

    }

    public void set_Gx(double b) {

        this.gx = b;

    }

    public void setDomain(double low, double high) {                // sets the domain, uses private variables referring to the variables from the main

        this.Low = low;
        this.High = high;

    }

    public void setIterations(int n) {                              // sets number of slices, uses private variables referring to the main

        this.N = n;

    }

    private void displayArea() {

        System.out.println("Area is = " + Math.abs(area) + " units squared "); // prints out the area when called, area is always positive
    }

    private void setLineData(double m, double b) {              // grabs parameters from main. sets datatype from AreaBtwn to refer to the main

        M = m;
        B = b;

    }

    private double CalcAreaLinear() {

        area = 0;          // sets area to 0, previous area will not interrupt this method

        this.side1 = (this.gx - this.B) / this.M;
        System.out.println(side1);

        this.width = (this.High - this.Low) / this.N;       // gets the width of the small rectangles, divides by number of slices to create even slices
        this.length = M * this.Low + this.B - this.gx;      // gets height (length) of the initial small rectangle

        for (double x = 0; x < this.N; x++) {               // keeps adding one rectangle until it reaches the number of slices

            if (x < side1)
            rectangle = Math.abs(this.width * this.length); // calculates area of the rectangle, absolute value for positive area

            this.Low += this.width;                         // moves rectangle over to the right one point
            this.length = this.M * this.Low + this.B - this.gx; // finds new height for new rectangle

            this.area1 -= rectangle;                         // adds rectangle to the total area


            if (x > side1)
                rectangle2 = Math.abs(this.width * this.length); // calculates area of the rectangle, absolute value for positive area

            this.Low += this.width;                         // moves rectangle over to the right one point
            this.length = this.M * this.Low + this.B - this.gx; // finds new height for new rectangle

            this.area2 += rectangle;                         // adds rectangle to the total area

            this.area = area2 - area;
        }                                                   // repeat until reaches number of slices
        return Math.abs(this.area);                                   // returns area
    }

    public double CalcAreaBetween(double m, double b) {           // calls the setLineData, and calcAreaLinear

        setLineData(m, b);                                        // sends these parameters to setLineData
        CalcAreaLinear();                                         // calculates area using parameters that were set
        displayArea();                                            //  displays area with units
        return this.area;                                         // returns to main class
    }

    private void setQuadraticData(double a, double h, double c) {  // sets private variables referring to variables from the main

        A = a;
        H = h;
        C = c;

    }

    private double CalcAreaQuadratic() {                                                    // calculates area for quadratics

        area = 0;                                                                           // will set area to zero, previous area will not be used when going through the loop again

        this.width = (this.High - this.Low) / this.N;                                       // gets the width of the small rectangles, divides by number of slices to create even slices
                this.length = this.A * (this.Low - this.H)*(this.Low - this.H) + this.C - this.gx;  // gets initial height of the rectangle

                for (double x = 0; x < this.N; x++) {                                               // continues adding rectangles until reaches number of slices

        rectangle = Math.abs(this.width * this.length);                                 // calculates area of the rectangle, absolute value for positive area

        this.Low += this.width;                                                         // moves rectangle over to the right one point
        this.length = this.A * (this.Low - this.H)*(this.Low - this.H) + this.C - this.gx; // finds new height for the new rectangle

        this.area += rectangle;                                                         // adds rectangles to the total area
        }                                                                                       // repeats until reaches amount of slices
        return this.area;                                                                       // returns area
        }

public double CalcAreaBetween(double a, double h, double c) {           // calls the setQuadraticData, and CalcAreaQuadratic

        setQuadraticData(a, h, c);                                      // sends these parameters to setQuadraticData
        CalcAreaQuadratic();                                            // calculates area using parameters that were set
        displayArea();                                                  //  displays area with units
        return this.area;                                               // returns to main class

        }


private void setSinusoidalData(ABFunctions f, double a, double k, double c, double d, boolean degrees) {    //sets private variables referring to the variables from the main

        A = a;
        K = k;
        C = c;
        D = d;
        Degrees = degrees;
        F = f;

        if (Degrees == false) {                         // if user inputs Degrees as false, the turn the domains into radians. if true, leave it as degrees
        Low = Math.toRadians(Low);                  // sets lowerbound domain to radians if not using degrees
        High = Math.toRadians(High);                // sets higherbound domain to radians if not using degrees
        setDomain(Low, High);                       // new set of domain, using radians
        } else {
        setDomain(Low, High);                       // if Degrees is true, keep the set of domains in degrees
        }
        }

private double CalcAreaSine(){

        area = 0;                                                                           // sets area to 0, previous area will not be used

        this.width = (this.High - this.Low) / this.N;                                       // gets the width of the small rectangles, divides by number of slices to create even slices
        this.length = this.A*(Math.cos(this.K* (this.Low - this.D))) + this.C - this.gx;    // gets initial height of the rectangle

        for (double x = 0; x < this.N; x++) {                                               // keeps adding one rectangle until it reaches the number of slices

        rectangle = Math.abs(this.width * this.length);                                 // calculates area of the rectangle, absolute value for positive area

        this.Low += this.width;                                                         // moves rectangle right one unit
        this.length = this.A*(Math.sin(this.K* (this.Low - this.D))) + this.C - this.gx;// finds new height for the new rectangle
        this.area += rectangle;
        }
        return this.area;
        }

private double CalcAreaCosine(){                                                     // same thing as sine, but using cosine

        area = 0;                                                                        // sets area to 0, previous area will not be used

        this.width = (this.High - this.Low) / this.N;                                    // gets the width of the small rectangles, divides by number of slices to create even slices

        for (double x = 0; x < this.N; x++) {                                           // keeps adding one rectangle until it reaches the number of slices

        rectangle = Math.abs(this.width * this.length);                                 // calculates area of the rectangle, absolute value for positive area

        this.Low += this.width;                                                         // moves rectangle right one unit
        this.length = this.A*(Math.cos(this.K* (this.Low - this.D))) + this.C - this.gx;// finds new height for the new rectangle
        this.area += rectangle;                                                         // adds rectangles to total area
        }                                                                                   // repeats until reaches amount of slices
        return this.area;                                                                   // returns area
        }

public double CalcAreaBetween(ABFunctions f, double a, double k, double c, double d, boolean degrees) { // calls setSinusoidalData, and CalcAreaSine

        setSinusoidalData(f,a, k, c, d, degrees);  // sends these parameters to setSinusoidalData

        if (F == ABFunctions.SINE) {               // if user inputs SINE, calculate area using sine
        CalcAreaSine();

        }else if (F == ABFunctions.COSINE){        // if user inputs COSINE, calculate area using cosine
        CalcAreaCosine();
        }

        displayArea();                             //  displays area with units
        return this.area;                          // returns to main class

        }

        }












































