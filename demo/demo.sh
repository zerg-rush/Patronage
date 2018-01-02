#!/bin/bash

HOST=http://localhost:8080/rest/patronage1/v1

# call :MakeRESTRequest /
#  curl -i http://localhost:8080/

echo.

rem curl -i http://localhost:8080/persons/0/courses/0

MakeRESTRequest /persons/1/
# MakeRESTRequest /persons/
# MakeRESTRequest /persons/0/courses/0
# MakeRESTRequest /vehicles/1/
# MakeRESTRequest /vehicles/


MakeRESTRequest()
{
  curl -i $HOST$1
}