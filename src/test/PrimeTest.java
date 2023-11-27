package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Prime;

public class PrimeTest {

	Prime prime;

	@BeforeEach
	void initPrime() {
		prime = new Prime();
	}

	@Test
	@DisplayName("Amount of primes between 0-1000")
	void amountOfPrimes() {
		prime.calculatePrimes(0, 1000);
		int primes = prime.getPrimes().size();
		int expectedPrimeCount = 168;
		assertEquals(expectedPrimeCount, primes);
	}

	@Test
	@DisplayName("Sum of all primes between 0-1000")
	void sumOfAllPrimes() {
		assertEquals(76127, prime.calculatePrimes(0, 1000));
	}

	@Test
	@DisplayName("Test user input wrong format")
	void testUserInputFormat() {
		String data = "a\nb\n";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		assertEquals(-1, prime.getUserInput());
	}

	@Test
	@DisplayName("Test user input wrong intervall")
	void testUserWrongIntervall() {
		String data = "-1\n1001\n";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		assertEquals(-1, prime.getUserInput());
	}

	@Test
	@DisplayName("Test user input for interval between 0 and 1000")
	void testUserRightIntervall() {
		InputStream in = new ByteArrayInputStream("0\n1000\n".getBytes());
		System.setIn(in);
		assertEquals(168, prime.getUserInput());
	}

}
