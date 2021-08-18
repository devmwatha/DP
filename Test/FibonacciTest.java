import main.Fibonacci.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FibonacciTest {

    @Test
    void calculateFibonacci() {
        int ans = Fibonacci.calculateFibonacci(7);
        System.out.println(ans);
        Assertions.assertEquals(ans, ans);
    }

    @Test
    void calculateBottomUp(){
        int ans = Fibonacci.calculateFibBottomUp(7);
        Assertions.assertEquals(ans, ans);
    }
}