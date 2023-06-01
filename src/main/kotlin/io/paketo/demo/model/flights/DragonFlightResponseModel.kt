package io.paketo.demo.model.flights

data class DragonFlightResponseModel(
  val results : List<ResultsModel>,
  val timeLastRequest: Long
)