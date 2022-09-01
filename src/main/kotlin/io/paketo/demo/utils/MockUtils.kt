package io.paketo.demo.utils

import io.paketo.demo.model.BoundModel
import io.paketo.demo.model.ResultsModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.Random

fun generateRandomFlights(numberFlights: Int): List<ResultsModel> {
  val results = mutableListOf<ResultsModel>()
  repeat(numberFlights) {
    obtainRandomBound().let {
      results.add(
        ResultsModel(
          inbound = it.first,
          outbound = it.second,
          price = (100..1000).random().toDouble(),
          currency = "EUR",
        )
      )
    }
  }
  return results
}

fun obtainRandomBound() : Pair<BoundModel, BoundModel>{

  val generateAirlineInBound = listOfDragons.random()
  val generateAirlineOutBound = listOfDragons.random()

  val generateOrigin = listOfDestination.random()
  val generateDestination = listOfDestination.random()

  val generateInboundDates = generateRandomDate()
  val generateOutboundDates = generateRandomDate(generateInboundDates)

  val inbound = BoundModel (
    airline = generateAirlineInBound.key,
    airlineImage = generateAirlineInBound.value,
    arrivalDate = generateInboundDates.formatDate(),
    arrivalTime = generateRandomHour(),
    departureDate = generateInboundDates.addRandomDays().formatDate(),
    departureTime = generateRandomHour(),
    destination = generateDestination,
    origin = generateOrigin,
  )

  val outbound = BoundModel (
    airline = generateAirlineOutBound.key,
    airlineImage = generateAirlineOutBound.value,
    arrivalDate = generateOutboundDates.formatDate(),
    arrivalTime = generateRandomHour(),
    departureDate = generateOutboundDates.addRandomDays().formatDate(),
    departureTime = generateRandomHour(),
    destination = generateOrigin,
    origin = generateDestination,
  )

  return Pair(inbound, outbound)
}

fun <T,U> Map<T,U>.random(): Map.Entry<T,U> = entries.elementAt(Random().nextInt(size))

fun Date.addRandomDays() : Date {
  val calendar = Calendar.getInstance()
  calendar.time = this
  val random = Random()
  val randomDay = random.nextInt(5)
  calendar.add(Calendar.DAY_OF_YEAR, randomDay)
  return calendar.time
}

fun Date.formatDate() : String {
  val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
  return dateFormat.format(this)
}