import org.junit.Test;

public class wasd {
    @Test
public void inf (){
    String slovo1 = "привет Петя";
    System.out.println(slovo1);
        String slovo2 = slovo1.replaceAll("." ," " )+"привет Вова";
        System.out.println(slovo2);
        String slovo3 = slovo2.replaceAll("." ," " )+"привет Вася";
        System.out.println(slovo3);
    }

}

