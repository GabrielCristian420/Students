package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        List<String> inLines = Files.readAllLines(Paths.get("studenti_in.txt"));
        List<String> inLines2 = Files.readAllLines(Paths.get("note_anon.txt"));
        Set<Student> studenti = new HashSet<>();

        for (String line : inLines) {
            String[] parts = line.split(",");
            Student s = new Student(
                    Integer.parseInt(parts[0].trim()),
                    0f,
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim()
            );
            studenti.add(s);
        }


        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        for(Student s:studenti){
            System.out.println(s);
        }

        HashMap<Integer,Student> map = new HashMap<>();
        for (Student s : studenti) {
            map.put(s.getNrmatricol(), s);
        }
        for (String line : inLines2) {
            String[] parts = line.split(",");
            int matricol = Integer.parseInt(parts[0].trim());
            float nota = Float.parseFloat(parts[1].trim());

            Student s = map.get(matricol);
            if (s != null) {
                Student cuNota = new Student(s.getNrmatricol(),nota, s.getPrenume(), s.getNume(), s.getFormatieDeStudiu());
                map.put(matricol, cuNota);
            }
        }
        System.out.println(String.format("%14s %22s %20s %10s","numar matricol","prenume nume","formatieDeStudiu","nota"));
            for(Student s :map.values()){
                System.out.println(s);
        }
        /*
        System.out.println(String.format("%14s %20s %16s", "numar matricol", "prenume nume", "formatieDeStudiu"));
        for (Student s : studenti) {
            System.out.println(s);
        }*/
        float notaM = gasesteNota("Bianca", "Popescu", map);
        float notaN = gasesteNota("Ioan", "Popa", map);
        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);

        List<Student> studentiList = new ArrayList<>(studenti);
        Collections.sort(studentiList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int camp1 = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
                if (camp1 == 0) {
                    return s1.getNume().compareTo(s2.getNume());
                }
                return camp1;
            }
        });

        List<String> outLines = new ArrayList<>();
        for (Student s : studentiList) {
            outLines.add(s.getNrmatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
        }

        Files.write(Paths.get("studenti_out_sorted.txt"), outLines);
        Set<StudentBursieri> bursieri = new HashSet<>();
        bursieri.add( new StudentBursieri(1025,"Andrei","Popa","ISM141/2", 8.70f, 725.50));
        bursieri.add( new StudentBursieri(1024,"Ioan","Mihalcea","ISM141/1", 9.80f, 801.10));
        bursieri.add( new StudentBursieri(1026,"Anamaria","Prodan","TI131/1", 8.90f, 745.50));
        bursieri.add( new StudentBursieri(1029,"Bianca","Popescu","TI131/1,", 9.10f, 780.80));
        scriere("bursieri_out.txt", bursieri);
    }
    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu){
        return new Student(st.getNrmatricol(),st.getNota(),st.getPrenume(),st.getNume(),nouaFormatieDeStudiu);
    }
    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String
            formatia2) {
        Set<Student> rezultat=new HashSet<>();
        int half=studenti.size() / 2;
        int count=0;
        for(Student s:studenti){
            if(count<half){
                rezultat.add(schimbaFormatia(s,formatia1));
            }
            else{
                rezultat.add(schimbaFormatia(s,formatia2));
            }
            count++;
        }
        return rezultat;
    }
    public static boolean existaStudent(Set<Student> lista, Student cautat) {
        return lista.contains(cautat);
    }
    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> mapStudenti) {
        HashMap<String, Student> cautareDupaNume = new HashMap<>();
        for (Student s : mapStudenti.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            cautareDupaNume.put(cheie, s);
        }
        String cheieCautata = prenume + "-" + nume;
        Student gasit = cautareDupaNume.get(cheieCautata);
        if (gasit != null) {
            return gasit.getNota();
        } else {
            return 0.0f;
        }
    }
    static void scriere(String filename, Collection<StudentBursieri> studenti) throws IOException {
        List<String> outLines = new ArrayList<>();
        for (Student s : studenti) {
            outLines.add(s.toString());
        }
        Files.write(Paths.get(filename), outLines);
    }
}