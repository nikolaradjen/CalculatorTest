package calc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalculatorTest {

	protected static SoftAssert sa = new SoftAssert();
	protected static Calculator calc = new Calculator();
	protected static double[] addNumber = { -5.0, -4.5, 0.0, 4.2, 6.0 };
	protected static double[] divNumber = { -3.3, -0.5, 4.14, 12.0 };

	@BeforeMethod

	public void resetValue() {
		calc.setValue(0);
	}

	@Test
	public void addTest() {
		double expected = 0d;
		for (int i = 0; i < addNumber.length; i++) {
			calc.add(addNumber[i]);
			expected += addNumber[i];
			sa.assertEquals(calc.getValue(), expected);
		}
		sa.assertAll();

	}

	@Test
	public void divZeroWithNumber() {

		for (int i = 0; i < divNumber.length; i++) {
			calc.div(divNumber[i]);
			double current = Math.abs(calc.getValue());
			sa.assertEquals(current, 0.00);

		}
		sa.assertAll();

	}

	@Test
	public void divNumberWithNumber() {
		double number = 10.0;
		for (int i = 0; i < divNumber.length; i++) {
			calc.setValue(number);
			calc.div(divNumber[i]);
			sa.assertEquals(calc.getValue(), number / divNumber[i]);

		}
		sa.assertAll();
	}

	@Test
	public void divNumWithZero() {
		double number = 10.0;
		calc.setValue(number);
		calc.div(0);
		Assert.assertEquals(calc.getValue(), Double.NaN);

	}

	@Test
	public void divZeroWithZero() {
		calc.div(0);
		Assert.assertEquals(calc.getValue(), 0.0);

	}
}
