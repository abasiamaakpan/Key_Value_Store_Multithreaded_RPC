# Distributed Multithreaded Server RPC Key_Value_Store
## HashMap Initial Structure
Key = 1, Value = value1
Key = 2, Value = value2
Key = 3, Value = value3
Key = 4, Value = value4
Key = 5, Value = value5

## Running the application

Run the server first on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar/gRE_Multi_Threaded_Project.jar 9090
then run all clients 

Jar is server jar. GRPC Server is server program

TODO: There are three clients, Client 7, Client 8 and Client 9

Jar2 is client7 jar. GRPCClient7 is Client 7 program
Run the client7 on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar2/gRE_Multi_Threaded_Project.jar 9090


Jar3 is client8 jar. GRPCClient8 is Client 8 program
Run the client8 on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar3/gRE_Multi_Threaded_Project.jar 9091


Jar4 is client9 jar. GRPCClient9 is Client 9 program
Run the client9 on your terminal using java -jar /"your directory here"/gRE_Multi_Threaded_Project/out/artifacts/gRE_Multi_Threaded_Project_jar4/gRE_Multi_Threaded_Project.jar 9092


## Overview of Paxos as per this application
There are three clients. The clients are proposers. The servers/Service are Acceptors. The Learners 
are the clients that failed to achieve consensus the first time. Consensus is achieved by the 
majority of the proposers which are two out of three in this case. The steps are as follows:

A client/proposer proposes a value. In my case, the proposal is seen as the proposal/
permission request
/suggestion ID to gain permission from a majority of the pairs to make a suggestion. This is any integer > 0.

The acceptor/Server/Service accepts this value as the standard. If a proposal/permission request/
suggestion ID from another client is greater than this integer, the acceptor/service makes this value 
the new benchmark. Proposals/Permssion Requests or suggestion ID's less than this value are rejected 
and the proposer becomes the learner and is told to resubmit a new proposal.

Proposers that have been given access previously are told to reenter their suggestion and as long as 
two of the three clients have oermission and reenter the right suggestion ID/proposal, consensus is achieved,
else a client/proposer must wait till the majority of peers(2/3 clients) are given permission

## Usage

## Code Sequence
On startup, the sequence of code is as follows: 
1) Do you want to shutdown a server? Y/N. Enter 1 for Y, 0 for No
Enter 1 for Y, 0 for No

2) If 1 is chosen, Choose server(s) to shutdown. Select from remaining server list. 
This process repeats itself until 0 is chosen

3) User is told to Enter Server from List above to shutdown Note: As long as any 
server exists in network(list of remaining servers) the client has the ability to 
shutdown anyone of them. If they are all shutdown, client exits. Once server is 
shutdown, it cannot be revived and the application needs to be manually restarted.
 If a server is shutdown, the user is giving the option of the remaining servers 
 to communicate with. A message like Enter server from list is shown.
  
4) Once a server has been chosen, application prompts user to PUT/GET/DELETE. GET 
does not use the Paxos Mechanism. However, within either PUT/DELETE transactions, 
Paxos is initiated. Whatever method is invoked (PUT,GET,DELETE) by the clients, 
the action is replicated on all other key value stores that exist on all the servers. 
The PUT method does not overwrite itself if another value is attempted. Instead, it 
just tells the client to enter another key.

5) The User is prompted to enter a suggestion value and waits for other 
clients/proposer to join. As long as no other proposer/client joins, current 
client proceeds to renter the suggestion integer and is forced to wait on other 
acceptors/clients suggestion ID's before achieveing Paxos. 
If another proposer/client enters a larger suggesiton ID then previous client is 
forced to regain permission. If another client enters the same value as either one 
of the servers, consensus is achieved. Consensus phase is over when consensus has 
been reached and if any other proposers try to propose a value, they are denied. 
They can force quit or wait for new consensus phase 

**Note:** Acceptors and Proposers are made to fail randomly. This is implemented by 
forcing the Server/service and Client and threads to sleep, be interrupted and 
then restarted. Messages like ("Proposer stopped momentarily. Restarting proposer") 
are the messages that show that the proposer has been stopped and is being restarted.  
Same for acceptor. The random failures are implemented in the PUT,GET and DELETE 
functions.  Threads are stopped, interrupted and restarted in each of these three
 processes 



                                                                                                          






