package io.paketo.demo

import io.paketo.demo.model.DragonFlightResponseModel
import io.paketo.demo.utils.generateRandomFlights
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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
	fun obtainFlights(@RequestParam(required = false) numberOfResults: Int?) = DragonFlightResponseModel(
		generateRandomFlights(numberOfResults ?: 50),
		timeLastRequest = Calendar.getInstance().timeInMillis
	)
}
