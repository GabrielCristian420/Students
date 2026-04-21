package ro.ulbs.proiectaresoftware.students;

public class Student {
    private final int nrmatricol;
    private final float nota;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    Student(int nrmatricol,float nota, String prenume, String nume, String formatieDeStudiu){
        this.nrmatricol = nrmatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota=nota;
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

    public float getNota(){
        return this.nota;
    }
    @Override
    public String toString(){
        return String.format("%14d %22s %20s %10.2f",this.nrmatricol, this.prenume+" " + this.nume , this.formatieDeStudiu, this.nota);
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Student student = (Student) o;
        return this.nrmatricol == student.nrmatricol &&
                this.prenume.equals(student.prenume) &&
                this.nume.equals(student.nume) &&
                this.formatieDeStudiu.equals(student.formatieDeStudiu)
                && this.nota == student.nota;
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(nrmatricol,prenume,nume,formatieDeStudiu,nota);
    }
}
