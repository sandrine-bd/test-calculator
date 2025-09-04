package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    public void testAdd(){
        // ARRANGE (GIVEN)
        Calculator target = new Calculator();
        // ACT (WHEN)
        int result = target.add(1, 2);
        // ASSERT (THEN)
        Assertions.assertEquals(3, result);
        // WOW
        Assertions.assertEquals((new Calculator()).add(1,2), result);
    }

    @Test
    public void test_Substract(){
        Calculator target = new Calculator();
        int result = target.sub(9,3);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void test_Multiply(){
        Calculator target = new Calculator();
        int result = target.mul(2,7);
        Assertions.assertEquals(14, result);
    }

    @Test
    public void test_Add_Max_Int_Value(){
        Calculator target = new Calculator();
        Assertions.assertEquals(Integer.MAX_VALUE * -1 - 1, target.add(Integer.MAX_VALUE,1));
    }

    @Test
    public void test_Div(){
        Calculator target = new Calculator();
        double result = target.div(9,3);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void test_Div_ByZero(){
        Calculator target = new Calculator();
        try {
            double result = target.div(9,0);
            Assertions.fail();
        }
        catch (ArithmeticException e)
        {
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
        catch (Exception ex){
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Division by O should throw an exception")
    public void test_Div_ByZero_Assert(){
        Calculator target = new Calculator();
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            double result = target.div(9,0);
        });

        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Division should return a double")
    public void test_Div_Double() {
        Calculator target = new Calculator();
        double result = target.div(10, 3);
        //System.out.println(result);
        Assertions.assertEquals(3.33333, result, 0.00001);
    }

    @ParameterizedTest(name = "Test {0} + {1} = {2}")
    @DisplayName("Test addition")
    //@ValueSource(ints = {1,2,3,4})
    @CsvSource({"1,2,3", "4,5,9", "10000,5,10005"})
    // https://www.baeldung.com/parameterized-tests-junit-5
    public void test_add_with_parameters(int a, int b, int result) {
        Calculator target = new Calculator();
        Assertions.assertEquals(target.add(a, b), result, 0.00001);
    }

    // Pourquoi ne pas avoir fait des méthodes statiques ? => Si on veut par exemple avoir un historique des calculs réalisés

    // https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
    private List<String> list;

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each - init");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each - teardown");
        list.clear();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
        System.out.println(calculator.add(3,2 ));
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }
}