package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws IOException {
        List<String> inLines = Files.readAllLines(Paths.get("studenti_in.txt"));
        List<Student> studenti = new ArrayList<>();

        for (String line : inLines) {
            String[] parts = line.split(",");
            Student s = new Student(
                    Integer.parseInt(parts[0].trim()),
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim()
            );
            studenti.add(s);
        }

        System.out.println(String.format("%14s %20s %16s", "numar matricol", "prenume nume", "formatieDeStudiu"));
        for (Student s : studenti) {
            System.out.println(s);
        }

        Collections.sort(studenti, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getNume().compareTo(s2.getNume());
            }
        });

        List<String> outLines = new ArrayList<>();
        for (Student s : studenti) {
            outLines.add(s.getNrmatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
        }

        Files.write(Paths.get("studenti_out.txt"), outLines);
    }

    public static boolean existaStudent(Set<Student> lista, Student cautat) {
        return lista.contains(cautat);
    }
}
