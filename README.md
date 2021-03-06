# Spring Boot + ActiveMQ example
Sample project show how to use Spring Boot with Apache ActiveMQ.

Contains two Spring Boot applications - consumer and producer.

# Run ActiveMQ

### Linux

Download and unpack ActiveMQ, go to "bin" directory:

<pre>
$ wget http://apache-mirror.rbc.ru/pub/apache//activemq/5.14.3/apache-activemq-5.14.3-bin.tar.gz
$ tar -zxf apache-activemq-5.14.3-bin.tar.gz
$ cd apache-activemq-5.14.3/bin
$ activemq start
</pre>

### Windows

Download latest release from [official site](http://activemq.apache.org/download.html) and unpack archive file. Go to the ActiveMQ bin directory, and open command prompt from there (hold Shift and click RMB -> Open command window here).

<pre>&gt; activemq.bat start</pre>

### Running

Now, if everything is ok, open ActiveMQ's admin console at [http://localhost:8161/](http://localhost:8161/) with "admin/admin" credentials.

Now we need to create topic and queue:
* Go to Topics tab and create new queue with name "sampleMessageTopic".
* Go to Queues tab and create new queue with name "sampleMessageQueue". 

Topic and queue will be available at `61616` port by default.

Enjoy!

# Run applications
Consumer is a Spring Boot application and starts in it's own Tomcat instance on `65001` port (see `application.yml`).
Consumer should be started first.

Producer is Spring MVC application with user interface and should be started using Maven's `mvn spring-boot:run` goal.
You can find start page on `localhost:8080/` by default.

# Messaging

If you do everything right, you'll see start page of producer's application with buttons for sending messages to topic and to queue.

In consumer's application console you'll be able to see following messages from the topic:
<pre>
TopicSampleMessageConsumer1 : Received &lt; Sample Message{title=From Timer, body=Message #6 from topic.} &gt;
TopicSampleMessageConsumer2 : Received &lt; Sample Message{title=From Timer, body=Message #6 from topic.} &gt;
</pre>
and following message from the queue:
<pre>
QueueSampleMessageConsumer : Received &lt; Sample Message{title=The Force, body=Let the force be with you!} &gt;
</pre>

Also, you can send messages to the consumers (in JSON format) using ActiveMQ admin console:

<pre>{ "title":"Test Title 01", "body":"Test Body 01" }</pre>

# Useful links

* [Spring Boot Hello World Example with JSP](https://github.com/hellokoding/springboot-jsp)
* [Spring Boot Sample Web JSP](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-web-jsp)
