package com.katas.fizzbuzz;

public class FizzBuzz {

    public void printFizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public String fizzBuzz(int n) {
        StringBuilder result = new StringBuilder();

        boolean divisibleByThree = n % 3 == 0;
        boolean divisibleByFive = n % 5 == 0;

        String stringNumber = String.valueOf(n);
        boolean numberHasThree = stringNumber.contains("3");
        boolean numberHasFive = stringNumber.contains("5");

        if (numberHasThree)
            result.append("Fizz");
        if (divisibleByThree)
            result.append("Fizz");
        if (numberHasFive)
            result.append("Buzz");
        if (divisibleByFive)
            result.append("Buzz");
        if (result.isEmpty())
            result.append(stringNumber);

        return result.toString();
    }
}
