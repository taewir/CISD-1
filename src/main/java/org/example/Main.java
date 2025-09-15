package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EngineManager manager = new EngineManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Меню -----");
            System.out.println("1. Добавить новый двигатель");
            System.out.println("2. Удалить двигатель по индексу");
            System.out.println("3. Показать все двигатели");
            System.out.println("4. Сравнить два двигателя");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> addEngineMenu(manager, sc);
                case "2" -> removeEngineMenu(manager, sc);
                case "3" -> showAllEngines(manager);
                case "4" -> compareEngines(manager, sc);
                case "5" -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                double value = Double.parseDouble(input);
                if (value < min || value > max) {
                    System.out.println("Значение вне диапазона [" + min + " - " + max + "]");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    private static void addEngineMenu(EngineManager manager, Scanner sc) {
        System.out.println("Выберите тип двигателя: 1-Engine, 2-ICE, 3-Diesel, 4-Jet");
        String type = sc.nextLine();
        Engine e;

        try {
            switch (type) {
                case "1" -> {
                    System.out.print("Введите имя двигателя: ");
                    String name = sc.nextLine();
                    double power = readDouble(sc, "Введите мощность (kW): ", 0, 10000);
                    e = new Engine(name, power);
                }
                case "2" -> {
                    System.out.print("Введите имя двигателя: ");
                    String name = sc.nextLine();
                    double power = readDouble(sc, "Введите мощность (kW): ", 0, 10000);
                    System.out.print("Введите тип топлива: ");
                    String fuelType = sc.nextLine();
                    int rpm = (int) readDouble(sc, "Введите обороты (RPM): ", 0, 20000);
                    e = new InternalCombustionEngine(name, power, fuelType, rpm);
                }
                case "3" -> {
                    System.out.print("Введите имя двигателя: ");
                    String name = sc.nextLine();
                    double power = readDouble(sc, "Введите мощность (kW): ", 0, 10000);
                    System.out.print("Введите тип топлива: ");
                    String fuelType = sc.nextLine();
                    int rpm = (int) readDouble(sc, "Введите обороты (RPM): ", 0, 20000);
                    System.out.print("Введите класс выбросов: ");
                    String emissionClass = sc.nextLine();
                    double torque = readDouble(sc, "Введите крутящий момент: ", 0, 10000);
                    e = new DieselEngine(name, power, fuelType, rpm, emissionClass, torque);
                }
                case "4" -> {
                    System.out.print("Введите имя двигателя: ");
                    String name = sc.nextLine();
                    double power = readDouble(sc, "Введите мощность (kW): ", 0, 10000);
                    System.out.print("Введите модель: ");
                    String model = sc.nextLine();
                    double thrust = readDouble(sc, "Введите тягу: ", 0, 100000);
                    e = new JetEngine(name, power, model, thrust);
                }
                default -> {
                    System.out.println("Неверный тип.");
                    return;
                }
            }
            manager.addEngine(e);
            System.out.println("Двигатель добавлен: " + e);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка при создании двигателя: " + ex.getMessage());
        }
    }

    private static void removeEngineMenu(EngineManager manager, Scanner sc) {
        System.out.print("Введите индекс для удаления: ");
        try {
            int idx = Integer.parseInt(sc.nextLine());
            Engine removed = manager.getByIndex(idx);
            manager.removeEngine(idx);
            System.out.println("Удалён двигатель: " + removed);
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка: введите число.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Ошибка: неверный индекс.");
        }
    }

    private static void showAllEngines(EngineManager manager) {
        if (manager.size() == 0) {
            System.out.println("Список пуст.");
            return;
        }
        int i = 0;
        for (Engine e : manager.getAll()) {
            System.out.println(i++ + ": " + e);
        }
    }

    private static void compareEngines(EngineManager manager, Scanner sc) {
        try {
            System.out.print("Введите индекс первого двигателя: ");
            int i1 = Integer.parseInt(sc.nextLine());
            System.out.print("Введите индекс второго двигателя: ");
            int i2 = Integer.parseInt(sc.nextLine());
            boolean result = manager.compare(i1, i2);
            System.out.println("Равны? " + result);
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка: введите число.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Ошибка: неверный индекс.");
        }
    }
}