package definingClasses.bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");

            String output = null;

            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    output = "Account ID" + account.getId() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        bankAccounts.get(id).deposit(amount);
                        output = "Deposited " + amount + " to ID" + id;
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int id1 = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id1)) {
                        output = "Account does not exist";
                    } else {
                        double interest1 = bankAccounts.get(id1).getInterest(years);
                        output = String.format("%.2f", interest1);
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            command = scanner.nextLine();
        }
    }
}
