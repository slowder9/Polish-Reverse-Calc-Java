package com.company;
import java.util.Arrays;

public class ReversePolishCalc {
    //Variable to keep track of the top of the stack
    int stackTop; //stackTop = 0

    //Array of the input string split up
    private String[] tokens;

    //The stack
    private String[] stack;

    public double calculate(String input) { //input: "2.5, 4.8, +
        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(","); //input: "2.5, 4.8, +

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[ tokens.length ];

        // 3. Write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            String currentToken = tokens[i]; //tokens: "2.5, 4.8, +" i=0

            //Convert the current token to a number
            Double num = null;

            try {
                num = Double.parseDouble(currentToken); //num: null CurrentToken: 2.5...try works so now num: 2.5 not null
            } catch (NumberFormatException ex) {
                // eat it.
            }

            // when we're here, either num has a value
            // or it is null. if it's null, that means
            // we just encountered an operator
            if (num != null) { //num: 2.5
                push(num); //num 2.5
            } else {
                if (currentToken.equals("+")) {
                    System.out.println(stackTop);
                    double value1 = pop();
                    double value2 = pop();

                    push(value2 + value1);
                } else {
                    if (currentToken.equals("-")) {
                        double value1 = pop();
                        double value2 = pop();

                        push(value2 - value1);
                    } else {
                        if (currentToken.equals("/")) {
                            double value1 = pop();
                            double value2 = pop();

                            push(value2 / value1);
                        } else {
                            if (currentToken.equals("*")) {
                                double value1 = pop();
                                double value2 = pop();

                                push(value2 * value1);
                            }
                        }
                    }
                }
            }
        }
        // 4. Return the result
        return pop();
    }

    private void push(String number) { //number: "2.5"
        // push on the stack
        // TODO: write this code that pushes onto the stack
        stack[stackTop]=number; //stackTop: 0 number: "2.5"
        stackTop++; //stackTop: 1
    }

    private void push(double d) { //d: 2.5
        // change the double to a string and then push it on the stack
        push(Double.toString(d)); //d: 2.5
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        // step 1: move the top of the stack back by 1
        stackTop--;

        // step 2: retrieve the value of the stack at the current element;
        String value = stack[stackTop];

        // step 3: reset the value in the stack to null
        stack[stackTop] = null;

        // step 4: return the double version of this string
        return Double.parseDouble(value);
    }


}
