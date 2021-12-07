package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        var A = new Student("A",5f);
        var B = new Student("B",4f,4f);
        A.addGrade(Subjects.MATH,3f);
        A.addGrade(Subjects.MATH,4f);
        A.addGrade(Subjects.PE,5f);
        System.out.println(A);
        A.getSchoolDiary();
        System.out.println(B);



    }
}
