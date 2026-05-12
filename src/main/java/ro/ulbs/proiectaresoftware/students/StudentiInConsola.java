package ro.ulbs.proiectaresoftware.students;

public class StudentiInConsola implements  IStudentiExport {
    @Override
    public void doExport(java.util.List<Student> studenti) {
        for(Student student: studenti){
            System.out.println(student);
        }
    }

}
