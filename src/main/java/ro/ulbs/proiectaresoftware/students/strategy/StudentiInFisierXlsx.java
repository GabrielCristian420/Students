package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Application;
import ro.ulbs.proiectaresoftware.students.Student;

import java.util.HashSet;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String filename) {
        this.fileName = filename;
    }

    @Override
    public void doExport(java.util.List<Student> studenti) {
        Application.writeToXls(new HashSet<>(studenti), fileName);
    }

}
