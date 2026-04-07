package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.*;
import java.util.List;

public class AplicatieCuBursaTest {

    private AplicatieCuBursa aplicatieCuBursa;

    @BeforeEach
    void setUp() {
        aplicatieCuBursa = new AplicatieCuBursa();
    }

    @Test
    void testSortare() {
        List<StudentBursieri> lista = aplicatieCuBursa.genereaza();

        List<StudentBursieri> sortata = aplicatieCuBursa.sorteaza(lista);

        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursieri s1 = sortata.get(i);
            StudentBursieri s2 = sortata.get(i + 1);
            int cmp = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            if (cmp == 0) {
                cmp = s1.getNume().compareTo(s2.getNume());
                if (cmp == 0) {
                    cmp = s1.getPrenume().compareTo(s2.getPrenume());
                    if (cmp == 0) {
                        cmp = Double.compare(s1.getNota(), s2.getNota());
                        if (cmp == 0) {
                            cmp = Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa());
                        }
                    }
                }
            }
            Assertions.assertTrue(cmp <= 0, "Lista nu este sortată corect!");
        }
    }
}
