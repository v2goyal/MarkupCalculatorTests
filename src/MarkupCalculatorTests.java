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
		assertEquals("get_people_markup - Number of people involved 0 : ", 0.00,
				MarkupCalculator.get_people_markup(0), 0.00001);
		assertEquals("get_people_markup - Number of people involved 1 : ", 0.012,
				MarkupCalculator.get_people_markup(1), 0.00001);
		assertEquals("get_people_markup - Number of people involved 5 : ", 0.060,
				MarkupCalculator.get_people_markup(5), 0.00001);
	}

	@Test
	// Calls get_people_markup, should throw an exception for a negative case
	public void testGetTotalPeopleMarkupShouldRaiseException() {
		exception.expect(IllegalArgumentException.class);
		MarkupCalculator.get_people_markup(-1);
	}

	@Test
	// Calls get_category_rate, should throw an exception for all cases
	public void testGetCategoryMarkupShouldReturnValidValues() {
		assertEquals(
				"get_category_rate - Category Pharmaceutical - ",
				0.075,
				MarkupCalculator
						.get_category_rate(MarkupCalculator.Category.PHARMACEUTICAL),
				0.00001);
		assertEquals("get_category_rate - Category Food - ", 0.13,
				MarkupCalculator
						.get_category_rate(MarkupCalculator.Category.FOOD),
				0.00001);
		assertEquals(
				"get_category_rate - Category Electronics - ",
				0.02,
				MarkupCalculator
						.get_category_rate(MarkupCalculator.Category.ELECTRONICS),
				0.00001);
		assertEquals("get_category_rate - Category Everything Else - ", 0.0,
				MarkupCalculator
						.get_category_rate(MarkupCalculator.Category.OTHERS),
				0.00001);
	}

	@Test
	// Calls get_category_rate, should throw an exception for all cases
	public void testGetCategoryCalculateFinalPriceShouldIncludeMarkups() {
		assertEquals("calculateFinalPrice - 1299.99 Food 3 People - ", 1591.58,
				MarkupCalculator.calculateFinalPrice(1299.99,
						MarkupCalculator.Category.FOOD, 3), 0.01);

		assertEquals("calculateFinalPrice - 5432.00 Drugs 1 Person - ", 6199.81,
				MarkupCalculator.calculateFinalPrice(5432.00,
						MarkupCalculator.Category.PHARMACEUTICAL, 1), 0.01);

		assertEquals("calculateFinalPrice - 12456.95 Book 4 People - ", 13707.63,
				MarkupCalculator.calculateFinalPrice(12456.95,
						MarkupCalculator.Category.OTHERS, 4), 0.01);

	}
}
