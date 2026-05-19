package ro.ulbs.proiectaresoftware.students;

import ro.ulbs.proiectaresoftware.students.strategy.*;
import ro.ulbs.proiectaresoftware.students.decorator.*;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    static void main(String args[]){
        List<Student> studentiCuNote= Arrays.asList(
                new Student(1025,8.70f,"Andrei","Popa","ISM141/2" ),
                new Student(1024,10f,"Ioan","Mihalcea","ISM141/1"),
                new Student(1026, 8.90f,"Anamaria","Prodan","TI131/1"),
                new Student(1029,10f,"Bianca","Popescu","TI131/1" ),
                new Student(1029,4.10f,"Maria","Pana","TI131/," ),
                new Student(1029,7.33f,"Gabriela","Mohanu","TI131/2" ),
                new Student(1029,3.20f,"Marius","Nasta","TI131/2" ),
                new Student(1029,5.12f,"Marius","Nasta","TI131/1" ),
                new Student(1029,2.22f,"Andrei","Dobrescu","TI131/2" )
        );
        List<IStudentiExport> strategies=Arrays.asList(
                new StudentiInConsola(),
                new StudentiInFisierText("studentiStrategyText.txt"),
                new StudentiInFisierXlsx("studentiStrategyExcel.xlsx")
        );

        for(IStudentiExport strategy : strategies){
            TimeExecutionDecorator decorator=new TimeExecutionDecorator(strategy,studentiCuNote);
            long time=decorator.executionTime();
            System.out.println("Execution time: "+ time + " for "+strategy);
        }
    }
}
