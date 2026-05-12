package ro.ulbs.proiectaresoftware.students;
import java.util.*;

public class AplicatieCuStrategy {
    public static void main(String[] args){
        List<Student> studenti = Arrays.asList(
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
        Exporter exporter = new Exporter();
        // a
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole,studenti);
        // b
        String fileNameTxt = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);
        // c
        String fileNameXlsx = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(strategyFisierExcel, studenti);


        Importer importer = new Importer();
        // d
        IStudentiImport citireTxt = new StudentiDinFiserText(fileNameTxt);
        List<Student> studentiTxt = importer.startImport(citireTxt);
        // e
        IStudentiImport citireXlsx = new StudentiDinFiserXlsx(fileNameXlsx);
        List<Student> studentiXlsx = importer.startImport(citireXlsx);
    }
}
