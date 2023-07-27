import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean exit = false;
    static StepTracker stepTracker = new StepTracker();

    public static void main(String[] args) {
        System.out.println("Приложение \"StepTracker\" запущено");

        while (!exit) {
            enterCommand();
        }
    }

    public static void enterCommand() {
        System.out.println("""
                \nСписок доступных команд:\s
                1) Ввести количество шагов за определённый день - "ВВОД"
                2) Напечатать статистику за определённый месяц - "СТАТИСТИКА"
                3) Изменить цель по количеству шагов в день - "ЦЕЛЬ"
                4) Конвертировать шаги в пройденные километры или сожженные калории - "КОНВЕРТАЦИЯ"
                5) Выйти из приложения - "ВЫЙТИ"

                ВВЕДИТЕ КОМАНДУ:"""
        );

        Scanner scanner = new Scanner(System.in);
        String enterCommand = scanner.nextLine();

        switch (enterCommand.toUpperCase()) {
            case ("ВВОД"):
                enterData(stepTracker);
                break;
            case ("СТАТИСТИКА"):
                showStatistics(stepTracker);
                break;
            case ("ЦЕЛЬ"):
                editTarget(stepTracker);
                break;
            case ("КОНВЕРТАЦИЯ"):
                enterCaloriesConverterCommand();
                break;
            case ("ВЫХОД"):
                exit = true;
                System.exit(0);
                break;
            default:
                System.out.println("Неверная команда");
        }
    }

    public static void enterData(StepTracker stepTracker) {
        int monthNumber;
        int dayNumber;
        int numberOfSteps;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер месяца (0 - январь, 1 - ферваль, и т.д.)");
        monthNumber = scanner.nextInt();
        if (monthNumber > 11 || monthNumber < 0) {
            while (monthNumber > 11 || monthNumber < 0) {
                System.out.println("Неверное число месяца. Введите число заново");
                monthNumber = scanner.nextInt();
            }
        }

        System.out.println("Введи номер дня в месяце");
        dayNumber = scanner.nextInt();
        if (dayNumber > 30 || dayNumber < 0) {
            while (dayNumber > 30 || dayNumber < 0) {
                System.out.println("Неверное число дня месяца. Введите число заново");
                dayNumber = scanner.nextInt();
            }
        }

        System.out.println("Введи количество шагов за день");
        numberOfSteps = scanner.nextInt();
        if (numberOfSteps < 0) {
            while (numberOfSteps < 0) {
                System.out.println("Число шагов не может быть отрицательным. Введите число заново");
                numberOfSteps = scanner.nextInt();
            }
        }

        stepTracker.setData(monthNumber, dayNumber, numberOfSteps);

        System.out.println("Данные введены" + "\n");
    }

    public static void showStatistics(StepTracker stepTracker) {
        System.out.println("Напишите название месяця, статистику которого хотите посмотреть: ");
        Scanner scanner = new Scanner(System.in);
        String enterCommand = scanner.nextLine();
        stepTracker.showStatisticForTheMonth(enterCommand);
    }

    public static void editTarget(StepTracker stepTracker) {
        int newTarget = 0;
        System.out.println("Текущее целевое количество шагов " + stepTracker.getTarget() +
                "\nВведите новое целевое количество шагов");
        Scanner scanner = new Scanner(System.in);
        try {
            newTarget = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат числа");
            editTarget(stepTracker);
        }
        stepTracker.setTarget(newTarget);
    }

    public static void enterCaloriesConverterCommand() {
        Converter converter = new Converter();
        int enteredNumber = 0;

        System.out.println("Введите команду:" +
                "\n1) Шаги в километры - \"КИЛОМЕТРЫ\"" +
                "\n2) Шаги в калории - \"КИЛОКАЛОРИИ\"");
        Scanner scanner = new Scanner(System.in);
        String enterCommand = scanner.nextLine();
        switch (enterCommand.toUpperCase()) {
            case ("КИЛОМЕТРЫ"):
                System.out.println("Введите число шагов:");
                enteredNumber = scanner.nextInt();
                converter.stepsIntoKilometers(enteredNumber);
                break;
            case ("КИЛОКАЛОРИИ"):
                System.out.println("Введите число шагов:");
                enteredNumber = scanner.nextInt();
                converter.stepsIntoCalories(enteredNumber);
                break;
            default:
                System.out.println("Неверная команда");
        }
    }
}
