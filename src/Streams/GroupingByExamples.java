package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByExamples {

    static class Employee {
        int id;
        String name;
        String dept;
        int salary;
        List<String> skills;

        Employee(int id, String name, String dept, int salary, List<String> skills) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
            this.skills = skills;
        }

        public String getDept() { return dept; }
        public String getName() { return name; }
        public int getSalary() { return salary; }
        public List<String> getSkills() { return skills; }

        @Override
        public String toString() {
            return name + "(" + dept + ", " + salary + ")";
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Ananya", "IT", 80000, List.of("Java", "Spring")),
                new Employee(2, "Rahul", "HR", 50000, List.of("Hiring")),
                new Employee(3, "Neha", "IT", 90000, List.of("Java", "AWS")),
                new Employee(4, "Amit", "Finance", 70000, List.of("Excel")),
                new Employee(5, "Sneha", "IT", 85000, List.of("Spring", "Docker"))
        );

        // 1️⃣ groupingBy → List
        Map<String, List<Employee>> byDept =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept));
        //By Dept: {Finance=[Amit(Finance, 70000)], HR=[Rahul(HR, 50000)], IT=[Ananya(IT, 80000), Neha(IT, 90000), Sneha(IT, 85000)]}

        // 2️⃣ groupingBy + counting
        Map<String, Long> countByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.counting()
                        ));
        //Count By Dept: {Finance=1, HR=1, IT=3}

        // 3️⃣ groupingBy + summingInt
        Map<String, Integer> salaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.summingInt(Employee::getSalary)
                        ));
        //Salary By Dept: {Finance=70000, HR=50000, IT=255000}

        // 4️⃣ groupingBy + averagingInt
        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.averagingInt(Employee::getSalary)
                        ));
        //Avg Salary By Dept: {Finance=70000.0, HR=50000.0, IT=85000.0}

        // 5️⃣ groupingBy + mapping
        Map<String, List<String>> namesByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        ));
        //Names By Dept: {Finance=[Amit], HR=[Rahul], IT=[Ananya, Neha, Sneha]}

        // 6️⃣ groupingBy + maxBy
        Map<String, Optional<Employee>> highestPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary)
                                )
                        ));
        //Highest Paid By Dept: {Finance=Optional[Amit(Finance, 70000)], HR=Optional[Rahul(HR, 50000)], IT=Optional[Neha(IT, 90000)]}

        // 7️⃣ groupingBy + collectingAndThen
        Map<String, Integer> deptSizeAsInt =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        ));
        //Dept Size Int: {Finance=1, HR=1, IT=3}

        // 8️⃣ groupingBy + summarizingInt
        Map<String, IntSummaryStatistics> salaryStatsByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.summarizingInt(Employee::getSalary)
                        ));
        //Salary Stats: {Finance=IntSummaryStatistics{count=1, sum=70000, min=70000, average=70000.000000, max=70000}, HR=IntSummaryStatistics{count=1, sum=50000, min=50000, average=50000.000000, max=50000}, IT=IntSummaryStatistics{count=3, sum=255000, min=80000, average=85000.000000, max=90000}}

        // 9️⃣ groupingBy + flatMapping (Java 9+)
        Map<String, Set<String>> skillsByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.flatMapping(
                                        e -> e.getSkills().stream(),
                                        Collectors.toSet()
                                )
                        ));
        //Skills By Dept: {Finance=[Excel], HR=[Hiring], IT=[Java, Docker, Spring, AWS]}

        // 🔟 groupingBy with custom Map
        Map<String, List<Employee>> byDeptTreeMap =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                TreeMap::new,
                                Collectors.toList()
                        ));
        //TreeMap Grouping: {Finance=[Amit(Finance, 70000)], HR=[Rahul(HR, 50000)], IT=[Ananya(IT, 80000), Neha(IT, 90000), Sneha(IT, 85000)]}


        // Print outputs (optional)
        System.out.println("By Dept: " + byDept);
        System.out.println("Count By Dept: " + countByDept);
        System.out.println("Salary By Dept: " + salaryByDept);
        System.out.println("Avg Salary By Dept: " + avgSalaryByDept);
        System.out.println("Names By Dept: " + namesByDept);
        System.out.println("Highest Paid By Dept: " + highestPaidByDept);
        System.out.println("Dept Size Int: " + deptSizeAsInt);
        System.out.println("Salary Stats: " + salaryStatsByDept);
        System.out.println("Skills By Dept: " + skillsByDept);
        System.out.println("TreeMap Grouping: " + byDeptTreeMap);
    }
}
