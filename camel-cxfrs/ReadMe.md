== Use Case 2 - Camel Route aggregating messages enriched and transformed from REST & WebServices endpoints

Process the JSON files generated by the use case 1, send each JSON Object to a REST endpoint responsible to enrich the message and a Web Service responsible to transform the result returned in XML format.
Aggregate the responses received and take care about the transformation XML/JSon. Publish the result into a H2 DB using the SQL/JDBC component. The definition of the WSDL, JSON files, WebService, REST Service & DB will be provided.

.Goals
* Design the Apache Camel routes consuming the json files and exposing the REST and WebService endpoint
* Use the multicast EIP pattern to distribute the messages to the services (REST/WebService)
* Design the CXF Web Service using jax-ws annotations
* Use Camel CXFRS component to setup the Client & REST Server
* Aggregate the messages received using the aggregation EIP pattern
* Save the message aggregated into a SQL database using the Spring SQL component

=== Service EndPoints
		
		REST Service: (POST) http://localhost:9191/rs/customerservice/enrich

To test this REST EndPoint you can execute the following curl command line:

[source]
curl \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -X POST -d '{"company":{"name":"MicroservicesVision","geo":"WA","active":true},"contact":{"firstName":"Fred","lastName":"Quicksand","streetAddr":"202 Barney Blvd.","city":"Rock City","state":"MI","zip":"19728","phone":"100-400-2000"},"clientId":0,"salesRepresentative":null}' \
    http://localhost:9191/rs/customerservice/enrich
    
Fabric    
curl -H "Accept: application/json" \
     -H "Content-Type: application/json" \
     -X POST -d '{"company":{"name":"MicroservicesVision","geo":"SA","active":true},"contact":{"firstName":"Fred","lastName":"Quicksand","streetAddr":"202 Barney Blvd.","city":"Rock City","state":"SA","zip":"19728","phone":"100-400-2000"},"clientId":0,"salesRepresentative":null}' \
     http://rhel7jboss02:8182/cxf/rs/customerservice/enrich
     
{"company":{"name":"MicroservicesVision","geo":"SOUTH_AMERICA","active":true},"contact":{"firstName":"Fred","lastName":"Quicksand","streetAddr":"202 Barney Blvd.","city":"Rock City","state":[rmarting@rhel7 ~] 

// Fixed in some cases

curl -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -X POST -d '{"company":{"name":"MicroservicesVision","geo":"WA","active":true},"contact":{"firstName":"Fred","lastName":"Quicksand","streetAddr":"202 Barney Blvd.","city":"Rock City","state":"MI","zip":"19728","phone":"100-400-2000"},"clientId":0,"salesRepresentative":null}' \
    http://rhel7jboss02:9000/servlets/org.apache.cxf.cxf-rt-transports-http/cxf/rs/customerservice/enrich
    
    
{"company":{"name":"MicroservicesVision","geo":"SOUTH_AMERICA","active":true},"contact":{"firstName":"Fred","lastName":"Quicksand","streetAddr":"202 Barney Blvd.","city":"Rock City","state":"SA","zip":"19728","phone":"100-400-2000"},"clientId":0,"salesRepresentative":null}
    

=== Other Resources
Related Links about the topics included in this Use Case:

* link:http://people.apache.org/~dkulp/camel/cxfrs.html[cxfrs Component]

* link:http://camel.apache.org/aggregate-example.html[Aggregate Example]

* link:http://www.catchmycity.com/tutorial/multicast-aggregationstrategy-in-apache-camel_105[Multicast aggregationStrategy in Apache Camel]

* link:http://camel.apache.org/json.html[JSON]

* link:http://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/[Converting POJO to JSON]

* link:http://camel.apache.org/request-reply.html[Request-Reply Pattern]

* link:http://www.javavillage.in/apache-camel-sql-example.php[Apache Camel SQL Component Example]
