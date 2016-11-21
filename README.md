# redis-dropwizard
Basic application to post a key to redis and set its expiry time.
Whenever key gets expired, subscriber listens and performs basic business functions.

# Steps to run:
1. Start/Run Subscriber.java
2. Start the server by :
    cd redis-dropwizard
    mvn package
    java -jar target/redis-dropwizard-1.0-SNAPSHOT.jar server src/main/resources/local/application.yml
3. Or Run TestJedis.java

# Pre-requisites:
1. Redis should be installed and be running on the default port.

