import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.*;

public class CalculatorTests {

    Calculator calculator = Calculator.instance.get();

    @Test
    public void testPlus() {

        // given:
        int a = 2;
        int b = 5;
        int exp = 7;

        // when:
        int result = calculator.plus.apply(a, b);

        // then:
        Assertions.assertEquals(exp, result);

    }

    @Test
    public void testIsPositive() {

        // given:
        int a = 265;

        // when:
        boolean result = calculator.isPositive.test(a);

        // then:
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsNotPositive() {

        // given:
        int a = -265;

        // when:
        boolean result = calculator.isPositive.test(a);

        // then:
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("absArguments")
    public void paramTestAbs(int a) {

        // when:
        int result = calculator.abs.apply(a);

        // then:
        Assertions.assertTrue(result >= 0);
    }

    public static int[] absArguments() {
        return new int[]{2, 5, -12, 24, -44, -65, 0};
    }

    @Test
    public void testDevideByZero() {
        // given:
        int a = -265;
        int b = 0;

        // when:
        Executable executable = () -> calculator.devide.apply(a, b);

        // then:
        Assertions.assertDoesNotThrow(executable);
    }

}
