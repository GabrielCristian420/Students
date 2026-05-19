package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(java.util.List<Student> studenti) {
        for(Student student: studenti){
            System.out.println(student);
        }
    }

}
