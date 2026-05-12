package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFiserText implements IStudentiImport {
    private String fileName;
    public StudentiDinFiserText(String filename){
        this.fileName = filename;
    }
    @Override
    public List<Student> doImport() {
        List<Student> students = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(this.fileName));
            for(String line : lines){
                String[] parts = line.split(",");
                if(parts.length >= 5 && !parts[4].trim().isEmpty()) {
                    students.add(new Student(Integer.parseInt(parts[0].trim()), Float.parseFloat(parts[4].trim()), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
