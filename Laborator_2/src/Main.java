import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class Main {
    enum ZileleSaptamanii
    {
        LUNI,
        MARTI,
        MIERCURI,
        JOI,
        VINERI,
        SAMBATA,
        DUMINICA
    }

    public static void main(String[] args) {
        for(ZileleSaptamanii zi : ZileleSaptamanii.values())
        {
            System.out.println(zi);
        }

        List<Integer> lista = new ArrayList<>();
        for(int i = 0; i < 1000; i++)
        {
            lista.add(new Random().nextInt(1000));
            System.out.print(lista.get(i) + " ");
        }

        HashSet hesh = new HashSet<>();
        for(int i = 0; i < 100; i++)
        {
            hesh.add("Test"+i);
        }
        for(Object i : hesh)
        {
            System.out.println(i);
        }


    }
}