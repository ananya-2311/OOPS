package FunctionalInterface;

import java.util.*;
import java.util.function.*;


public class Demo {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 25, 50000),
                new Employee("Riya", 32, 90000),
                new Employee("Riyaan", 37, 80000),
                new Employee("John", 28, 70000)
        );

        // 1️⃣ Predicate – filter employees above age 30
        Predicate<Employee> ageAbove30 = e -> e.age > 30;

        // 2️⃣ Function – get salary from employee
        Function<Employee, Double> getSalary = e -> e.salary;

        // 3️⃣ Consumer – print employee details
        Consumer<Employee> printer =
                e -> System.out.println(e.name + " - " + e.salary);

        // 4️⃣ Supplier – generate default bonus
        Supplier<Double> bonusSupplier = () -> 5000.0;

        // 5️⃣ Comparator – sort by salary
        Comparator<Employee> salaryComparator =
                (e1, e2) -> Double.compare(e1.salary, e2.salary);

        // 6️⃣ Runnable – background task
        Runnable task = () -> System.out.println("Processing employees...");

        // ---- USING EVERYTHING ----
        task.run();

        employees.stream()
                .filter(ageAbove30)     // Predicate
                .sorted(salaryComparator) // Comparator
                .peek(printer)           // Consumer
                .map(e -> e.salary + bonusSupplier.get()) // Function + Supplier
                .forEach(s -> System.out.println("Final Salary: " + s));
    }

}
