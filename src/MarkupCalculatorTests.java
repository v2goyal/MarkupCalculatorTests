import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MarkupCalculatorTests {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	// Calls get_people_markup, should return valid values for all cases
	public void testGetTotalPeopleMarkupShouldReturnValidValues() {
		assertEquals(0, MarkupCalculator.get_people_markup(0), 0.001);
		assertEquals(0.012, MarkupCalculator.get_people_markup(1), 0.001);
		assertEquals(0.060, MarkupCalculator.get_people_markup(5), 0.001);
	}

	@Test
	// Calls get_people_markup, should throw an exception for all cases
	public void testGetTotalPeopleMarkupShouldRaiseException() {
		exception.expect(IllegalArgumentException.class);

		MarkupCalculator.get_people_markup(-1);
		MarkupCalculator.get_people_markup(-10);
		MarkupCalculator.get_people_markup(-20);
	}

	@Test
	// Calls get_category_rate, should throw an exception for all cases
	public void testGetCategoryMarkupShouldReturnValidValues() {
		assertEquals(
				0.075,
				MarkupCalculator.get_category_rate(MarkupCalculator.Category.PHARMACEUTICAL),
				0.00001);
		assertEquals(
				0.13,
				MarkupCalculator.get_category_rate(MarkupCalculator.Category.FOOD),
				0.00001);
		assertEquals(
				0.02,
				MarkupCalculator.get_category_rate(MarkupCalculator.Category.ELECTRONICS),
				0.00001);
		assertEquals(
				0.0,
				MarkupCalculator.get_category_rate(MarkupCalculator.Category.OTHERS),
				0.00001);
	}
	
	@Test
	// Calls get_category_rate, should throw an exception for all cases
	public void testGetCategoryCalculateFinalPriceShouldIncludeMarkups() {
		assertEquals(
				1591.58,
				MarkupCalculator.calculateFinalPrice(1299.99, MarkupCalculator.Category.FOOD, 3),
				0.01);
		
		assertEquals(
				6199.81,
				MarkupCalculator.calculateFinalPrice(5432.00, MarkupCalculator.Category.PHARMACEUTICAL, 1),
				0.01);
		
		assertEquals(
				13707.63,
				MarkupCalculator.calculateFinalPrice(12456.95, MarkupCalculator.Category.OTHERS, 4),
				0.01);

	}
}
