package ro.ulbs.proiectaresoftware.students;

import ro.ulbs.proiectaresoftware.students.strategy.IStudentiExport;

import java.util.List;

public class Exporter {
    void startExport(IStudentiExport strategyInstance, List<Student> students){
        strategyInstance.doExport(students);
    }
}
