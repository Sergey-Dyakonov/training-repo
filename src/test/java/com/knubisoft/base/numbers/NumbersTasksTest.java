package com.knubisoft.base.numbers;

import com.knubisoft.base.numbers.NumbersTasks;
import com.knubisoft.base.numbers.NumbersTasksImpl;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTasksTest {

    NumbersTasks numbersTasks = new NumbersTasksImpl();

    @Test
    void swapTwoNumbersWithoutUsingTemporaryVariableSuccess() {
        NumbersTasksImpl.IntWrapper num1 = new NumbersTasksImpl.IntWrapper(24);
        NumbersTasksImpl.IntWrapper num2 = new NumbersTasksImpl.IntWrapper(68);
        NumbersTasksImpl.IntWrapper num3 = new NumbersTasksImpl.IntWrapper(-8);
        NumbersTasksImpl.IntWrapper num4 = new NumbersTasksImpl.IntWrapper(Integer.MAX_VALUE);
        NumbersTasksImpl.IntWrapper num5 = new NumbersTasksImpl.IntWrapper(Integer.MIN_VALUE);
        NumbersTasksImpl.IntWrapper num6 = new NumbersTasksImpl.IntWrapper(0);

        numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num1, num2);
        assertEquals(68, num1.getValue());
        assertEquals(24, num2.getValue());

        numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num2, num1);
        assertEquals(68, num2.getValue());
        assertEquals(24, num1.getValue());

        numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num3, num6);
        assertEquals(-8, num6.getValue());
        assertEquals(0, num3.getValue());

        numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num4, num5);
        assertEquals(Integer.MIN_VALUE, num4.getValue());
        assertEquals(Integer.MAX_VALUE, num5.getValue());
    }

    @Test
    void swapTwoNumbersWithoutUsingTemporaryVariableFail() {
        NumbersTasksImpl.IntWrapper num1 = new NumbersTasksImpl.IntWrapper(null);
        NumbersTasksImpl.IntWrapper num2 = new NumbersTasksImpl.IntWrapper(68);

        assertThrows(RuntimeException.class,
                () -> numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num1, num2));

        assertThrows(RuntimeException.class,
                () -> numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num2, num1));

        assertThrows(IllegalArgumentException.class,
                () -> numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(null, num2));

        assertThrows(IllegalArgumentException.class,
                () -> numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(num1, null));
    }

    @Test
    void isUglyNumber() {
        assertFalse(numbersTasks.isUglyInt(235));
        assertTrue(numbersTasks.isUglyInt(4));
        assertFalse(numbersTasks.isUglyInt(14));
        assertTrue(numbersTasks.isUglyInt(6));
        assertFalse(numbersTasks.isUglyInt(13));
        assertTrue(numbersTasks.isUglyInt(4500));
        assertFalse(numbersTasks.isUglyInt(Integer.MAX_VALUE));
        assertTrue(numbersTasks.isUglyInt(800));
        assertFalse(numbersTasks.isUglyInt(0));
    }

    @Test
    void addDigits() {
        assertEquals(2, numbersTasks.addDigits(38));
        assertEquals(4, numbersTasks.addDigits(49));
        assertEquals(3, numbersTasks.addDigits(111));
        assertEquals(1, numbersTasks.addDigits(Integer.MAX_VALUE));
        assertEquals(0, numbersTasks.addDigits(0));
        assertEquals(9, numbersTasks.addDigits(999));
        assertEquals(1, numbersTasks.addDigits(10));
        assertEquals(7, numbersTasks.addDigits(1456));
        assertEquals(9, numbersTasks.addDigits(5040));
        assertEquals(4, numbersTasks.addDigits(145768));
    }

    @Test
    void isHarshadNumber() {
        assertTrue(numbersTasks.isHarshadNumber(200));
        assertFalse(numbersTasks.isHarshadNumber(353));
        assertTrue(numbersTasks.isHarshadNumber(171));
        assertFalse(numbersTasks.isHarshadNumber(0));
        assertTrue(numbersTasks.isHarshadNumber(64320));
        assertFalse(numbersTasks.isHarshadNumber(85472));
        assertTrue(numbersTasks.isHarshadNumber(153240));
        assertFalse(numbersTasks.isHarshadNumber(Integer.MAX_VALUE));
        assertTrue(numbersTasks.isHarshadNumber(2889));
        assertFalse(numbersTasks.isHarshadNumber(4666332));
    }

    @Test
    void isPrime() {
        assertTrue(numbersTasks.isPrime(29));
        assertFalse(numbersTasks.isPrime(245));
        assertTrue(numbersTasks.isPrime(17));
        assertFalse(numbersTasks.isPrime(45250));
        assertTrue(numbersTasks.isPrime(Integer.MAX_VALUE));
        assertFalse(numbersTasks.isPrime(11111));
        assertTrue(numbersTasks.isPrime(6857));
        assertFalse(numbersTasks.isPrime(543));
        assertTrue(numbersTasks.isPrime(47));
        assertFalse(numbersTasks.isPrime(561));
    }

    @Test
    void isArmstrongNumber() {
        assertTrue(numbersTasks.isArmstrongNumber(153));
        assertFalse(numbersTasks.isArmstrongNumber(1200));
        assertTrue(numbersTasks.isArmstrongNumber(6));
        assertFalse(numbersTasks.isArmstrongNumber(24678052));
        assertTrue(numbersTasks.isArmstrongNumber(9800817));
        assertFalse(numbersTasks.isArmstrongNumber(50342));
        assertTrue(numbersTasks.isArmstrongNumber(548834));
        assertFalse(numbersTasks.isArmstrongNumber(10));
        assertTrue(numbersTasks.isArmstrongNumber(1));
        assertFalse(numbersTasks.isArmstrongNumber(111));
        assertTrue(numbersTasks.isArmstrongNumber(8208));
    }

    @Test
    void factorial() {
        assertEquals(BigInteger.valueOf(120), numbersTasks.factorial(5));
        assertEquals(new BigInteger("265252859812191058636308480000000"), numbersTasks.factorial(30));
        assertEquals(new BigInteger("1307674368000"), numbersTasks.factorial(15));
        assertEquals(BigInteger.valueOf(1), numbersTasks.factorial(1));
        assertEquals(BigInteger.valueOf(6), numbersTasks.factorial(3));
        assertEquals(BigInteger.valueOf(39916800), numbersTasks.factorial(11));
        assertEquals(new BigInteger("815915283247897734345611269596115894272000000000"), numbersTasks.factorial(40));
        assertEquals(new BigInteger("263130836933693530167218012160000000"), numbersTasks.factorial(32));
        assertEquals(BigInteger.valueOf(362880), numbersTasks.factorial(9));
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"), numbersTasks.factorial(100));
    }

    @Test
    void palindrome() {
        assertTrue(numbersTasks.palindrome(121));
        assertFalse(numbersTasks.palindrome(11111112));
        assertTrue(numbersTasks.palindrome(34543));
        assertFalse(numbersTasks.palindrome(34513));
        assertTrue(numbersTasks.palindrome(545));
        assertFalse(numbersTasks.palindrome(1123552));
        assertTrue(numbersTasks.palindrome(20002));
        assertFalse(numbersTasks.palindrome(1120));
        assertTrue(numbersTasks.palindrome(56788765));
        assertFalse(numbersTasks.palindrome(98));
        assertTrue(numbersTasks.palindrome(48984));
        assertFalse(numbersTasks.palindrome(567));
        assertTrue(numbersTasks.palindrome(567909765));
        assertFalse(numbersTasks.palindrome(21));
        assertTrue(numbersTasks.palindrome(171));
        assertFalse(numbersTasks.palindrome(711));
        assertTrue(numbersTasks.palindrome(1));
    }

    @Test
    void isAutomorphic() {
        assertTrue(numbersTasks.isAutomorphic(5));
        assertFalse(numbersTasks.isAutomorphic(134));
        assertTrue(numbersTasks.isAutomorphic(76));
        assertFalse(numbersTasks.isAutomorphic(2));
        assertTrue(numbersTasks.isAutomorphic(6));
        assertFalse(numbersTasks.isAutomorphic(12));
        assertTrue(numbersTasks.isAutomorphic(890625));
        assertFalse(numbersTasks.isAutomorphic(345));
        assertTrue(numbersTasks.isAutomorphic(25));
        assertFalse(numbersTasks.isAutomorphic(90));
        assertTrue(numbersTasks.isAutomorphic(90625));
        assertTrue(numbersTasks.isAutomorphic(625));
        assertTrue(numbersTasks.isAutomorphic(9376));
    }
}