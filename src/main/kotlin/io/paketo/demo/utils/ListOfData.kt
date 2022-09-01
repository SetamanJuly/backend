package io.paketo.demo.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

val listOfDragons = hashMapOf(
  Pair("Drogon", "1"),
  Pair("Rhaegal", "2"),
  Pair("Viserion", "3"),
  Pair("Balerion", "4"),
  Pair("Meraxes", "5"),
  Pair("Vhagar", "6"),
  Pair("Sunfyre", "7"),
  Pair("Caraxes", "8"),
  Pair("Vermithrax", "9"),
  Pair("Morghul", "12"),
  Pair("Shrykos", "13"),
  Pair("Arrax", "15"),
  Pair("Tyraxes", "16"),
  Pair("Silverwing", "17"),
  Pair("Dreamfyre", "19"),
)

val listOfDestination = arrayListOf(
  "King's Landing",
  "Winterfell",
  "Qarth",
  "Braavos",
  "Meereen",
  "Volantis",
  "Pentos",
  "Vaes",
  "Astapor",
  "Yunkai",
  "Casterly",
  "Highgarden",
  "Sunspear",
  "Oldtown",
  "Riverrun",
  "Pyke",
  "The",
  "Harrenhal",
  "White",
  "Gulltown",
)

fun generateRandomDate(startDate: Date? = null): Date {
  val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
  val startMillis = startDate?.time ?: dateFormat.parse("01-01-1900").time
  val endMillis = dateFormat.parse("31-12-2100").time
  val diff = endMillis - startMillis + 1
  return Date(startMillis + Random.nextLong(diff))
}

fun generateRandomHour(): String {
  val randomHour = (0..23).random() // Genera una hora aleatoria entre 0 y 23
  val randomMinute = (0..59).random() // Genera un minuto aleatorio entre 0 y 59

  val hour = String.format("%02d", randomHour) // Asegura que la hora tenga siempre 2 dígitos
  val minute = String.format("%02d", randomMinute) // Asegura que el minuto tenga siempre 2 dígitos

  return "$hour:$minute"
}