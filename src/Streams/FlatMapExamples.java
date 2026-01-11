package Streams;

import java.util.*;
import java.util.stream.*;

public class FlatMapExamples {

    static class Transaction {
        int amount;
        boolean credit;

        Transaction(int amount, boolean credit) {
            this.amount = amount;
            this.credit = credit;
        }

        int getAmount() {
            return amount;
        }

        boolean isCredit() {
            return credit;
        }

        @Override
        public String toString() {
            return "Txn{" + amount + ", credit=" + credit + '}';
        }
    }

    static class Account {
        String accountNo;
        List<Transaction> transactions;

        Account(String accountNo, List<Transaction> transactions) {
            this.accountNo = accountNo;
            this.transactions = transactions;
        }

        List<Transaction> getTransactions() {
            return transactions;
        }
    }

    public static void main(String[] args) {

        List<Account> accounts = List.of(
                new Account("A1", List.of(
                        new Transaction(5000, true),
                        new Transaction(15000, false)
                )),
                new Account("A2", List.of(
                        new Transaction(20000, true),
                        new Transaction(3000, true)
                ))
        );

        /*
         * 1️⃣ BASIC FLATTENING (Accounts → Transactions)
         */
        System.out.println("1️⃣ All Transactions:");
        accounts.stream()
                .flatMap(acc -> acc.getTransactions().stream())
                .forEach(System.out::println);

        /*
         * 2️⃣ FILTER AFTER FLATMAP (Most common pattern)
         */
        System.out.println("\n2️⃣ Transactions > 10,000:");
        accounts.stream()
                .flatMap(acc -> acc.getTransactions().stream())
                .filter(tx -> tx.getAmount() > 10_000)
                .forEach(System.out::println);

        /*
         * 3️⃣ FILTER INSIDE FLATMAP
         */
        System.out.println("\n3️⃣ Only CREDIT transactions:");
        accounts.stream()
                .flatMap(acc ->
                        acc.getTransactions().stream()
                                .filter(Transaction::isCredit)
                )
                .forEach(System.out::println);

        /*
         * 4️⃣ MAP + FLATMAP COMBINATION
         */
        System.out.println("\n4️⃣ Credit transaction amounts:");
        accounts.stream()
                .flatMap(acc -> acc.getTransactions().stream())
                .filter(Transaction::isCredit)
                .map(Transaction::getAmount)
                .forEach(System.out::println);

        /*
         * 5️⃣ FLATMAP + REDUCE
         */
        int totalAmount =
                accounts.stream()
                        .flatMap(acc -> acc.getTransactions().stream())
                        .map(Transaction::getAmount)
                        .reduce(0, Integer::sum);

        System.out.println("\n5️⃣ Total transaction amount = " + totalAmount);

        /*
         * 6️⃣ FLATMAP + COLLECT
         */
        List<Transaction> allTxns =
                accounts.stream()
                        .flatMap(acc -> acc.getTransactions().stream())
                        .toList();

        System.out.println("\n6️⃣ Collected Transactions: " + allTxns);

        /*
         * 7️⃣ FLATMAP WITH OPTIONAL (Java 9+)
         */
        Optional<Account> optionalAccount =
                Optional.of(new Account("A3",
                        List.of(new Transaction(9000, true))));

        System.out.println("\n7️⃣ Optional + flatMap:");
        optionalAccount.stream()
                .flatMap(acc -> acc.getTransactions().stream())
                .forEach(System.out::println);

        /*
         * 8️⃣ FLATMAP TO INT (Primitive Stream)
         */
        int sumUsingIntStream =
                accounts.stream()
                        .flatMapToInt(acc ->
                                acc.getTransactions()
                                        .stream()
                                        .mapToInt(Transaction::getAmount)
                        )
                        .sum();

        System.out.println("\n8️⃣ Sum using flatMapToInt = " + sumUsingIntStream);

        /*
         * 9️⃣ FLATMAP WITH STRINGS (String → Characters)
         */
        List<String> words = List.of("bank", "java");

        System.out.println("\n9️⃣ Characters from words:");
        words.stream()
                .flatMap(word ->
                        word.chars().mapToObj(c -> (char) c)
                )
                .forEach(System.out::println);

        System.out.println("\n🔟 Characters list from words:");
        List<List<Character>> result =
                words.stream()
                        .map(str ->
                                str.chars()
                                        .mapToObj(c -> (char) c)
                                        .toList()
                        )
                        .toList();
        System.out.println(result.toString());

        System.out.println("\n9️⃣ Characters from words:");
        List<Character> allChars =
                words.stream()
                        .flatMap(str ->
                                str.chars()
                                        .mapToObj(c -> (char) c)
                        )
                        .toList();
        System.out.println(allChars.toString());


        /*
         * 🔟 WHAT MAP WOULD DO (TRAP EXAMPLE)
         */
        System.out.println("\n🔟 map() producing nested streams:");
        accounts.stream()
                .map(acc -> acc.getTransactions().stream())
                .forEach(System.out::println);
    }
}
