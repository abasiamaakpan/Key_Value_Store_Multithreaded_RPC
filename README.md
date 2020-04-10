#[[#]]# ${Distributed Multithreaded Server RPC Key_Value_Store}

##HashMap Initial Structure
####Key = 1, Value = value1
####Key = 2, Value = value2
####Key = 3, Value = value3
####Key = 4, Value = value4
####Key = 5, Value = value5

TODO: Run the server first on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar/gRE_Multi_Threaded_Project.jar 9090
then run both clients 

###Jar is server jar. GRPC Server is server program

#[[#]]# ${Multithreaded Client RPC Key_Value_Store}
TODO: There are two clients, Client 1 and Client 2
Run the client on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar2/gRE_Multi_Threaded_Project.jar 9090

###Jar2 is client1 jar. GRPCClient is Client 1 program

Run the client2 on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar3/gRE_Multi_Threaded_Project.jar 9090

###Jar3 is client2 jar. GRPCClient2 is Client 2 program

##Sequence of Commands 

####Check if servers are prepared
####Enter 7 to contact servers


####VOTE_REQUEST\nPlease enter ABORT or COMMIT to proceed :
#####Please enter ABORT or COMMIT to proceed : 
#####Enter 5 to ABORT, 6 to COMMIT
######Note:If one client commits but one aborts, both clients must exit
######Note:If one client aborts, both clients must exit


######Enter Server Number 9090-9094


######Enter 1 to PUT, 2 to GET, 3 to DELETE
######Note:PUT does not overwrite exisiting key value store, error message is displayed to console
######Note: GET and DELETE functions the same

######Note: After PUT/GET/DELETE commands have been executed, unless either Client aborts, program continues by rechecking server availability  
######Note: Whenever a Server(s) are down stack trace is printed to the client. The error is internal so could not be caught