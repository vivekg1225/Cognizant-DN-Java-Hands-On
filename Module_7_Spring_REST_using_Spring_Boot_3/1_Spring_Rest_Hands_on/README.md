## Hands-on Covered

## 1. Spring Rest Handson

### Hands on 1 - Create a Spring Web Project using Maven 

### Hands on 2 - Spring Core – Load SimpleDateFormat from Spring Configuration XML 

SimpleDateFormat with the pattern ‘dd/MM/yyyy’ is created in multiple places of an application. To avoid creation of SimpleDateFormat in multiple places, define a bean in Spring XML Configuration file and retrieve the date.

---

## 2. Spring Rest Handson

- ### Hello World RESTful Web Service

Write a REST service in the spring learn application created earlier, that returns the text "Hello World!!" using Spring Web Framework. Refer details below:

Method: GET
URL: /hello
Controller: com.cognizant.spring-learn.controller.HelloController
Method Signature: public String sayHello()
Method Implementation: return hard coded string "Hello World!!"

Sample Request: http://localhost:8083/hello
Sample Response: Hello World!! 


- ### REST - Country Web Service

Write a REST service that returns India country details in the earlier created spring learn application.

URL: /country
Controller: com.cognizant.spring-learn.controller.CountryController
Method Annotation: @RequestMapping
Method Name: getCountryIndia()
Method Implementation: Load India bean from spring xml configuration and return

Sample Request: http://localhost:8083/country
Sample Response:
{
  "code": "IN",
  "name": "India"
}

- ### REST - Get all countries

Write a REST service that returns all the countries.

Controller: com.cognizant.spring-learn.controller.CountryController
Method Annotation: @GetMapping("/countries")
Method Name: getAllCountries()
Method Implementation: Load country list from country.xml and return

Sample Request: http://localhost:8083/countries
Sample Response:
[
  { "code": "IN", "name": "India"},
  { "code": "US", "name": "United States"},
  { "code": "JP", "name": "Japan"},
  { "code": "DE", "name": "Germany"}
]

- ### REST - Get country based on country code

Write a REST service that returns a specific country based on country code. The country code should be case insensitive.

Controller: com.cognizant.spring-learn.controller.CountryController
Method Annotation: @GetMapping("/countries/{code}")
Method Name: getCountry(String code)
Method Implemetation: Invoke countryService.getCountry(code) 
Service Method: com.cognizant.spring-learn.service.CountryService.getCountry(String code)

Sample Request: http://localhost:8083/country/in
Sample Response:
{
  "code": "IN",
  "name": "India"
}
