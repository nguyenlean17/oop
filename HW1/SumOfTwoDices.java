//Exercise 20, 1.2 IPIJ
import java.util.Random;
public class SumOfTwoDices {
    public static void main(String[] args) {
        Random dice = new Random();
        System.out.println(dice.nextInt(6) + 1 + dice.nextInt(6) + 1);
    }
}
