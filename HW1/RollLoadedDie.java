//Exercise 6, 1.3 IPIJ
import java.util.Random;

public class RollLoadedDie {
    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(8); 
        int result;
        if (r < 5) {
            result = r + 1;  
        } else {
            result = 6;    
        }

        System.out.println(result);
    }
}
