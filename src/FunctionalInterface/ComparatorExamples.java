package FunctionalInterface;

import java.util.*;

public class ComparatorExamples {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Amit", 30, 70000),
                new Employee("Riya", 25, 90000),
                new Employee("John", 28, 60000),
                new Employee("Neha", 30, 90000)
        ));

        // 1️⃣ Sort by salary (Ascending)
        Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.salary, e2.salary);
        employees.sort(bySalary);
        System.out.println("1. Salary Asc: " + employees);

        Comparator<Employee> bySalary2 = Comparator.comparingInt(e -> (int) e.salary);
        employees.sort(bySalary2);
        System.out.println("1.1 Salary Asc: " + employees);

        // 2️⃣ Sort by salary (Descending)
        Comparator<Employee> bySalaryDesc = (e1, e2) -> Double.compare(e2.salary, e1.salary);
        employees.sort(bySalaryDesc);
        System.out.println("2. Salary Desc: " + employees);

        // 3️⃣ Sort by age
        Comparator<Employee> byAge = Comparator.comparingInt(e -> e.age);
        employees.sort(byAge);
        System.out.println("3. Age Asc: " + employees);

        // 4️⃣ Sort by name alphabetically
        Comparator<Employee> byName = Comparator.comparing(e -> e.name);
        employees.sort(byName);
        System.out.println("4. Name Asc: " + employees);

        // 5️⃣ Sort by name (case-insensitive)
        Comparator<Employee> byNameIgnoreCase = Comparator.comparing(e -> e.name.toLowerCase());
        employees.sort(byNameIgnoreCase);
        System.out.println("5. Name Ignore Case: " + employees);

        // 6️⃣ Sort by salary then age
        Comparator<Employee> bySalaryThenAge = Comparator.comparing((Employee e) -> e.salary).thenComparing(e -> e.age);
        employees.sort(bySalaryThenAge);
        System.out.println("6. Salary → Age: " + employees);

        // 7️⃣ Reverse order
        Comparator<Employee> reverseSalary = Comparator.comparing(Employee::getSalary).reversed();
        employees.sort(reverseSalary);
        System.out.println("7. Reverse Salary: " + employees);

        // 8️⃣ Null-safe sorting (name can be null)
        Comparator<Employee> nullSafeComparator =
                Comparator.comparing(
                        e -> e.name,
                        Comparator.nullsLast(String::compareTo)
                );
        employees.sort(nullSafeComparator);
        System.out.println("8. Null Safe Name Sort: " + employees);

        // 9️⃣ Using Comparator in Stream
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(e -> System.out.println("9. Stream Sorted: " + e));

        // 10️⃣ Custom complex logic (salary desc, age asc)
        Comparator<Employee> complex =
                (e1, e2) -> {
                    if (e1.salary != e2.salary)
                        return Double.compare(e2.salary, e1.salary);
                    return Integer.compare(e1.age, e2.age);
                };
        employees.sort(complex);
        System.out.println("10. Complex sort: " + employees);

        // 11️⃣ Comparator using lambda short form
        Comparator<Employee> shortForm = (a, b) -> a.age - b.age;
        employees.sort(shortForm);
        System.out.println("11. Short lambda: " + employees);

        // 12️⃣ Comparator using method reference
        Comparator<Employee> methodRef = Comparator.comparing(Employee::getSalary);
        employees.sort(methodRef);
        System.out.println("12. Method Reference: " + employees);
    }
}

