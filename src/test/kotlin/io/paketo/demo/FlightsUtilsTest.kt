package io.paketo.demo

import io.paketo.demo.utils.addRandomDays
import io.paketo.demo.utils.formatDate
import io.paketo.demo.utils.generateRandomFlights
import io.paketo.demo.utils.obtainRandomBound
import io.paketo.demo.utils.random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Calendar

class FlightsUtilsTest {

  @Test
  fun `test generateRandomFlights`() {
    val numberFlights = 10
    val flights = generateRandomFlights(numberFlights)
    assertEquals(numberFlights, flights.size)
    for (flight in flights) {
      assertNotNull(flight.inbound)
      assertNotNull(flight.outbound)
      assertNotNull(flight.price)
      assertNotNull(flight.currency)
    }
  }

  @Test
  fun `test obtainRandomBound`() {
    val (inbound, outbound) = obtainRandomBound()
    assertNotNull(inbound)
    assertNotNull(outbound)
    assertNotEquals(inbound, outbound)
    assertNotNull(inbound.airline)
    assertNotNull(inbound.airlineImage)
    assertNotNull(inbound.arrivalDate)
    assertNotNull(inbound.arrivalTime)
    assertNotNull(inbound.departureDate)
    assertNotNull(inbound.departureTime)
    assertNotNull(inbound.destination)
    assertNotNull(inbound.origin)
    assertNotNull(outbound.airline)
    assertNotNull(outbound.airlineImage)
    assertNotNull(outbound.arrivalDate)
    assertNotNull(outbound.arrivalTime)
    assertNotNull(outbound.departureDate)
    assertNotNull(outbound.departureTime)
    assertNotNull(outbound.destination)
    assertNotNull(outbound.origin)
    assertNotEquals(inbound.airline, outbound.airline)
    assertNotEquals(inbound.origin, outbound.origin)
    assertNotEquals(inbound.destination, outbound.destination)
  }

  @Test
  fun `test random extension function on Map`() {
    val map = mapOf("A" to 1, "B" to 2, "C" to 3)
    val randomEntry = map.random()
    assertTrue(map.containsKey(randomEntry.key))
    assertTrue(map.containsValue(randomEntry.value))
  }

  @Test
  fun `test addRandomDays extension function on Date`() {
    val calendar = Calendar.getInstance()
    calendar.set(2023, Calendar.JANUARY, 1)
    val date = calendar.time
    val newDate = date.addRandomDays()
    assertTrue(newDate.after(date))
    val diff = newDate.time - date.time
    assertTrue(diff !in 1..5)
  }

  @Test
  fun `test formatDate extension function on Date`() {
    val calendar = Calendar.getInstance()
    calendar.set(2023, Calendar.JANUARY, 1)
    val date = calendar.time
    val expectedFormattedDate = "01-01-2023"
    val formattedDate = date.formatDate()
    assertEquals(expectedFormattedDate, formattedDate)
  }

}