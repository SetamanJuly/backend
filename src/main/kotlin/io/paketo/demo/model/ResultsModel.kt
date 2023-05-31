package io.paketo.demo.model

data class ResultsModel(
  val inbound: BoundModel,
  val outbound: BoundModel,
  val price: Double,
  val currency: String
)

data class BoundModel(
  val airline: String,
  val airlineImage: String,
  val arrivalDate: String,
  val arrivalTime: String,
  val departureDate: String,
  val departureTime: String,
  val destination: String,
  val origin: String
)