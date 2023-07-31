import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean exit = false;
    static StepTracker stepTracker = new StepTracker();

    public static void main(String[] args) {
        System.out.println("Приложение \"StepTracker\" запущено");
        printMenu();
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            String enterCommand = scanner.next();
            switch (enterCommand.toUpperCase()) {
                case ("ВВОД"):
                    int monthNumber;
                    int dayNumber;
                    int numberOfSteps;

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
                    break;

                case ("СТАТИСТИКА"):
                    System.out.println("Напишите название месяця, статистику которого хотите посмотреть: ");
                    String selectedMonth = scanner.next();
                    switch (selectedMonth.toUpperCase()) {
                        case ("ЯНВАРЬ"):
                            System.out.println("\nОбщая статистика за январь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("ФЕВРАЛЬ"):
                            System.out.println("\nОбщая статистика за февраль:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("МАРТ"):
                            System.out.println("\nОбщая статистика за март:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("АПРЕЛЬ"):
                            System.out.println("\nОбщая статистика за апрель:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("МАЙ"):
                            System.out.println("\nОбщая статистика за май:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("ИЮНЬ"):
                            System.out.println("\nОбщая статистика за июнь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("ИЮЛЬ"):
                            System.out.println("\nОбщая статистика за июль:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("АВГУСТ"):
                            System.out.println("\nОбщая статистика за август:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("СЕНТЯБРЬ"):
                            System.out.println("\nОбщая статистика за сентябрь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("ОКТЯБРЬ"):
                            System.out.println("\nОбщая статистика за октябрь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("НОЯБРЬ"):
                            System.out.println("\nОбщая статистика за ноябрь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        case ("ДЕКАБРЬ"):
                            System.out.println("\nОбщая статистика за декабрь:");
                            stepTracker.showStatisticForTheMonth(selectedMonth);
                            break;
                        default:
                            System.out.println("Неверная команда");
                    }
                    break;

                case ("ЦЕЛЬ"):
                    int newTarget;
                    System.out.println("Текущее целевое количество шагов " + stepTracker.getTarget() +
                            "\nВведите новое целевое количество шагов");
                    newTarget = scanner.nextInt();
                    try {
                        if (newTarget > 0) {
                            stepTracker.setTarget(newTarget);
                            System.out.println("Новая цель установлена");
                        } else {
                            System.out.println("Цель не может быть отрицательной");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Неверный формат числа");
                    }
                    break;

                case ("КОНВЕРТАЦИЯ"):
                    Converter converter = new Converter();
                    int enteredNumber;
                    System.out.println("Введите команду:" +
                            "\n1) Шаги в километры - \"КИЛОМЕТРЫ\"" +
                            "\n2) Шаги в калории - \"КИЛОКАЛОРИИ\"");
                    String convertCommand = scanner.next();
                    switch (convertCommand.toUpperCase()) {
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
                    break;
                case ("ВЫХОД"):
                    exit = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.println("""
                \nСписок доступных команд:\s
                1) Ввести количество шагов за определённый день - "ВВОД"
                2) Напечатать статистику за определённый месяц - "СТАТИСТИКА"
                3) Изменить цель по количеству шагов в день - "ЦЕЛЬ"
                4) Конвертировать шаги в пройденные километры или сожженные калории - "КОНВЕРТАЦИЯ"
                5) Выйти из приложения - "ВЫЙТИ"

                ВВЕДИТЕ КОМАНДУ:"""
        );
    }
}
