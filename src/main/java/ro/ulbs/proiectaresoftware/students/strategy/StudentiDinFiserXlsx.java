package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Application;
import ro.ulbs.proiectaresoftware.students.Student;

public class StudentiDinFiserXlsx implements IStudentiImport {
    private String fileName;
    public StudentiDinFiserXlsx(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public java.util.List<Student> doImport() {
        return Application.readFromXls(fileName);
    }
}
