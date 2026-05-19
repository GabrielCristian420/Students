package ro.ulbs.proiectaresoftware.students.decorator;
import ro.ulbs.proiectaresoftware.students.*;
import ro.ulbs.proiectaresoftware.students.strategy.*;

import java.util.List;

public class TimeExecution implements ITimeExecution {
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        exporter.doExport(studenti);
        return System.currentTimeMillis() - startTime;
    }


}
