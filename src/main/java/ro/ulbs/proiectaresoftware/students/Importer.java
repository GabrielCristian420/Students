package ro.ulbs.proiectaresoftware.students;

import ro.ulbs.proiectaresoftware.students.strategy.IStudentiImport;

import java.util.List;

public class Importer {
    List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}
