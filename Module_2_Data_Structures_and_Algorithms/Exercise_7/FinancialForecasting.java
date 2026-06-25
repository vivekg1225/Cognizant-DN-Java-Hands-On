// Developing a financial forecasting tool that predicts future values based on past data.

package Module_2_Data_Structures_and_Algorithms.Exercise_7;

import java.util.Scanner;

public class FinancialForecasting {

    static int calls = 0;
    
    public static double forecast(double currentValue, double rate, int years){
        calls++;

        if (years == 0){
            return currentValue;
        }

        return forecast(currentValue * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Present Value: ");
        double currentValue = sc.nextDouble();

        System.out.print("\nEnter the Rate Per Year (in %): ");
        double rate = sc.nextDouble();

        System.out.print("\nEnter the No. of Years: ");
        int years = sc.nextInt();

        double futureValue = forecast(currentValue, rate/100, years);

        System.out.println("\nFuture Value: "+ futureValue);
        System.out.print("\nTotal no. of Recursive Calls: "+ calls);

        sc.close();
    }
}
