package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(){
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        List<Student> studenti = new ArrayList<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);
        System.out.println(String.format("%14s %20s %16s", "numar matricol", "prenume nume", "formatieDeStudiu"));
        for(Student s : studenti){
            System.out.println(s);
        }
        Student cautat=new Student(120, "Alis", "Popa", "TI21/2");
        Student cautat2=new Student(112, "Maria", "Popa", "TI21/1");
        if(existaStudent(studenti,cautat)){
            System.out.println("Studentul Alis Popa TI21/2 exista");
        }
        else{
            System.out.println("Studentul Alis Popa TI21/2 nu exista");
        }
        if(existaStudent(studenti,cautat2)){
            System.out.println("Studentul Maria Popa TI21/1 exista");
        }
        else{
            System.out.println("Studentul Maria Popa TI21/1 nu exista");
        }
    }
    public static boolean existaStudent(List<Student> lista, Student cautat) {
        for (Student s : lista) {
            if (s.getPrenume().equals(cautat.getPrenume()) &&
                    s.getNume().equals(cautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }
}
