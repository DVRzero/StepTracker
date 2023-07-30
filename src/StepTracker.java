public class StepTracker {

    private int target = 10_000;
    private Month[] months;

    public StepTracker() {
        this.months = new Month[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = new Month();
        }
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int newTarget) {
        this.target = newTarget;
    }

    public void setData(int monthNumber, int dayNumber, int numberOfSteps) {
        months[monthNumber].setStepsPerDays(dayNumber, numberOfSteps);
    }

    public void showStatisticForTheMonth(String selectedMonth) {
        switch (selectedMonth.toUpperCase()) {
            case ("ЯНВАРЬ"):
                collectStatisticForTheMonth(months[0].getDays());
                break;
            case ("ФЕВРАЛЬ"):
                collectStatisticForTheMonth(months[1].getDays());
                break;
            case ("МАРТ"):
                collectStatisticForTheMonth(months[2].getDays());
                break;
            case ("АПРЕЛЬ"):
                collectStatisticForTheMonth(months[3].getDays());
                break;
            case ("МАЙ"):
                collectStatisticForTheMonth(months[4].getDays());
                break;
            case ("ИЮНЬ"):
                collectStatisticForTheMonth(months[5].getDays());
                break;
            case ("ИЮЛЬ"):
                collectStatisticForTheMonth(months[6].getDays());
                break;
            case ("АВГУСТ"):
                collectStatisticForTheMonth(months[7].getDays());
                break;
            case ("СЕНТЯБРЬ"):
                collectStatisticForTheMonth(months[8].getDays());
                break;
            case ("ОКТЯБРЬ"):
                collectStatisticForTheMonth(months[9].getDays());
                break;
            case ("НОЯБРЬ"):
                collectStatisticForTheMonth(months[10].getDays());
                break;
            case ("ДЕКАБРЬ"):
                collectStatisticForTheMonth(months[11].getDays());
                break;
        }
    }

    private void arraysToText(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + " день: " + arr[i]);
            System.out.print("   |   ");
        }
        System.out.println();
    }

    private int sumOfStepsInMonth(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    private int maxStepsInOneMonth(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(arr[i], arr[i + 1]);
        }
        return max;
    }

    private int maxDaysOfGoals(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                count++;
            }
        }
        return count;
    }

    private void collectStatisticForTheMonth(int[] arr) {
        Converter converter = new Converter();
        System.out.println("\nСтатистика по дням: ");
        arraysToText(arr);
        System.out.println("\nВсего шагов пройдено: " + sumOfStepsInMonth(arr));
        System.out.println("\nМаксимальное число шагов за месяц: " + maxStepsInOneMonth(arr));
        System.out.println("\nСреднее количество шагов в месяц " + (sumOfStepsInMonth(arr) / 30));
        System.out.println("\nКолличество сожженых калорий за месяц " + converter.stepsIntoCalories(sumOfStepsInMonth(arr)));
        System.out.println("\nЧисло дней подряд с выполненной целью в течении месяца " + maxDaysOfGoals(arr));
    }
}
