package ArrayListTests;

import org.example.ArrayList;
import org.example.BubbleSortForArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

public class MainFunctionsTest {
    @Test
    public void addIntegerTest1() {
        ArrayList<Integer> intList1 = new ArrayList<>();
        intList1.add(52);
        intList1.add(104);
        intList1.add(2);
        intList1.add(1);
        System.out.println(intList1.toString());
        List<Integer> res = new LinkedList<>();
        res.add(52);
        res.add(104);
        res.add(2);
        res.add(1);
        Assertions.assertTrue(intList1.equals(res));

    }

    @Test
    public void removeIntegerTest1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(52);
        list.add(104);
        list.add(2);
        list.add(1);
        list.remove(3);
        System.out.println(list.toString());
        List<Integer> res = new LinkedList<>();
        res.add(52);
        res.add(104);
        res.add(2);
        Assertions.assertTrue(list.equals(res));
    }

    @Test
    public void addStringTest1() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("ABBBA");
        stringList.add("TTTTT");

        System.out.println(stringList.toString());
        List<String> res = new LinkedList<>();
        res.add("ABBBA");
        res.add("TTTTT");
        Assertions.assertTrue(stringList.equals(res));
    }

    @Test
    public void addAllTest1() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(54);
        linkedList.add(104);


        list.addAll(linkedList);
        System.out.println(list.toString());

        Assertions.assertTrue(list.equals(linkedList));
    }

    @Test
    public void getTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(52);
        list.add(104);
        list.add(2);
        list.add(1);

        Assertions.assertTrue(list.get(0) == 52);
    }

    @Test
    public void bubbleSortTest() {
        BubbleSortForArrayList<Integer> bblSort = new BubbleSortForArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(52);
        list.add(104);
        list.add(2);
        list.add(1);
        bblSort.bubbleSortWithFlag(list);

        List<Integer> res = new java.util.ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(52);
        res.add(104);
        Assertions.assertTrue(list.equals(res));
    }


    @Test
    public void bubbleSortSortedTest() {
        BubbleSortForArrayList<Integer> bblSort = new BubbleSortForArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(52);
        list.add(104);
        bblSort.bubbleSortWithFlag(list);

        List<Integer> res = new java.util.ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(52);
        res.add(104);
        Assertions.assertTrue(list.equals(res));
    }

}
