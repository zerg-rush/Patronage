@echo off
cls

set HOST=http://localhost:8080/rest/patronage1/v1

call :MakeRESTRequest /
rem curl -i http://localhost:8080/

echo.

rem curl -i http://localhost:8080/persons/0/courses/0

echo.
call :MakeRESTRequest /persons/1/
call :MakeRESTRequest /persons/
call :MakeRESTRequest /persons/0/courses/0
call :MakeRESTRequest /vehicles/1/
call :MakeRESTRequest /vehicles/
exit

call :MakeRESTRequest /info
call :MakeRESTRequest /auditevents
call :MakeRESTRequest /heapdump
call :MakeRESTRequest /health
call :MakeRESTRequest /beans
call :MakeRESTRequest /trace
call :MakeRESTRequest /loggers
call :MakeRESTRequest /loggers
call :MakeRESTRequest /loggers
call :MakeRESTRequest /autoconfig
call :MakeRESTRequest /configprops
call :MakeRESTRequest /env
call :MakeRESTRequest /mappings
call :MakeRESTRequest /metrics
call :MakeRESTRequest /dump

exit

:MakeRESTRequest
echo Getting %HOST%%1
curl %HOST%%1
rem | jq
echo.
echo.
exit/b