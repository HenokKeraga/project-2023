import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//open -a TextEdit MainClass.java
public class MainClass {

    public static void main(String[] args) {

      var map = new HashMap<String,String>();

       map.computeIfAbsent("Mongo",k->k+":"+"address");

        System.out.println(map);

        System.out.println(Character.isDigit('4'));
        System.out.println(Character.isLetter('a'));


        var map1 = new HashMap<Integer,String>();

         map1.put(4,"henok");
         map1.put(19,"melesedfadsfasdf");
         map1.put(10,"keraga");

        System.out.println(map1);

         var map2 =new TreeMap<Integer, String>(map1);

       // System.out.println(map2);

        var collect = map2.entrySet()
                .stream()
                .sorted((m1, m2) -> m1.getKey().compareTo(m2.getKey()))
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue(), (k, v) -> k, LinkedHashMap::new));

        System.out.println(collect);


    }

}
