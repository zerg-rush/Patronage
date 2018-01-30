# Patronage 2018 / BACKEND
Goal: to design and implement REST API for car dealer
----------------------------------------------------


Data model
------------------------

![](images/Identity%20card.jpg)

![](images/Registration%20Certificate.jpg)

Project structure
------------------------

![](images/Project%20structure.png)


Designated Endpoints
--------------------
Swagger2 REST API JSON specification file (available to download at [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs))
![](images/swagger-api-docs.png)

Swagger2 UI (frontend component) generated doc:  
[http://localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)
![](images/swagger1.png)

Extra storage endpoint (to check which storage mode is chosen):
![](images/Extra_storage_endpoint.png)
 
![](images/swagger2.png)

![](images/swagger3.png)

![](images/swagger4.png)

![](images/swagger5.png)

![](images/swagger6.png)

![](images/swagger7.png)

![](images/swagger8.png)

![](images/swagger9.png)

![](images/swagger10.png)

![](images/swagger11.png)

HAL browser (additional embedded browser included in the project, which provide basic UI for accessing REST API, https://github.com/mikekelly/hal-browser):  
[http://localhost:8080/browser/index.html#/](http://localhost:8080/browser/index.html#/)
![](images/HAL_browser1.png)
 
[http://localhost:8080/browser/index.html#/vehicles/show/1](http://localhost:8080/browser/index.html#/vehicles/show/1)
![](images/HAL_browser2.png)

IntelliJ REST API assistant tool:  

![](images/IntelliJ%20Menu%20-%20Test%20REST%20API%20plugin.png)

![](images/IntelliJ%20Test%20REST%20API%20plugin.png)


Swagger2 UI presenting specific HTTP codes fine tuned for each method/endpoint:  
---------------------------

add Person method (POST /persons/add, HTTP codes: 201, 400):  

![](images/HTTP_codes_1.png)
  
delete Person method (DELETE /persons/delete/{id}, HTTP codes: 404):  
  
![](images/HTTP_codes_3.png)
  
show Person method (GET /persons/show/{id}, HTTP codes: 404):  
  
![](images/HTTP_codes_5.png)
  
update Person method (PUT /persons/update/{id}, HTTP codes: 202, 400, 404):  
  
![](images/HTTP_codes_6.png)
 

Swagger2 UI presenting domain model class Person:  
-----------------------------------------------
![](images/Swagger_model_definition_person.png)


Swagger2 UI presenting domain model class Vehicle:  
-----------------------------------------------
![](images/Swagger_model_definition_vehicle.png)

Environment variable H2_STORAGE_ENABLED set to false in IntelliJ IDE (for tests):
--------------------------------------------------------------------------------
![](images/environment%20setting%20for%20H2%20in%20IntelliJ.png)


Demo of validating vehicle plate number
---------------------------------------
![](images/validation_demo_wrong_plate_number.png)

Demo of validating engine capacity, vehicle brand and number of seats
---------------------------------------
![](images/validation_demo_engine_brand_seats.png)
