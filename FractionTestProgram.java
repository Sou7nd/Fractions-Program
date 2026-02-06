/***************************************************************************************************************************************
 * Assignment 2 for CSCI-271-001 Spring 2026
 * 
 * Author:      John Sazhneu
 * OS:          MacOS
 * Compiler:    javac
 * Date:        February 5, 2026
 * 
 * Purpose: 
 * 
 * ************************************************************************************************************************************/

/***************************************************************************************************************************************
 * I declare and confirm the following:
 * - I have not discussed this program code with anyone other than my
 *   instructor or the teaching assistants assigned to this course.
 * - I have not used programming code obtained from someone else,
 *   or any unauthorised sources, including the Internet, either
 *   modified or unmodified.
 * - If any source code or documentation used in my program was
 *   obtained from other sources, like a text book or course notes,
 *   I have clearly indicated that with a proper citation in the
 *   comments of my program.
 * - I have not designed this program in such a way as to defeat or
 *   interfere with the normal operation of the supplied grading code.
 * 
 * <John Sazhneu>
 * ************************************************************************************************************************************/


public class FractionTestProgram {

    public static void main(String[] args) { //Main

        //Test for reduced fractions
        System.out.println("This tests 2 fractions for reducing fractions.");

        //Fraction 1
        Fraction reduce1 = new Fraction(8, 16);
        System.out.println("The input was (8, 16), so it should return 1/2");
        System.out.println("Returned fraction: " + reduce1);

        //Fraction 2
        Fraction reduce2 = new Fraction(-12, 36);
        System.out.println("The input was (-12, 36), so it should return -1/3");
        System.out.println("Returned fraction: " + reduce2);



        //Test for negative denominator
        System.out.println("");
        System.out.println("This tests 2 fractions for negative denominator.");

        //Fraction 1
        Fraction negDen1 = new Fraction(8, -16);
        System.out.println("The input was (8, -16), so it should return -1/2");
        System.out.println("Returned fraction: " + negDen1);

        //Fraction 2
        Fraction negDen2 = new Fraction(12, -36);
        System.out.println("The input was (12, -36), so it should return -1/3");
        System.out.println("Returned fraction: " + negDen2);



        //Test for 0 in the numerator
        System.out.println("");
        System.out.println("This tests a fraction for a zero in the numerator.");


        //Fraction 1
        Fraction zeroNum = new Fraction(0, -16);
        System.out.println("The input was (0, -16), so it should return 0");
        System.out.println("Returned fraction: " + zeroNum);



        //Test for whole numbers
        System.out.println("");
        System.out.println("This tests 2 fractions for a whole number");

        //Fraction 1
        Fraction whole1 = new Fraction(33, 1);
        System.out.println("The input was (33, 1), so it should return 33");
        System.out.println("Returned fraction: " + whole1);

        //Fraction 2
        Fraction whole2 = new Fraction(-5);
        System.out.println("The input was (-5), so it should return -5");
        System.out.println("Returned fraction: " + whole2);


        
        //Test for positive infinity
        System.out.println("");
        System.out.println("This tests a fraction for a positive infinity.");

        //Fraction
        Fraction posInf = new Fraction(10, 0);
        System.out.println("The input was (10, 0), so it should return Infinity");
        System.out.println("Returned fraction: " + posInf);



        //Test for negative infinity
        System.out.println("");
        System.out.println("This tests a fraction for a negative infinity.");

        //Fraction
        Fraction negInf = new Fraction(-17, 0);
        System.out.println("The input was (-17, 0), so it should return Infinity");
        System.out.println("Returned fraction: " + negInf);



        //Test for NaN
        System.out.println("");
        System.out.println("This tests a fraction for NaN.");

        //Fraction
        Fraction fractionNaN = new Fraction(0, 0);
        System.out.println("The input was (0, 0), so it should return NaN");
        System.out.println("Returned fraction: " + fractionNaN);



        //Test for multiplication and division
        System.out.println("");
        System.out.println("This tests for multiplication and division");

        //Fractions
        Fraction first = new Fraction(4, 5);
        Fraction second = new Fraction(8);
        Fraction third = new Fraction(1, 2);

        Fraction calculate = first.multiply(second.divide(third));
        System.out.println("The input was 4/5*(8/(1/2)), and it should return 64/5");
        System.out.println("Returned fraction: " + calculate);



    }




}