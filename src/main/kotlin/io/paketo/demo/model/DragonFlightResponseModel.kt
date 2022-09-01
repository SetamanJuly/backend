package io.paketo.demo.model

data class DragonFlightResponseModel(
  val results : List<ResultsModel>,
  val timeLastRequest: Long
)