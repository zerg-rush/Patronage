@echo off
cls

set HOST=http://localhost:8080

echo ###########################################################
echo ############## GETTING STORAGE STATUS (JSON) ##############
echo ###########################################################
call :MakeRequest GET /storage json

echo ##########################################################
echo ############## GETTING STORAGE STATUS (XML) ##############
echo ##########################################################
call :MakeRequest GET /storage xml

echo ##################################################
echo ############## PERSONS COUNT (JSON) ##############
echo ##################################################
call :MakeRequest GET /persons/count json

echo #################################################
echo ############## PERSONS COUNT (XML) ##############
echo #################################################
call :MakeRequest GET /persons/count xml

echo #################################################
echo ############## PERSONS LIST (JSON) ##############
echo #################################################
call :MakeRequest GET /persons/list json

echo ################################################
echo ############## PERSONS LIST (XML) ##############
echo ################################################
call :MakeRequest GET /persons/list xml

echo ###################################################
echo ############## PERSON SHOW #3 (JSON) ##############
echo ###################################################
call :MakeRequest GET /persons/show/3 json

echo ##################################################
echo ############## PERSON SHOW #3 (XML) ##############
echo ##################################################
call :MakeRequest GET /persons/show/3 xml

echo #####################################################
echo ############## PERSON DELETE #3 (JSON) ##############
echo #####################################################
call :MakeRequest DELETE /persons/delete/3 json

echo ####################################################
echo ############## PERSON DELETE #4 (XML) ##############
echo ####################################################
call :MakeRequest DELETE /persons/delete/4 xml

echo ##################################################
echo ############## PERSONS COUNT (JSON) ##############
echo ##################################################
call :MakeRequest GET /persons/count json

echo #################################################
echo ############## PERSONS LIST (JSON) ##############
echo #################################################
call :MakeRequest GET /persons/list json

echo ################################################
echo ############## PERSONS ADD (JSON) ##############
echo ################################################
call :MakeRequest POST /persons/add json new_person

echo ##############################################
echo ############## PERSON ADD (XML) ##############
echo ##############################################
call :MakeRequest POST /persons/add xml new_person

echo ##################################################
echo ############## PERSONS COUNT (JSON) ##############
echo ##################################################
call :MakeRequest GET /persons/count json

echo ################################################
echo ############## PERSON LIST (JSON) ##############
echo ################################################
call :MakeRequest GET /persons/list json

echo #####################################################
echo ############## PERSON UPDATE #7 (JSON) ##############
echo #####################################################
call :MakeRequest PUT /persons/update/7 json update_person

echo ####################################################
echo ############## PERSON UPDATE #8 (XML) ##############
echo ####################################################
call :MakeRequest PUT /persons/update/8 xml update_person

echo #############################################################
echo ############## PERSON UPDATE #8 2nd time (XML) ##############
echo #############################################################
call :MakeRequest PUT /persons/update/8 xml update_person_2nd

echo #################################################
echo ############## PERSONS LIST (JSON) ##############
echo #################################################
call :MakeRequest GET /persons/list json


goto :EoF

# 1 COMMAND [GET, PUT, POST, DELETE
# 2 URL
# 3 FORMAT [JSON, XML, NONE = DEFAULT=JSON]
# 4 [DATA]
:MakeRequest
  if "%3"=="" (
    set FORMAT=json
  ) else (
    set format=%3
  )
  if "%4"=="" (
    echo method: %1, endpoint: %HOST%%2, format: %FORMAT%
    echo.
    curl --include -X %1 --header "Accept: application/%FORMAT%" %HOST%%2
  ) else (
    echo method: %1, endpoint: %HOST%%2, format: %FORMAT%, data: %4
    echo.
    curl --include -X %1 --header "Content-Type: application/%FORMAT%" --header "Accept: application/%FORMAT%" --data @sample_data\%4.%FORMAT% %HOST%%2
  )
  echo.
  echo.
exit/b

:EoF