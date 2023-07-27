public class Converter {
    public double stepsIntoKilometers(int steps) {
        double result = 0;
        result = (double) (steps * 75) / 1000;
        System.out.println("Вами пройдено " + result + " км");
        return result;
    }

    public double stepsIntoCalories(int steps) {
        double result = 0;
        result = (double) (steps * 50) / 1000;
        System.out.println("Вами сожжено " + result + " килокалорий");
        return result;
    }
}
