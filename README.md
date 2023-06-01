## CurrencyController

### Get Conversion Rate

Get the conversion rate between two currencies.

- URL: `/currency`
- HTTP Method: `GET`

#### Query Parameters

- `fromCurrency` (string): The source currency for the conversion.
- `toCurrency` (string): The target currency for the conversion.

#### Successful Response

- Status Code: 200 OK
- Body:

```json
{
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "conversionRate": 0.89
}
```

#### Error Response

- Status Code: 400 Bad Request
- Body:

```json
{
  "status": 400,
  "message": "Invalid currency provided."
}
```

## DragonController

### Get Random Flights

Get random flights.

- URL: `/flights`
- HTTP Method: `GET`

#### Query Parameters

- `numberOfResults` (int, optional): The number of flight results to obtain (default: 50).

#### Successful Response

- Status Code: 200 OK
- Body:

```json
{
  "flights": [
    {
      "inbound": {
        "airline": "Drogon",
        "airlineImage": "https://img.freepik.com/free-vector/detailed-travel-logo_23-2148616611.jpg?w=2000",
        "arrivalDate": "25-05-2023",
        "arrivalTime": "09:30",
        "departureDate": "25-05-2023",
        "departureTime": "07:45",
        "destination": "King's Landing",
        "origin": "Winterfell"
      },
      "outbound": {
        "airline": "Rhaegal",
        "airlineImage": "https://img.freepik.com/free-vector/detailed-travel-logo_23-2148616611.jpg?w=1380&t=st=1685613738~exp=1685614338~hmac=5cb2b95f2498e9f6e636010f0c206caf388c5d97650e561e024cd785c5046af4",
        "arrivalDate": "27-05-2023",
        "arrivalTime": "14:15",
        "departureDate": "27-05-2023",
        "departureTime": "12:30",
        "destination": "Winterfell",
        "origin": "King's Landing"
      },
      "price": 570.0,
      "currency": "EUR"
    },
    ...
  ],
  "timeLastRequest": 1653997921000
}
```

#### Error Response

- Status Code: 400 Bad Request
- Body:

```json
{
  "status": 400,
  "message": "Error somewhere"
}
+ ```