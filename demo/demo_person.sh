#!/bin/bash

clear

HOST=http://localhost:8080

# 1 COMMAND [GET, PUT, POST, ...
# 2 URL
# 3 FORMAT [JSON, XML, NONE = = DEFAULT=JSON]
# 4 [DATA]
MakeRequest() {
  if [ -z "$4" ];
  then
    echo method: $1, endpoint: $HOST$2, format: ${3:json}
    echo ""
    curl --include -X $1 --header "Accept: application/${3:json}" $HOST$2
  else
    echo method: $1, endpoint: $HOST$2, format: $3, data: $4
    echo ""
    curl --include -X $1 --header "Content-Type: application/$3" --header "Accept: application/$3" --data @sample_data/$4.$3 $HOST$2
  fi
  echo -e "\n"
}


echo "###########################################################"
echo "############## GETTING STORAGE STATUS (JSON) ##############"
echo "###########################################################"
MakeRequest GET /storage json

echo "##########################################################"
echo "############## GETTING STORAGE STATUS (XML) ##############"
echo "##########################################################"
MakeRequest GET /storage xml

echo "##################################################"
echo "############## PERSONS COUNT (JSON) ##############"
echo "##################################################"
MakeRequest GET /persons/count json

echo "#################################################"
echo "############## PERSONS COUNT (XML) ##############"
echo "#################################################"
MakeRequest GET /persons/count xml

echo "#################################################"
echo "############## PERSONS LIST (JSON) ##############"
echo "#################################################"
MakeRequest GET /persons/list json

echo "################################################"
echo "############## PERSONS LIST (XML) ##############"
echo "################################################"
MakeRequest GET /persons/list xml

echo "###################################################"
echo "############## PERSON SHOW #3 (JSON) ##############"
echo "###################################################"
MakeRequest GET /persons/show/3 json

echo "##################################################"
echo "############## PERSON SHOW #3 (XML) ##############"
echo "##################################################"
MakeRequest GET /persons/show/3 xml

echo "#####################################################"
echo "############## PERSON DELETE #3 (JSON) ##############"
echo "#####################################################"
MakeRequest DELETE /persons/delete/3 json

echo "####################################################"
echo "############## PERSON DELETE #4 (XML) ##############"
echo "####################################################"
MakeRequest DELETE /persons/delete/4 xml

echo "##################################################"
echo "############## PERSONS COUNT (JSON) ##############"
echo "##################################################"
MakeRequest GET /persons/count json

echo "#################################################"
echo "############## PERSONS LIST (JSON) ##############"
echo "#################################################"
MakeRequest GET /persons/list json

echo "################################################"
echo "############## PERSONS ADD (JSON) ##############"
echo "################################################"
MakeRequest POST /persons/add json new_person

echo "##############################################"
echo "############## PERSON ADD (XML) ##############"
echo "##############################################"
MakeRequest POST /persons/add xml new_person

echo "##################################################"
echo "############## PERSONS COUNT (JSON) ##############"
echo "##################################################"
MakeRequest GET /persons/count json

echo "################################################"
echo "############## PERSON LIST (JSON) ##############"
echo "################################################"
MakeRequest GET /persons/list json

echo "#####################################################"
echo "############## PERSON UPDATE #7 (JSON) ##############"
echo "#####################################################"
MakeRequest PUT /persons/update/7 json update_person

echo "####################################################"
echo "############## PERSON UPDATE #8 (XML) ##############"
echo "####################################################"
MakeRequest PUT /persons/update/8 xml update_person

echo "##############################################################"
echo "############## VEHICLE UPDATE #8 2nd time (XML) ##############"
echo "##############################################################"
MakeRequest PUT /persons/update/8 xml update_person_2nd

echo "#################################################"
echo "############## PERSONS LIST (JSON) ##############"
echo "#################################################"
MakeRequest GET /persons/list json
