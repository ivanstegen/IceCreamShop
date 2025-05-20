import com.icecreamshop.decorator.IceCream;
import com.icecreamshop.factory.IceCreamFactory;
import com.icecreamshop.singleton.IceCreamShop;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IceCreamShop shop = IceCreamShop.getInstance();

    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println();
            System.out.println("1. Нова поръчка");
            System.out.println("2. Преглед на ценоразпис");
            System.out.println("3. Статистика на магазина");
            System.out.println("0. Изход");
            System.out.print("\nИзберете опция: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0 -> {
                        exit = true;
                        System.out.println("\nБлагодарим ви, че посетихте нашия магазин! Елате пак!");
                    }
                    case 1 -> handleNewOrder();
                    case 2 -> showPriceList();
                    case 3 -> showStatistics();
                    default -> System.out.println("Невалиден избор. Моля, опитайте отново.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Моля, въведете число.");
                scanner.nextLine();
            }
        }
    }

    private static void handleNewOrder() {
        
        IceCreamFactory factory = new IceCreamFactory();
        List<String> availableTypes = factory.getAvailableTypes();

        System.out.println("\nИзберете вид сладолед:");
        for (int i = 0; i < availableTypes.size(); i++) {
            String type = availableTypes.get(i);
            String capitalizedType = type.substring(0, 1).toUpperCase() + type.substring(1);
            System.out.println((i + 1) + ". " + capitalizedType);
        }

        String selectedIceCream = availableTypes.get(0);
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("\nВашият избор: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= availableTypes.size()) {
                    selectedIceCream = availableTypes.get(choice - 1);
                    validChoice = true;
                } else {
                    System.out.println("Невалиден избор. Моля, изберете отново.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Моля, въведете число.");
                scanner.nextLine();
            }
        }

        boolean withGlaze = askYesNoQuestion("\nИскате ли шоколадова глазура? (д/н): ");
        boolean withSticks = askYesNoQuestion("Искате ли шоколадови пръчици? (д/н): ");

        IceCream iceCream = shop.sellIceCream(selectedIceCream, withGlaze, withSticks);

        System.out.println("\nВашата поръчка е готова!");
        System.out.println("Описание: " + iceCream.getDescription());
        System.out.println("Цена: " + iceCream.getPrice() + " лв.");
    }

    private static void showPriceList() {

        String[][] items = {
            {"Основни сладоледи:", null},
            {"Ванилов сладолед", "5.00"},
            {"Шоколадов сладолед", "5.50"},
            {"Ягодов сладолед", "6.00"},
            {"\nДобавки:", null},
            {"Шоколадова глазура", "1.50"},
            {"Шоколадови пръчици", "2.00"},
            {"\nПопулярни комбинации:", null},
            {"Ванилов сладолед с шоколадова глазура", "6.50"},
            {"Шоколадов сладолед с шоколадови пръчици", "7.50"},
            {"Ягодов сладолед с всички добавки", "9.50"}
        };
        
        for (String[] item : items) {
            if (item[1] == null) {
                System.out.println(item[0]);
            } else {
                System.out.printf("- %-40s %5.2f лв.%n", item[0], Double.parseDouble(item[1]));
            }
        }
    }

    private static void showStatistics() {

        System.out.println("\nОбщ брой продажби: " + shop.getSalesCount());

        System.out.println("\nПродажби по видове сладолед:");
        Map<String, Integer> salesByType = shop.getAllSalesByType();
        if (salesByType.isEmpty()) {
            System.out.println("Няма продажби досега.");
        } else {
            salesByType.forEach((type, count) -> {
                double percentage = (double) count / shop.getSalesCount() * 100;
                System.out.printf("- %s: %d продажби (%.1f%%)\n", type, count, percentage);
            });
        }
    }

    private static boolean askYesNoQuestion(String question) {
        while (true) {
            System.out.print(question);
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("д") || response.equals("да") || response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("н") || response.equals("не") || response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("Моля, отговорете с 'д' (да) или 'н' (не).");
            }
        }
    }
}