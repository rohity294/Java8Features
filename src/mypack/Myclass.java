package mypack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Myclass {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "sachin", 25);
        Employee emp2 = new Employee(2, "saurav", 30);
        Employee emp3 = new Employee(3, "harsimran", 35);

        List<Employee> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);

        double avg = empList.stream().mapToInt((e) -> e.getAge()).average().getAsDouble();
        //System.out.println("average is:" + avg);

        double avg2 = empList.parallelStream().mapToInt((e) -> e.getAge()).average().getAsDouble();
        //System.out.println("average is:" + avg);

        //System.out.println(empList.stream().map((e)->e.getName()).reduce("",(allNamesCombined,name)->allNamesCombined+"\t"+name));

        //System.out.println(empList.stream().map((e)->e.getAge()).reduce(0,(totalAge,age)->totalAge+age));

        //System.out.println(empList.stream().map((e)->e.getAge()).reduce(0,Integer::sum));

        List<Employee> empList2 = Arrays.asList(
                new Employee(1, "Aafael", 30),
                new Employee(2, "Bafael", 60),
                new Employee(3, "Cafael", 30),
                new Employee(4, "Dafael", 30),
                new Employee(5, "Eafael", 61),
                new Employee(6, "Fafael", 32),
                new Employee(7, "Gafael", 32),
                new Employee(8, "Hafael", 32),
                new Employee(9, "Iafael", 32),
                new Employee(10, "Jafael", 65)
        );

        List<Employee> seniorEmpList = empList2.stream().filter((e) -> e.getAge() >= 60).collect(Collectors.toList());

//        for(Employee e:seniorEmpList){
//            System.out.println(e);
//        }

        List<String> mylist = Arrays.asList(
                "2022-01-10:popcorn:2",//14
                "2022-01-15:soda:1",//3
                "2022-01-20:popcorn:2",//18
                "2022-01-20:soda:3"//3
                //totalPrice = 38;
        );

        Map<String, List<String>> groupedList = mylist.stream().collect(Collectors.groupingBy(item -> item.split(":")[0]));


        int totalPrice = 0;

        for (Map.Entry me : groupedList.entrySet()) {
//            System.out.println(me.getKey());
            System.out.println(me.getValue());
//[2022-01-15:soda:1]
//[2022-01-10:popcorn:2]
//[2022-01-20:popcorn:2, 2022-01-20:soda:3]
        }
    }
}

