package io.paketo.demo.utils.data

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

val listOfDragons = hashMapOf(
  Pair("Drogon", "https://img.freepik.com/free-vector/detailed-travel-logo_23-2148616611.jpg?w=2000"),
  Pair("Rhaegal", "https://img.freepik.com/free-vector/detailed-travel-logo_23-2148616611.jpg?w=1380&t=st=1685613738~exp=1685614338~hmac=5cb2b95f2498e9f6e636010f0c206caf388c5d97650e561e024cd785c5046af4"),
  Pair("Viserion", "https://static.vecteezy.com/system/resources/previews/006/792/426/original/template-logo-plane-around-the-world-perfect-for-logo-traveling-tours-free-vector.jpg"),
  Pair("Balerion", "https://marketplace.canva.com/EAEaWkA8LrY/2/0/1600w/canva-travel-agency-or-website-logo-with-heart-and-airplane-6qaGNwoh4Xw.jpg"),
  Pair("Meraxes", "https://thumbs.dreamstime.com/z/travel-logo-design-agency-vector-inspiration-template-218267349.jpg"),
  Pair("Vhagar", "https://static.vecteezy.com/system/resources/previews/000/511/437/original/travel-tourism-logo-isolated-on-white-background-vector.jpg"),
  Pair("Sunfyre", "https://www.shutterstock.com/image-vector/travel-time-hand-drawn-lettering-260nw-1159550914.jpg"),
  Pair("Caraxes", "https://st2.depositphotos.com/5486388/8162/v/950/depositphotos_81627574-stock-illustration-travel-logo-template.jpg"),
  Pair("Vermithrax", "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/travel-logo-design-template-dea5e985c2bd8754168665d387bb284c_screen.jpg?ts=1610888433"),
  Pair("Morghul", "https://t4.ftcdn.net/jpg/04/16/88/83/360_F_416888318_DCDiepJmsRw0qMQ6zhfIfC1dvlPnlxno.jpg"),
  Pair("Shrykos", "https://c8.alamy.com/comp/2DAXK3E/travel-agency-logo-trip-logo-design-vector-illustration-2DAXK3E.jpg"),
  Pair("Arrax", "https://st2.depositphotos.com/5486388/8162/v/950/depositphotos_81627644-stock-illustration-travel-logo-template.jpg"),
  Pair("Tyraxes", "https://i.pinimg.com/736x/4d/2e/47/4d2e47f2b32936fa623f47e7ed5acc85.jpg"),
  Pair("Silverwing", "https://i.etsystatic.com/14605561/r/il/122c0e/2151653769/il_fullxfull.2151653769_b9i8.jpg"),
  Pair("Dreamfyre", "https://images-platform.99static.com/zudNWGHtYiWa-sqd5jqXyVt6wBE=/0x0:1773x1773/500x500/top/smart/99designs-contests-attachments/133/133463/attachment_133463156"),
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
  val randomHour = (0..23).random()
  val randomMinute = (0..59).random()
  val hour = String.format("%02d", randomHour)
  val minute = String.format("%02d", randomMinute)
  return "$hour:$minute"
}