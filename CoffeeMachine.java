package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void remaining(int waterLvl, int milkLvl, int coffeeLvl, int cupLvl, int cash) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterLvl + " ml of water");
        System.out.println(milkLvl + " ml of milk");
        System.out.println(coffeeLvl + " g of coffee beans");
        System.out.println(cupLvl + " disposable cups");
        System.out.println("$" + cash + " of money\n");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterLvl = 400;
        int milkLvl = 540;
        int coffeeLvl = 120;
        int cupLvl = 9;
        int cash = 550;

        int waterNeeded = 0;
        int milkNeeded = 0;
        int coffeeNeeded = 0;
        int cupNeeded = 0;

        boolean breaker = true;

        while (breaker) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = scanner.next();
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeType = scanner.next();
                    switch (coffeeType) {
                        case "1":
                            waterNeeded = 250;
                            coffeeNeeded = 16;
                            cupNeeded = 1;
                            cash = cash + 4;
                            break;
                        case "2":
                            waterNeeded = 350;
                            milkNeeded = 75;
                            coffeeNeeded = 20;
                            cupNeeded = 1;
                            cash = cash + 7;
                            break;
                        case "3":
                            waterNeeded = 200;
                            milkNeeded = 100;
                            coffeeNeeded = 12;
                            cupNeeded = 1;
                            cash = cash + 6;
                            break;
                        case "back":
                            break;
                    }
                    if (waterLvl <= waterNeeded) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milkLvl <= milkNeeded) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeeLvl <= coffeeNeeded) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cupLvl <= cupNeeded) {
                        System.out.println("Sorry, not enough disposable cups!");
                    } else {
                        waterLvl = waterLvl - waterNeeded;
                        milkLvl = milkLvl - milkNeeded;
                        coffeeLvl = coffeeLvl - coffeeNeeded;
                        cupLvl = cupLvl - cupNeeded;
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    break;
                case "fill":
                    System.out.println("\nWrite how many ml of water you want to add:");
                    waterLvl = scanner.nextInt() + waterLvl;
                    System.out.println("Write how many ml of milk you want to add:");
                    milkLvl = scanner.nextInt() + milkLvl;
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffeeLvl = scanner.nextInt() + coffeeLvl;
                    System.out.println("Write how many disposable cups you want to add:\n");
                    cupLvl = scanner.nextInt() + cupLvl;
                    break;
                case "take":
                    System.out.println("I gave you $" + cash);
                    cash = 0;
                    break;
                case "remaining":
                    remaining(waterLvl, milkLvl, coffeeLvl, cupLvl, cash);
                    break;
                case "exit":
                    breaker = false;
            }
        }
    }
}
