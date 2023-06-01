package io.paketo.demo.utils

import io.paketo.demo.utils.data.conversionRates

fun getConversionRate(fromCurrency: String, toCurrency: String): Double {
  val conversionRate = conversionRates[fromCurrency] ?: throw IllegalArgumentException("Unknown origin: $fromCurrency")
  val targetConversionRate = conversionRates[toCurrency] ?: throw IllegalArgumentException("Unknown destiny: $toCurrency")
  return targetConversionRate / conversionRate
}