# redis-dropwizard
Sample redis dropwizard application using maven. Application to post a key in redis and set its expiry time.
Whenever key gets expired, subscriber listens and performs basic business functions.

# Steps to run:
1. Start/Run Subscriber.java
2. Start the server by :
    1. cd redis-dropwizard
    2. mvn package
    3. java -jar target/redis-dropwizard-1.0-SNAPSHOT.jar server src/main/resources/local/application.yml
    4. Sample curl command: curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"key":"key1","expiry":10,"value":"value1"}' http://localhost:8080/redis/post/
3. Or Run TestJedis.java

# Pre-requisites:
1. Redis should be installed and be running on the default port.

