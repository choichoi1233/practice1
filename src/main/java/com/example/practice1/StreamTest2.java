package com.example.practice1;

import com.example.practice1.Model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest2 {
    public static void main(String[] arg) {
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            people.add(new Person("Person" + i, i));
        }

        System.out.println("1. 나이가 20세 이상인 사람들만 필터링하여 새로운 리스트를 만드세요.");
        List<Person> list1 = people.stream().filter(n->n.getAge()>=20).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("2. 모든 사람의 나이 합계를 구하세요.");
        int agesum = people.stream().mapToInt(Person::getAge).sum();
        System.out.println(agesum);

        System.out.println("3. 이름에 '5'가 포함된 사람을 찾으세요. 만약 없다면 적절한 처리를 하세요.");
        List<Person> list2 =  people.stream().filter(n->n.getName().contains("5")).collect(Collectors.toList());
        System.out.println(list2.isEmpty() ? "이름에 '5'가 포함된 사람이 없습니다." : list2);

        System.out.println("4. 사람들을 나이 순으로 정렬한 새로운 리스트를 만드세요.");
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(sortedByAge);

        System.out.println("5. 각 사람의 이름 길이를 담은 리스트를 만드세요.");
        List<Integer> lengthlist = people.stream().map(n->n.getName().length()).collect(Collectors.toList());
        System.out.println(lengthlist);

        System.out.println("6. 가장 나이가 많은 사람을 찾으세요. 만약 동일한 나이가 있다면 그 중 아무나 한 명을 선택하세요.");
        Optional<Person> oldestPerson =  people.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println(oldestPerson.orElse(null));

        System.out.println("7. 나이가 10세 미만인 사람이 몇 명인지 세어보세요.");
        long countUnder10 =  people.stream().filter(n->n.getAge()<10).count();
        System.out.println(countUnder10);

        System.out.println("8. 사람들의 이름을 모두 대문자로 변환한 새로운 리스트를 만드세요.");
        List<Person> upperCaseList = people.stream().map(n-> new Person(n.getName().toUpperCase(), n.getAge())).collect(Collectors.toList());
        System.out.println(upperCaseList);

        System.out.println("9. 사람들을 이름의 길이 순으로 정렬한 새로운 리스트를 만드세요.");
        List<Person> sortedByNameLength = people.stream().sorted(Comparator.comparingInt(n->n.getName().length())).collect(Collectors.toList());
        System.out.println(sortedByNameLength);

        System.out.println("10. 이름에 '1'이 포함된 사람들만 필터링하여 새로운 리스트를 만드세요.");
        List<Person> list10 = people.stream().filter(n->n.getName().contains("1")).collect(Collectors.toList());
        System.out.println(list10);

        System.out.println("11. 모든 사람의 나이의 평균을 구하세요.");
        double averageAge = people.stream().mapToInt(n->n.getAge()).average().orElse(Double.NaN);
        System.out.println(averageAge);

        System.out.println("12. 이름에 '3'이 포함된 사람이 있는지 확인하세요.");
        boolean contains3 = people.stream().anyMatch(n->n.getName().contains("3"));
        System.out.println(contains3 ? "이름에 '3'이 포함된 사람이 있습니다." : "이름에 '3'이 포함된 사람이 없습니다.");

        System.out.println("13. 사람들을 이름의 역순으로 정렬한 새로운 리스트를 만드세요.");
        List<Person> reverseSortedByName = people.stream().sorted(Comparator.comparing(Person::getName).reversed()).collect(Collectors.toList());
        System.out.println(reverseSortedByName);

        System.out.println("14. 각 사람의 나이를 2배로 늘린 값을 담은 리스트를 만드세요.");
        List<Person> doubleAgeList = people.stream().map(n-> new Person(n.getName(), n.getAge() * 2)).collect(Collectors.toList());
        System.out.println(doubleAgeList);

        System.out.println("15. 가장 나이가 적은 사람을 찾으세요. 만약 동일한 나이가 있다면 그 중 아무나 한 명을 선택하세요.");
        Optional<Person> youngestPerson = people.stream().min(Comparator.comparingInt(Person::getAge));
        System.out.println(youngestPerson.orElse(null));

        System.out.println("16. 나이가 15세 이상인 사람이 몇 명인지 세어보세요.");
        long countOver15 = people.stream().filter(n->n.getAge()>=15).count();
        System.out.println(countOver15);

        System.out.println("17. 사람들의 이름을 모두 소문자로 변환한 새로운 리스트를 만드세요.");
        List<Person> lowerCaseList = people.stream().map(n-> new Person(n.getName().toLowerCase(), n.getAge())).collect(Collectors.toList());
        System.out.println(lowerCaseList);
    }
}
