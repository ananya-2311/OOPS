package Streams;

import java.util.*;
import java.util.stream.*;

public class CollectorsDemo {

    static class Employee {
        int id;
        String name;
        String dept;
        int salary;

        Employee(int id, String name, String dept, int salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDept() { return dept; }
        public int getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "(" + dept + ", " + salary + ")";
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Ananya", "IT", 70000),
                new Employee(2, "Rohit", "HR", 50000),
                new Employee(3, "Neha", "IT", 90000),
                new Employee(4, "Aman", "HR", 60000),
                new Employee(5, "Priya", "Finance", 80000)
        );

        /* 1️⃣ toList() */
        List<String> names =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.toList());
        System.out.println("toList: " + names);
        //toList: [Ananya, Rohit, Neha, Aman, Priya]

        /* 2️⃣ toSet() */
        Set<String> depts =
                employees.stream()
                        .map(Employee::getDept)
                        .collect(Collectors.toSet());
        System.out.println("toSet: " + depts);
        //toSet: [Finance, HR, IT]

        /* 3️⃣ toMap() */
        Map<Integer, String> idToName =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        ));
        System.out.println("toMap: " + idToName);
        //toMap: {1=Ananya, 2=Rohit, 3=Neha, 4=Aman, 5=Priya}

        /* 4️⃣ groupingBy() */
        Map<String, List<Employee>> byDept =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("groupingBy: " + byDept);
        //groupingBy: {Finance=[Priya(Finance, 80000)], HR=[Rohit(HR, 50000), Aman(HR, 60000)], IT=[Ananya(IT, 70000), Neha(IT, 90000)]}

        /* 5️⃣ groupingBy + counting() */
        Map<String, Long> countByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.counting()
                        ));
        System.out.println("groupingBy + counting: " + countByDept);
        //groupingBy + counting: {Finance=1, HR=2, IT=2}

        /* 6️⃣ groupingBy + mapping() */
        Map<String, List<String>> namesByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        ));
        System.out.println("groupingBy + mapping: " + namesByDept);
        //groupingBy + mapping: {Finance=[Priya], HR=[Rohit, Aman], IT=[Ananya, Neha]}

        /* 6️⃣ groupingBy + mapping() */
        Map<String, List<String>> namesByDept2 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getDept(),
                                Collectors.mapping(
                                        e -> e.getName(),
                                        Collectors.toList()
                                )
                        ));
        System.out.println("groupingBy + mapping: " + namesByDept);
        //groupingBy + mapping: {Finance=[Priya], HR=[Rohit, Aman], IT=[Ananya, Neha]}

        /* 7️⃣ partitioningBy() */
        Map<Boolean, List<Employee>> highSalaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() >= 70000
                        ));
        System.out.println("partitioningBy: " + highSalaryPartition);
        //partitioningBy: {false=[Rohit(HR, 50000), Aman(HR, 60000)], true=[Ananya(IT, 70000), Neha(IT, 90000), Priya(Finance, 80000)]}

        /* 8️⃣ counting() */
        long totalEmployees =
                employees.stream()
                        .collect(Collectors.counting());
        System.out.println("counting: " + totalEmployees);
        //counting: 5

        /* 9️⃣ summingInt() */
        int totalSalary =
                employees.stream()
                        .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("summingInt: " + totalSalary);
        //summingInt: 350000

        /* 🔟 averagingInt() */
        double avgSalary =
                employees.stream()
                        .collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println("averagingInt: " + avgSalary);
        //averagingInt: 70000.0

        /* 1️⃣1️⃣ joining() */
        String joinedNames =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining: " + joinedNames);
        //joining: [Ananya, Rohit, Neha, Aman, Priya]

        /* 1️⃣2️⃣ summarizingInt() */
        IntSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println("summarizingInt: " + stats);

        /* 1️⃣3️⃣ maxBy() */
        Optional<Employee> maxSalaryEmp =
                employees.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparingInt(Employee::getSalary)
                        ));
        System.out.println("maxBy: " + maxSalaryEmp.orElse(null));

        /* 1️⃣4️⃣ minBy() */
        Optional<Employee> minSalaryEmp =
                employees.stream()
                        .collect(Collectors.minBy(
                                Comparator.comparingInt(Employee::getSalary)
                        ));
        System.out.println("minBy: " + minSalaryEmp.orElse(null));

        /* 1️⃣5️⃣ collectingAndThen() */
        List<Employee> unmodifiableList =
                employees.stream()
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        ));
        System.out.println("collectingAndThen: " + unmodifiableList);
    }
}
