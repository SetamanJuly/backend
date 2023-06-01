package io.paketo.demo

import io.paketo.demo.model.currency.CurrencyConverterResponse
import io.paketo.demo.model.flights.DragonFlightResponseModel
import io.paketo.demo.utils.generateRandomFlights
import io.paketo.demo.utils.getConversionRate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.Calendar

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
  runApplication<DemoApplication>(*args)
}

@RestController
class MessageController {
  @GetMapping("/")
  fun index(@RequestParam("name") name: String) = "Hello, $name!"
}

@RestController
class BasicController {
  @GetMapping("/check")
  fun indexTest() = "This is working"
}

@RestController
class DragonController {
  @GetMapping("/flights")
  fun obtainFlights(@RequestParam(required = false) numberOfResults: Int?): ResponseEntity<DragonFlightResponseModel> {
    try {
      val flights = generateRandomFlights(numberOfResults ?: 50)
      val responseModel =
        DragonFlightResponseModel(flights, timeLastRequest = Calendar.getInstance().timeInMillis)
      return ResponseEntity.ok(responseModel)
    } catch (exception: Exception) {
      throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error somewhere", exception)
    }
  }
}

@RestController
class CurrencyController {
	@GetMapping("/currency")
	fun obtainConversionRate(@RequestParam fromCurrency: String, @RequestParam toCurrency: String): ResponseEntity<CurrencyConverterResponse> {
		try {
			val conversionRate = getConversionRate(fromCurrency, toCurrency)
			val response = CurrencyConverterResponse(fromCurrency, toCurrency, conversionRate)
			return ResponseEntity.ok(response)
		} catch (exception: IllegalArgumentException) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST, exception.message, exception)
		}
	}
}
