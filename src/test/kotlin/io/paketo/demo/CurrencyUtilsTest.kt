package io.paketo.demo

import io.paketo.demo.utils.getConversionRate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CurrencyUtilsTest {

  @Test
  fun `test getConversionRate - valid currencies`() {
    val fromCurrency = "EUR"
    val toCurrency = "USD"
    val conversionRate = getConversionRate(fromCurrency, toCurrency)
    assertEquals(0.85, conversionRate)
  }

  @Test
  fun `test getConversionRate - unknown origin currency`() {
    val fromCurrency = "XYZ"
    val toCurrency = "EUR"
    val exception = assertThrows(IllegalArgumentException::class.java) {
      getConversionRate(fromCurrency, toCurrency)
    }
    assertEquals("Unknown origin: XYZ", exception.message)
  }

  @Test
  fun `test getConversionRate - unknown destiny currency`() {
    val fromCurrency = "USD"
    val toCurrency = "XYZ"
    val exception = assertThrows(IllegalArgumentException::class.java) {
      getConversionRate(fromCurrency, toCurrency)
    }
    assertEquals("Unknown destiny: XYZ", exception.message)
  }

}