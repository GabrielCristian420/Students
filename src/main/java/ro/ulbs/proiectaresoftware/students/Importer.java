package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public class Importer {
    List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}
