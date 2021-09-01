import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double percent, int period ) {
        double pay = amount * Math.pow((1 + percent / 12), 12 * period);

        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double ScaLe= Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe;
    }

    void executeAction( ) {
        int period;
        int action;

        Scanner inputSum = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");

        int amount = inputSum.nextInt();

        System.out.println("Введите срок вклада в годах:");

        period = inputSum.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = inputSum.nextInt();

        double finalSum = 0;

        if (action == 1)
            finalSum = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2)
        {
            finalSum = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().executeAction();
    }
}
