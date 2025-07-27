package forecasting;

import java.util.Arrays;

public class ForecastApp {

    public static void main(String[] args) {
        double[] past = { 120000, 132000, 145200, 159720 };
        int yearsToProject = 3;

        double[] forecast = new double[yearsToProject];
        forecastRecurse(past, yearsToProject, forecast);

        System.out.println("Past values  : " + Arrays.toString(past));
        System.out.println("Forecast next " + yearsToProject + " years : " + Arrays.toString(forecast));
    }

    public static void forecastRecurse(double[] history, int k, double[] result) {
        if (k == 0)
            return;
        double avgGrowth = calcAverageGrowth(history);
        double next = history[history.length - 1] * (1 + avgGrowth);
        result[result.length - k] = round2(next);

        double[] extended = Arrays.copyOf(history, history.length + 1);
        extended[extended.length - 1] = next;
        forecastRecurse(extended, k - 1, result);
    }

    private static double calcAverageGrowth(double[] values) {
        double sum = 0;
        for (int i = 1; i < values.length; i++) {
            sum += (values[i] - values[i - 1]) / values[i - 1];
        }
        return sum / (values.length - 1);
    }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
