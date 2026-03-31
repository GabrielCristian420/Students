package ro.ulbs.proiectaresoftware.students;

public class StudentBursieri extends Student {
    double cuantumBursa;
    StudentBursieri(int nrmatricol, String prenume, String nume, String formatieDeStudiu,float nota, double cuantumBursa){
        super(nrmatricol, prenume, nume, formatieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        StudentBursieri student = (StudentBursieri) o;
        return this.prenume.equals(student.prenume) &&
                this.nume.equals(student.nume) &&
                this.formatieDeStudiu.equals(student.formatieDeStudiu)
                && this.nota == student.nota && this.cuantumBursa == student.cuantumBursa;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(prenume,nume,formatieDeStudiu,nota,cuantumBursa);
    }
    public String toString(){
        return String.format("%14d %22s %20s %10.2f %10.2f",this.nrmatricol, this.prenume+" " + this.nume , this.formatieDeStudiu, this.nota,this.cuantumBursa);
    }
}
