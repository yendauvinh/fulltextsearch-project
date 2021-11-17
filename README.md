# fulltextsearch-project
fulltextsearch-project

Running: mvn clean && mvn spring-boot:run
---TEST
--create new data
curl --location --request POST 'localhost:8080/ftsone' \
--header 'Content-Type: application/json' \
--data-raw '{
    "description" : "i am yen. i love you forever, yenahihi.",
    "name" : "yen"
}'

--query
curl --location --request GET 'localhost:8080/ftglobal?description=yenahihi&name=yen'
