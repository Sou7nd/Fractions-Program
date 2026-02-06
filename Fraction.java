/***************************************************************************************************************************************
 * Assignment 2 for CSCI-271-001 Spring 2026
 * 
 * Author:      John Sazhneu
 * OS:          MacOS
 * Compiler:    javac
 * Date:        February 2, 2026
 * 
 * Purpose: The purpose of this is to create a class for a user to be able to utilize fractions. This adds
 * the ability to add, subtract, multiply, divide, raise to the power, and negate fractions.
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



public class Fraction //Class
{
    private long numerator;
    private long denominator;
    
    public Fraction(long num, long denom)
    {

        //Test to see if the denominator is 0 and then test to see if it is positive or negative infinity or NaN.
        if(denom == 0) //If the denominator is 0
        {
            if (num > 0) //Check for positive infinity
            {
                numerator = 1; //1 for easier math
                denominator = 0;
            }
            else if (num < 0) //Check for negative infinity
            {
                numerator = -1; //-1 for easier math
                denominator = 0;
            }
            else //Check for NaN (Both numerator and denominator are 0)
            {
                numerator = 0;
                denominator = 0;
            }
            return; //Exit method
        }

        //Test to see if numerator is 0 and if it is set numerator to 0 and denominator to 1
        if(num == 0) //If numerator is 0
        {
            numerator = 0; //Set numerator variable to 0
            denominator = 1; //Set denominator variable to 1

            return; //Exit the method
        }
        
        //Test to see if denominator is negative and if so move the negative sign to the numerator
        if (denom < 0) //If denominator is negative
        {
            num = -num; //flip numerator
            denom = -denom; //flip denominator
        }

        //GCD 
        long common = gcd(num, denom); //Calculate GCD using the gcd function

        numerator = num / common; //Numerator over the common factor
        denominator = denom / common; //Denominator over the common factor.

    }

    //GCD Function
    private long gcd(long a, long b)
        {
            if (a < 0)
            {
                a = -a;
            }
            
            while (b != 0)
            {
                long remainder = a % b;
                a = b;
                b = remainder;

            }

            if (a == 0)
            {
                a = 1;
            }

            return a;
            
    }

    public Fraction(long num)
    {
        this(num, 1);//Calls the 2 parameter constructor with num as numerator and 1 as denominator.
    }   

    public long getNumerator() //Method to get numerator returned since numerator is private by default
    {
        return numerator;
    }

    public long getDenominator() //Method to get denominator returned since denominator is private by default
    {
        return denominator;
    }

    public Fraction add(Fraction inFraction) //Addition method
    {
        //Get the new numerator by multiplying the numerators of each fraction by the denominator of the opposite
        //one and then combining the numerators.
        long newNumerator = this.numerator * inFraction.getDenominator() + this.denominator * inFraction.getNumerator();

        //Get the new denominator by multiplying denominators together
        long newDenominator = this.denominator * inFraction.getDenominator();

        //return the new fraction
        return new Fraction(newNumerator, newDenominator);

    }


    public Fraction subtract(Fraction inFraction) //Subtraction method
    {
        //Get the new numerator by multiplying the numerators of each fraction by the denominator of the opposite
        //one and then subtracting the numerators.
        long newNumerator = this.numerator * inFraction.getDenominator() - this.denominator * inFraction.getNumerator();

        //Get the new denominator by multiplying the denominators together
        long newDenominator = this.denominator * inFraction.getDenominator();

        //Return the new fraction
        return new Fraction(newNumerator, newDenominator);
    }


    public Fraction multiply(Fraction inFraction) //Multiplication Method
    {
        //Get the new numerator by multiplying the numerators together
        long newNumerator = this.numerator * inFraction.getNumerator();

        //Get the new denominator by multiplying the denominators together
        long newDenominator = this.denominator * inFraction.getDenominator();

        //Return the new fraction
        return new Fraction(newNumerator, newDenominator);

    }


    public Fraction divide(Fraction inFraction) //Division method
    {
        //Get the new numerator by mutliplying the first fraction by the reverse of the second (num*denom / denom * num)
        long newNumerator = this.numerator * inFraction.getDenominator();

        //Get the new denominator by multiplying the denominator of the first fraction by the numerator of the second fraction
        long newDenominator = this.denominator * inFraction.getNumerator();

        //Return the new fraction
        return new Fraction(newNumerator, newDenominator);

    }


    public Fraction pow(int n) //Raise to the power method
    {
        if (n == 0) //To the 0th power
        {
            return new Fraction(1, 1); //Fraction becomes 1/1
        }
        else if (n < 0) //Power is negative
        {
            return new Fraction(1, 1).divide(this.pow(-n)); //Divide 1/1 by the old fraction to the power of now positive n

        }
        else //If n is > 0
        {
            Fraction newFraction = new Fraction(1, 1);
            for (int i = 0; i < n; i++) {
                newFraction = newFraction.multiply(this);
            }

            return newFraction;
        }

    }


    public Fraction negate() //Negation method
    {
        //Multiply the numerator by a negative to negate the fraction
        return new Fraction(-this.numerator, this.denominator);

    }

    @Override
    public String toString() //toString method
    {
        if (denominator == 0)
        {
            if (numerator > 0)
            {
                return "Infinity"; //Positive infinity if numerator is positive and denominator is 0
            }
            else if (numerator < 0)
            {
                return "-Infinity"; //Negative infinity if numerator is negative and denominator is 0
            }
            else if (numerator == 0)
            {
                return "NaN"; //NaN if numerator and denominator are both 0
            }
        }

        if (denominator == 1) 
        {
            return Long.toString(numerator); //If the denominator is 1 return just the numerator
        }


        return numerator + "/" + denominator; //Regular fraction that passed all the previous checks
    }






}