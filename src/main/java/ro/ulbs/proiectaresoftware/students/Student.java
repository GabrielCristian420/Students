package ro.ulbs.proiectaresoftware.students;

public class Student {
    int nrmatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
    Student(int nrmatricol, String prenume, String nume, String formatieDeStudiu){
        this.nrmatricol = nrmatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    public int getNrmatricol(){
        return this.nrmatricol;
    }
    public String getPrenume(){
        return this.prenume;
    }
    public String getNume(){
        return this.nume;
    }
    public String getFormatieDeStudiu(){
        return this.formatieDeStudiu;
    }
    @Override
    public String toString(){
        return String.format("%14d %20s %8s",this.nrmatricol, this.prenume+" " + this.nume , this.formatieDeStudiu);
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Student student = (Student) o;
        return this.prenume.equals(student.prenume) &&
                this.nume.equals(student.nume) &&
                this.formatieDeStudiu.equals(student.formatieDeStudiu);
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(prenume,nume,formatieDeStudiu);
    }
}
