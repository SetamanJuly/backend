package io.paketo.demo.model.currency

data class CurrencyConverterResponse(
  val currencyFrom: String,
  val currencyTo: String,
  val exchangeRate: Double
)