package financial.forecast;

import java.util.Arrays;

public class ForecastCalculator {


    public static double forecastValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecastValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {


        double[] pastValues = {95000.0, 102000.0, 110500.0, 119000.0};
        double lastKnownValue = pastValues[pastValues.length - 1];

        double growthRate = 0.08; // 8%
        int forecastYears = 4;

        double[] forecastValues = new double[forecastYears];
        for (int i = 0; i < forecastYears; i++) {
            forecastValues[i] = forecastValue(lastKnownValue, growthRate, i + 1);
        }


        System.out.println("Past values : " + Arrays.toString(pastValues));
        System.out.println("Forecast of next " + forecastYears + " years : " + Arrays.toString(forecastValues));
    }
}
