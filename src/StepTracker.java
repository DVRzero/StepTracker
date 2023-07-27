public class StepTracker {

    private int target = 10_000;

    public int getTarget() {
        return target;
    }

    public void setTarget(int newTarget) {
        if (newTarget > 0) {
            this.target = newTarget;
        } else {
            System.out.println("Цель не может быть отрицательной");
        }
        System.out.println("Новая цель установлена");
        Main.enterCommand();
    }

    int[] daysOfJanuary = new int[30];
    int[] daysOfFebruary = new int[30];
    int[] daysOfMarch = new int[30];
    int[] daysOfApril = new int[30];
    int[] daysOfMay = new int[30];
    int[] daysOfJune = new int[30];
    int[] daysOfJuly = new int[30];
    int[] daysOfAugust = new int[30];
    int[] daysOfSeptember = new int[30];
    int[] daysOfOctober = new int[30];
    int[] daysOfNovember = new int[30];
    int[] daysOfDecember = new int[30];

    public void setData(int monthNumber, int dayNumber, int numberOfSteps) {
        switch (monthNumber) {
            case (0):
                daysOfJanuary[dayNumber] = numberOfSteps;
                break;
            case (1):
                daysOfFebruary[dayNumber] = numberOfSteps;
                break;
            case (2):
                daysOfMarch[dayNumber] = numberOfSteps;
                break;
            case (3):
                daysOfApril[dayNumber] = numberOfSteps;
                break;
            case (4):
                daysOfMay[dayNumber] = numberOfSteps;
                break;
            case (5):
                daysOfJune[dayNumber] = numberOfSteps;
                break;
            case (6):
                daysOfJuly[dayNumber] = numberOfSteps;
                break;
            case (7):
                daysOfAugust[dayNumber] = numberOfSteps;
                break;
            case (8):
                daysOfSeptember[dayNumber] = numberOfSteps;
                break;
            case (9):
                daysOfOctober[dayNumber] = numberOfSteps;
                break;
            case (10):
                daysOfNovember[dayNumber] = numberOfSteps;
                break;
            case (11):
                daysOfDecember[dayNumber] = numberOfSteps;
                break;
            default:
                System.out.println("Неверная команда");
        }
    }

    public void showStatisticForTheMonth(String selectedMonth) {
        switch (selectedMonth.toUpperCase()) {
            case ("ЯНВАРЬ"):
                System.out.println("\nОбщая статистика за январь:");
                collectStatisticForTheMonth(daysOfJanuary);
                break;
            case ("ФЕВРАЛЬ"):
                System.out.println("\nОбщая статистика за февраль:");
                collectStatisticForTheMonth(daysOfFebruary);
                break;
            case ("МАРТ"):
                System.out.println("\nОбщая статистика за март:");
                collectStatisticForTheMonth(daysOfMarch);
                break;
            case ("АПРЕЛЬ"):
                System.out.println("\nОбщая статистика за апрель:");
                collectStatisticForTheMonth(daysOfApril);
                break;
            case ("МАЙ"):
                System.out.println("\nОбщая статистика за май:");
                collectStatisticForTheMonth(daysOfMay);
                break;
            case ("ИЮНЬ"):
                System.out.println("\nОбщая статистика за июнь:");
                collectStatisticForTheMonth(daysOfJune);
                break;
            case ("ИЮЛЬ"):
                System.out.println("\nОбщая статистика за июль:");
                collectStatisticForTheMonth(daysOfJuly);
                break;
            case ("АВГУСТ"):
                System.out.println("\nОбщая статистика за август:");
                collectStatisticForTheMonth(daysOfAugust);
                break;
            case ("СЕНТЯБРЬ"):
                System.out.println("\nОбщая статистика за сентябрь:");
                collectStatisticForTheMonth(daysOfSeptember);
                break;
            case ("ОКТЯБРЬ"):
                System.out.println("\nОбщая статистика за октябрь:");
                collectStatisticForTheMonth(daysOfOctober);
                break;
            case ("НОЯБРЬ"):
                System.out.println("\nОбщая статистика за ноябрь:");
                collectStatisticForTheMonth(daysOfNovember);
                break;
            case ("ДЕКАБРЬ"):
                System.out.println("\nОбщая статистика за декабрь:");
                collectStatisticForTheMonth(daysOfDecember);
                break;
            case ("ВЫХОД"):
                System.exit(0);
                break;
            default:
                System.out.println("Неверная команда");
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
