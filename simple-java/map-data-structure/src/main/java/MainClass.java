import java.util.HashMap;

//open -a TextEdit MainClass.java
public class MainClass {

    public static void main(String[] args) {

      var map = new HashMap<String,String>();

       map.computeIfAbsent("Mongo",k->k+":"+"address");

        System.out.println(map);
    }
}
