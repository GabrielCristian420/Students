package ro.ulbs.proiectaresoftware.students;

public class StudentBursieri extends Student {
    private final double cuantumBursa;
    StudentBursieri(int nrmatricol, String prenume, String nume, String formatieDeStudiu,float nota, double cuantumBursa){
        super(nrmatricol,nota, prenume, nume, formatieDeStudiu);
        this.cuantumBursa = cuantumBursa;
    }
    public double getCuantumBursa() {
        return cuantumBursa;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        StudentBursieri student = (StudentBursieri) o;
        return this.getPrenume().equals(student.getPrenume()) &&
                this.getNume().equals(student.getNume()) &&
                this.getFormatieDeStudiu().equals(student.getFormatieDeStudiu())
                && this.getNota() == student.getNota() && this.cuantumBursa == student.cuantumBursa;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(getNrmatricol(),getPrenume(),getNume(),getFormatieDeStudiu(),getNota(),cuantumBursa);
    }
    public String toString(){
        return String.format("%14d %22s %20s %10.2f %10.2f",this.getNrmatricol(), this.getPrenume()+" " + this.getNume() , this.getFormatieDeStudiu(), this.getNota(),this.cuantumBursa);
    }
}
