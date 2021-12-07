package com.company;

import java.util.*;

public class Student implements Comparable<Student> {
 private String surname;
 private ArrayList<Float> gradeList = new ArrayList<>();
 private EnumMap<Subjects,List<Float>> schoolDiary = new EnumMap<>(Subjects.class);
 private static HashMap<String,Float> diary = new HashMap<>();
 private Set<Student> set = new TreeSet();

    Student(String Surname,Float Grade1,Float Grade2)
    {
        surname = Surname;
        gradeList.add(Grade1);
        gradeList.add(Grade2);
        diary.put(Surname,getMidGrade());
        set.add(this);
    }
    Student(String Surname,Float Grade1)
    {
        surname = Surname;
        gradeList.add(Grade1);
        diary.put(Surname,getMidGrade());
        set.add(this);
    }
    public void addGrade(Subjects subject,float grade1)
    {
        if(grade1 > 0 && grade1 < 7) {
            gradeList.add(grade1);
            schoolDiary.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade1);
        }
        else return;
        diary.put(this.surname,getMidGrade());
    }

   public void addGrade(Subjects subject ,float grade1, float grade2)
    {
        if(grade1 > 0 && grade1 < 7 && grade2 > 0 && grade2 < 7) {
            gradeList.add(grade1);
            gradeList.add(grade2);
            schoolDiary.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade1);
            schoolDiary.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade2);
        }
        else return;
        diary.put(this.surname,getMidGrade());
    }

    public float getMidGrade()
    {
        float tmp = 0f;
        for (int i = 0; i < gradeList.size();i++)
        {
             tmp += gradeList.get(i);
        }
        return tmp / gradeList.size();
    }
    public void getSchoolDiary()
    {
        for(Map.Entry m: schoolDiary.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
    public static float MidGrade(String surname)
    {
        return diary.get(surname);
    }
    public static void readDiary()
    {
        for(Map.Entry entry : diary.entrySet())
        {
            System.out.println("Student surname: " + entry.getKey() + "\n" +
                    "Student grade: " + entry.getValue());
        }
    }
    public void readTreeSet()
    {
        System.out.println(set);
    }

    @Override
    public String toString() {
        return
                "Surname: " + surname + "\n" +
                "Grades: " + gradeList + "\n" +
                "MidGrade: " + MidGrade(this.surname);
    }


    public int compareTo(Student student) {
        if(Math.round(student.getMidGrade()) == Math.round(this.getMidGrade()))
            return 1;
        return Math.round(student.getMidGrade()) - Math.round(this.getMidGrade());
    }
}
