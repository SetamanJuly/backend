package io.paketo.demo

import io.paketo.demo.model.currency.CurrencyConverterResponse
import io.paketo.demo.model.flights.DragonFlightResponseModel
import io.paketo.demo.utils.generateRandomFlights
import io.paketo.demo.utils.getConversionRate
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.Calendar
import java.util.UUID

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

@RestController
class ImageController {
  @GetMapping("/images/{imageName}")
  fun getImage(@PathVariable imageName: String): ResponseEntity<ByteArray> {
    val imageResource = ClassPathResource(imageName)

    if (imageResource.exists() && imageResource.isFile) {
      val imageBytes = imageResource.inputStream.readAllBytes()

      return ResponseEntity
        .ok()
        .contentType(MediaType.IMAGE_JPEG)
        .contentLength(imageBytes.size.toLong())
        .body(imageBytes)
    }

    return ResponseEntity.notFound().build()
  }
}

@RestController
class ImageUploadController {
  @PostMapping("/images/upload")
  fun uploadImage(@RequestBody image: ByteArray): ResponseEntity<String> {
    if (image.isEmpty()) {
      throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Image file is required")
    }

    try {
      val originalFilename = StringUtils.cleanPath("test.png")
      val fileExtension = getFileExtension(originalFilename)
      val newFilename = generateUniqueFilename(fileExtension)

      val currentDirectory = System.getProperty("user.dir")
      val targetLocation = Paths.get(currentDirectory, "src", "main", "resources", newFilename)
      Files.write(targetLocation, image)

      return ResponseEntity.ok().body(newFilename)
    } catch (ex: IOException) {
      throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload image", ex)
    }
  }

  private fun getFileExtension(filename: String): String {
    val lastDotIndex = filename.lastIndexOf('.')
    return if (lastDotIndex != -1) filename.substring(lastDotIndex) else ""
  }

  private fun generateUniqueFilename(fileExtension: String): String {
    val randomLetters = (1..4).map { ('a'..'z').random() }.joinToString("")
    return "$randomLetters$fileExtension"
  }
}