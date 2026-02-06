
import java.util.*;

/**
 * Splitwise-like Expense Settlement System
 * Uses Greedy Minimum Cash Flow Algorithm
 * Optimized with Priority Queues (Heaps)
 */
public class Splitwise {

    // Represents a raw transaction
    static class Transaction {
        String payer;
        String receiver;
        int amount;

        Transaction(String payer, String receiver, int amount) {
            this.payer = payer;
            this.receiver = receiver;
            this.amount = amount;
        }
    }

    // Represents a user with net balance
    static class User {
        String name;
        int balance;

        User(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }
    }

    // Core logic to minimize cash flow
    public static void settleExpenses(List<Transaction> transactions) {

        // Step 1: Calculate net balance
        Map<String, Integer> balanceMap = new HashMap<>();

        for (Transaction t : transactions) {
            balanceMap.put(t.payer, balanceMap.getOrDefault(t.payer, 0) - t.amount);
            balanceMap.put(t.receiver, balanceMap.getOrDefault(t.receiver, 0) + t.amount);
        }

        // Step 2: Create heaps
        PriorityQueue<User> creditors = new PriorityQueue<>((a, b) -> b.balance - a.balance);
        PriorityQueue<User> debtors = new PriorityQueue<>((a, b) -> a.balance - b.balance);

        for (Map.Entry<String, Integer> entry : balanceMap.entrySet()) {
            if (entry.getValue() > 0) {
                creditors.add(new User(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() < 0) {
                debtors.add(new User(entry.getKey(), entry.getValue()));
            }
        }

        // Step 3: Greedy settlement
        System.out.println("Optimized Transactions:");

        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            User creditor = creditors.poll();
            User debtor = debtors.poll();

            int settleAmount = Math.min(creditor.balance, -debtor.balance);

            System.out.println(debtor.name + " pays ₹" + settleAmount + " to " + creditor.name);

            creditor.balance -= settleAmount;
            debtor.balance += settleAmount;

            if (creditor.balance > 0) {
                creditors.add(creditor);
            }
            if (debtor.balance < 0) {
                debtors.add(debtor);
            }
        }
    }

    // Driver method
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("A", "B", 100));
        transactions.add(new Transaction("B", "C", 50));
        transactions.add(new Transaction("C", "A", 30));
        transactions.add(new Transaction("A", "D", 20));

        settleExpenses(transactions);
    }
}
