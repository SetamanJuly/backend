package io.paketo.demo.utils

import io.paketo.demo.utils.data.conversionRates
import java.math.BigDecimal
import java.math.RoundingMode

fun getConversionRate(fromCurrency: String, toCurrency: String): Double {
  val conversionRate = conversionRates[fromCurrency] ?: throw IllegalArgumentException("Unknown origin: $fromCurrency")
  val targetConversionRate = conversionRates[toCurrency] ?: throw IllegalArgumentException("Unknown destiny: $toCurrency")
  val result = BigDecimal(targetConversionRate / conversionRate)
    .setScale(2, RoundingMode.HALF_UP)
  return result.toDouble()
}