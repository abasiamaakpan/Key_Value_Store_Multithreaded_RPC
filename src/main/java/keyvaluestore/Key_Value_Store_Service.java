package keyvaluestore;

import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreGrpc;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Key Value Store Service
 */
public class Key_Value_Store_Service extends KeyValueStoreGrpc.KeyValueStoreImplBase {
    /**Handle Milliseconds for Log**/
    public static final String format = "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS.%1$tL %1$Tp %2$s%n%4$s: %5$s%n";

    /**KEY VALUE STORE POPULATION**/
    public static final HashMap<Integer, String> hmap = new HashMap<Integer,String>()       {{
        put(1, "value1");
        put(2, "value2");
        put(3, "value3");
        put(4, "value4");
        put(5, "value5");
    }};

    static ConcurrentHashMap<Integer,Integer> remainingserverlist = new ConcurrentHashMap<Integer,Integer>(){{
        put(1, 9090);
        put(2, 9091);
        put(3, 9092);
        put(4, 9093);
        put(5, 9094);
    }};
    static ConcurrentHashMap<Integer,Integer> unavailableserverlistfromservice = new ConcurrentHashMap<Integer,Integer>();





    public static final List<String> clientList  = new ArrayList<String>();
    static  String client1="";
    static String client2="";

    /**PORT NUMBERS for all servers**/
    private static int port_number1=9090 ;
    private static int port_number2=9091 ;
    private static int port_number3=9092 ;
    private static int port_number4=9093 ;
    private static int port_number5=9094;




    /**Track Client Input**/
    static int abort=0;
    static int compile_abort=0;
    static int commit=0;
    static int compile_commit=0;
    static int prepared=0;
    static int compile_prepared=0;
    static int ca=0;
    static int commit2=0;
    static int commit3=0;


    //static int suggestioninteger=0;
    //static String suggestionstring="";
    static int storeLargestSuggestionInteger=0;
    public static final int CMD_PERMISSION_GRANTED=100;
    public static final int CMD_PERMISSION_NOT_GRANTED=50;


    /**LinkedHashSet for Listeners**/
    private static LinkedHashSet<StreamObserver<KeyValueStoreProcedures.FromServer>> observers = new LinkedHashSet<>();

    /**LinkedHashSet for Listeners in Paxos Protocol**/
    private static LinkedHashSet<StreamObserver<KeyValueStoreProcedures.PermissionGrantedorDenied>> permissionobservers = new LinkedHashSet<>();

    public static final ConcurrentHashMap<String, Integer> testing = new ConcurrentHashMap<>();

    public static final List<String> consensusFinalClientList  = new ArrayList<String>();

    private static LinkedHashSet<String> clientListhashSet = null;

    private static ArrayList<String> clientListWithoutDuplicates = null;


    private static LinkedHashSet<StreamObserver<KeyValueStoreProcedures.Dictionary>> serverobservers = new LinkedHashSet<>();


    private static int put=0;




    /**
         * PUT into HashMap
         * @param request is the key-value pair to be put into hashmap
         * @param responseObserver is the response from service if PUT is successful or not
         */
    @Override
    public synchronized void  insertKeyValue(KeyValueStoreProcedures.Pair request, StreamObserver<KeyValueStoreProcedures.SuccessfulPut> responseObserver) {

        //super.insertKeyValue(request, responseObserver);
        Logger_Function("Inside Put Function");
        int key = request.getKey();
        String value = request.getValue();
        String clientname = request.getClientname();
        int portnumber=request.getPortnumber();

        System.out.println(key);
        System.out.println(value);
        System.out.println(clientname);
        System.out.println(portnumber);

        KeyValueStoreProcedures.SuccessfulPut.Builder response = KeyValueStoreProcedures.SuccessfulPut.newBuilder();
            if (hmap.containsKey(key)) {
                System.out.println("Key exists in server: " + hmap.containsKey(key));
                try {

                    Logger_Function("Error to " + clientname + "." + " Cannot PUT: Key already taken: Enter another key");
                    response.setFailure(100).setMessage("[FROM SERVER " + portnumber + " ] Cannot PUT: Key already taken: Enter another key");
                    Logger_Function("Hashmap contents");
                    for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }

                } catch (NullPointerException a) {

                }


            }
            else {
                Logger_Function("key from " +  clientname + " : " +  key);
                Logger_Function("value from " +  clientname + " : " +  value);

                try {
                    hmap.put(key, value);
                    Logger_Function(clientname + " Key:value pair "+ key + ":" + value + " successfully stored ");
                    response.setFailure(0).setMessage("[FROM SERVER " + portnumber + " ] SUCCESSFULLY PUT " + key + ": " + value);
                    Logger_Function("Hashmap contents");
                    for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());

                    }

                } catch (NullPointerException a) {

                }

        }

        Random rand= new Random();
        if(rand.nextInt(5)==0) {
            try {
                Thread.currentThread().sleep(10000);
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
                Thread.currentThread().interrupt();
                Thread.currentThread().start();
            } catch (InterruptedException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
            } catch (IllegalThreadStateException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");

            }
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();




    }

    /**
     * GET from Hashmap
     * @param request is the key to be gotten
     * @param responseObserver is the response from service if GET is successful or not
     */
    @Override
    public synchronized void getKeyValue(KeyValueStoreProcedures.GetKey request, StreamObserver<KeyValueStoreProcedures.SuccessfulGet> responseObserver) {
        Logger_Function("Inside Get Function");
        int key = request.getInputkey();
        String clientname = request.getClientname();
        int portnumber=request.getPortnumber();


        Logger_Function(clientname + " entered Get");
        Logger_Function("key from" + clientname +  ": " + key);

        KeyValueStoreProcedures.SuccessfulGet.Builder response = KeyValueStoreProcedures.SuccessfulGet.newBuilder();


        if(hmap.isEmpty()){
            try {

                Logger_Function("Error to " + clientname + " Cannot GET: HashMap is empty: PUT some values in" );
               // printWriter.println("Cannot GET: HashMap is empty: PUT some values in");
                response.setFailure(100).setMessage("[FROM SERVER " + portnumber +" ]"+ " Cannot GET: HashMap is empty: PUT some values in");
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                    //response.setFailure(100).setMessage(entry.getKey() + " : " + entry.getValue());

                }
            } catch(NullPointerException a){

            }

        }

        else if (!hmap.containsKey(key)){
            try {

                Logger_Function("Error to " + clientname + " Cannot GET: Key does not exist: Choose another key" );
                response.setFailure(100).setMessage("[FROM SERVER " + portnumber +" ]" + " Cannot GET: Key does not exist: Choose another key");
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());

                }
            } catch (NullPointerException a) {
            }

        }
        else {
            Logger_Function("Server Checking for corresponding value for " +  key + "...............");

            try {
                String value=hmap.get(key);
                // Logger_Function("From Server to Client- " + newClient +" Got " + value + " from server " + "with key " + k);
                Logger_Function(clientname + " Got " + value + " from server ");
                response.setFailure(0).setMessage("[FROM SERVER " + portnumber +" ]" + " SUCCESSFULLY GOT " + value);
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                    //response.setFailure(100).setMessage(entry.getKey() + " : " + entry.getValue());

                }
            }catch(NullPointerException a){

            }

        }

        Random rand= new Random();
        if(rand.nextInt(5)==0) {
            try {
                Thread.currentThread().sleep(10000);
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
                Thread.currentThread().interrupt();
                Thread.currentThread().start();
            } catch (InterruptedException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
            } catch (IllegalThreadStateException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");

            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    /**
     * DELETE from Hashmap
     * @param request is the key to be deleted
     * @param responseObserver is the response from service if DELETE is successful or not
     */
    @Override
    public synchronized void deleteKeyValue(KeyValueStoreProcedures.DeleteKey request, StreamObserver<KeyValueStoreProcedures.SuccessfulDelete> responseObserver) {
       // super.deleteKeyValue(request, responseObserver);
        System.out.println("Inside Delete Function");
        int key = request.getTheinputkey();
        String clientname = request.getClientname();
        int portnumber=request.getPortnumber();
        Logger_Function(clientname + " entered Delete");
        Logger_Function("key from " + clientname +  ": " + key);

        KeyValueStoreProcedures.SuccessfulDelete.Builder response = KeyValueStoreProcedures.SuccessfulDelete.newBuilder();

        if(hmap.isEmpty()){
            try {
                //Logger_Function("Error from " + "<" + clientHandler.getInetAddress() + ">" + "<" + clientHandler.getLocalPort()+ ">."+ "Cannot DELETE: HashMap is empty: PUT some values in" );
                Logger_Function("Error from " + clientname +"."+" Cannot DELETE: HashMap is empty: PUT some values in" );

                response.setFailure(100).setMessage("[FROM SERVER " + portnumber +" ]" +  " Cannot DELETE: HashMap is empty: PUT some values in");
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());

                }
            } catch(NullPointerException a){

            }

        }
        else if (!hmap.containsKey(key)) {

            try {

                Logger_Function("Error from " + clientname +"."+" Cannot DELETE: Key does not exist: Choose another key" );

                response.setFailure(100).setMessage("[FROM SERVER " + portnumber +" ]" +  " Cannot DELETE: Key does not exist: Choose another key");
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());

                }
            } catch(NullPointerException a){

            }

        }
        else {

            try {
                response.setFailure(0).setMessage("[FROM SERVER " + portnumber +" ]" + " SUCCESSFULLY DELETED " + key);
                hmap.remove(key);
                Logger_Function(clientname + " deleted key " + key );

                //Logger_Function("From Server to Client- " + newClient + ":" + k + "deleted");
               // printWriter.println("Key " + k + "deleted");
                Logger_Function("Hashmap contents");
                for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                    //response.setFailure(100).setMessage(entry.getKey() + " : " + entry.getValue());
                }

            } catch (NullPointerException a){

            }

        }

        Random rand= new Random();
        if(rand.nextInt(5)==0) {
            try {
                Thread.currentThread().sleep(10000);
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
                Thread.currentThread().interrupt();
                Thread.currentThread().start();
            } catch (InterruptedException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");
            } catch (IllegalThreadStateException e) {
                System.out.println("Acceptor stopped momentarily. Restarting acceptor......");

            }
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    /**
     * Message that server has been shutdown
     * @param request is the request from clients
     * @param responseObserver is the response to the client when sever is shutdown
     */
    @Override
    public void sendServerShutdown(KeyValueStoreProcedures.ServerShutdown request, StreamObserver<KeyValueStoreProcedures.ServerShutdown> responseObserver) {

       System.out.println("Server " + request.getServername()+ " shutdown");

       //responseObserver.onNext(response.build());
       // responseObserver.onCompleted();
    }

    /**
     *  Client Exists
     * @param request is the client to exit
     * @param responseObserver is the response from service if client successfully exists
     */
    @Override
    public synchronized void clientExited(KeyValueStoreProcedures.ClientExit request, StreamObserver<KeyValueStoreProcedures.SuccessfulExit> responseObserver) {
        System.out.println("Inside Exit Function");

        System.out.println(request.getClientname()+ " exited");

    }

    /**
     * Client initiated
     * @param request is the initiated client
     * @param responseObserver is the response from service if client successfully initiates
     */
    @Override
    public synchronized void enterNameofClient(KeyValueStoreProcedures.SendNameofClient request, StreamObserver<KeyValueStoreProcedures.SendNameofClient> responseObserver) {
        // super.deleteKeyValue(request, responseObserver);
        System.out.println(request.getNameofclient() + " started");
        clientList.add(request.getNameofclient());
        clientListhashSet=new LinkedHashSet<String>(clientList);
        clientListWithoutDuplicates=new ArrayList<String>(clientListhashSet);

        //KeyValueStoreProcedures.SendNameofClient.Builder response = KeyValueStoreProcedures.SendNameofClient.newBuilder();
    }

    /**
     * Client action when they choose to exit
     * @param request is the request from the client to shutdown itself when all servers are down
     * @param responseObserver is the response to client on successful removal from network
     */
    @Override
    public void removeClients(KeyValueStoreProcedures.removeClientsFromList request, StreamObserver<KeyValueStoreProcedures.removeClientsFromList> responseObserver) {
        //super.removeClients(request, responseObserver);
        System.out.println("removingClients");
       clientListWithoutDuplicates.remove(request.getClientName());

    }

    /**
     * Check if a server is available (Currently not in use)
     * @param responseObserver is the response to client to confirm availability
     * @return confirmed server availability
     */
    @Override
    public StreamObserver<KeyValueStoreProcedures.BringServerDown> serverAvailabilityCheck(StreamObserver<KeyValueStoreProcedures.Dictionary> responseObserver) {
        //return super.serverAvailabilityCheck(responseObserver);
        serverobservers.add(responseObserver);
        return new StreamObserver<KeyValueStoreProcedures.BringServerDown>() {
            @Override
            public void onNext(KeyValueStoreProcedures.BringServerDown bringServerDown) {

                for(StreamObserver<KeyValueStoreProcedures.Dictionary> observer : serverobservers) {
                    //KeyValueStoreProcedures.Dictionary.Builder response = KeyValueStoreProcedures.Dictionary.newBuilder();

                    int targetserver=bringServerDown.getServertobringdown();

                    if(remainingserverlist.isEmpty()){

                        //response.setMessage("Server List Empty");
                        observer.onNext(KeyValueStoreProcedures.Dictionary.newBuilder().setMessage("Server List Empty").build());

                    }


                    //for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
                    else if(!remainingserverlist.containsValue(targetserver)){


                        observer.onNext(KeyValueStoreProcedures.Dictionary.newBuilder().putAllPairs(remainingserverlist).setMessage("Server Non Existent or Already Down").build());

                        //response.putAllPairs(remainingserverlist).setMessage("Server Non Existent or Already Down");

                        for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
                            Integer value = i.getValue();
                            //System.out.println( "Server: " + value);
                        }
                        //break;
                    }
                    else if(remainingserverlist.containsValue(targetserver)){
                        remainingserverlist.values().remove(targetserver);
                        for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
                            Integer value = i.getValue();
                            //System.out.println( "Server: " + value);
                        }
                        observer.onNext(KeyValueStoreProcedures.Dictionary.newBuilder().putAllPairs(remainingserverlist).setMessage("Server Down").build());

                       // response.putAllPairs(remainingserverlist).setMessage("Server Down");

                        //break;
                    }


                }


            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }

    /**
     * Validate suggestion integer from proposer
     * @param responseObserver is the callback from server/acceptor to call with validated suggestion integer
     * @return validated response from acceptor
     */
    @Override
    public synchronized StreamObserver<KeyValueStoreProcedures.PermissionRequest> communicateWithProposers(StreamObserver<KeyValueStoreProcedures.PermissionGrantedorDenied> responseObserver) {
        //return super.communicateWithProposers(responseObserver);
        permissionobservers.add(responseObserver);

        return new StreamObserver<KeyValueStoreProcedures.PermissionRequest>() {

            @Override
            public void onNext(KeyValueStoreProcedures.PermissionRequest permissionRequest) {
                System.out.println(permissionRequest);
                for(StreamObserver<KeyValueStoreProcedures.PermissionGrantedorDenied> observer : permissionobservers)  {


                    int suggestioninteger=permissionRequest.getSuggestioninteger();
                    String suggestionstring=permissionRequest.getSuggestionstring();
                    String clientname = permissionRequest.getClientname();

                    testing.put(clientname, suggestioninteger);

                    for (ConcurrentHashMap.Entry<String,Integer> i : testing.entrySet()){
                        String cname = i.getKey();
//                        System.out.println("From client. After Put. The suggestion integer is " + i.getValue());
//                        System.out.println("From client. After Put. Client Name is " + cname);

                        int suggint = i.getValue();

                        if(suggint >= storeLargestSuggestionInteger){
                           // System.out.println("storeLargestSuggestionInteger >= suggint" );
                            storeLargestSuggestionInteger=suggint;
                            //storeLargestSuggestionString=suggstr;
                            System.out.println(cname + ": " + storeLargestSuggestionInteger);
                            //System.out.println(cname + ": " + storeLargestSuggestionString );
                            observer.onNext(KeyValueStoreProcedures.PermissionGrantedorDenied.newBuilder().setPermreq(permissionRequest).setMessage(CMD_PERMISSION_GRANTED).setClientname(clientname).setSuggestionint(storeLargestSuggestionInteger).build());
                           // System.out.println("storeLargestSuggestionInteger"+ storeLargestSuggestionInteger);
                            break;


                        }


                        else {
                           // System.out.println(" storeLargestSuggestionInteger < suggint || suggint == storeLargestSuggestionInteger && suggstr < 0" );
                            System.out.println(cname + ": " + storeLargestSuggestionInteger);
                            System.out.println("Suggestion Integer" + ": " + suggint );
                            observer.onNext(KeyValueStoreProcedures.PermissionGrantedorDenied.newBuilder().setPermreq(permissionRequest).setMessage(CMD_PERMISSION_NOT_GRANTED).setClientname(clientname).setSuggestionint(storeLargestSuggestionInteger).build());
                            //System.out.println("storeLargestSuggestionInteger"+ storeLargestSuggestionInteger);

                            //send rejected to client
                            break;

                        }

                    }

                }

            }
            @Override
            public void onError(Throwable throwable) {


            }

            @Override
            public void onCompleted() {

            }
        };

    }



    /**
     * Bidrectional communication with all Clients
     * @param responseObserver is the response to client tracker
     * @return the response to the client
     */
    @Override
    public synchronized StreamObserver<KeyValueStoreProcedures.Broadcasttoallclients> chat(StreamObserver<KeyValueStoreProcedures.FromServer> responseObserver) {
        observers.add(responseObserver);
        //return super.chat(responseObserver);

        return new StreamObserver<KeyValueStoreProcedures.Broadcasttoallclients>() {
            @Override
            public void onNext(KeyValueStoreProcedures.Broadcasttoallclients broadcasttoallclients) {
                System.out.println(broadcasttoallclients);
                for(StreamObserver<KeyValueStoreProcedures.FromServer> observer : observers)  {
                   // observer.onNext(KeyValueStoreProcedures.FromServer.newBuilder().setMessage(broadcasttoallclients).build());

                  abort= broadcasttoallclients.getSendabort();
                  commit2=broadcasttoallclients.getSendcommit();
                  prepared= broadcasttoallclients.getSendprepared();

                  client1=broadcasttoallclients.getClientname();
                  client2=broadcasttoallclients.getClientname();



                  //System.out.println("Testing abort before calculation " + abort);
                  //System.out.println("Testing compile_abort before calculation " + compile_abort);
                  //System.out.println("Testing commit2 " + commit2);


                  compile_abort=compile_abort+abort;
                  compile_commit=abort+abort;



                   // System.out.println("Testing abort before calculation " + abort);
                  //  System.out.println("Testing compile_abort after calculation " + compile_abort);
                  //  System.out.println("Testing commit2 " + commit2)

                    /**send abort to clients**/
                    if (abort==5){
                        observer.onNext(KeyValueStoreProcedures.FromServer.newBuilder().setMessage(broadcasttoallclients).setCheckabort(abort).build());
                    }

                    /**send prepared to clients**/
                    if(abort==6){
                        commit=abort;
                        //commit2
                        abort=0;


                    }

                    /**send prepared to clients**/
                    if (prepared==7){
                        observer.onNext(KeyValueStoreProcedures.FromServer.newBuilder().setMessage(broadcasttoallclients).setCheckprepared(prepared).build());
                        prepared=0;
                        // compile_prepared=0;
                    }


                    /**send abort to clients**/
                    if(commit+abort==11){
                        ca=commit+abort;
                        observer.onNext(KeyValueStoreProcedures.FromServer.newBuilder().setMessage(broadcasttoallclients).setCheckabort(ca).build());
                        commit=0;
                        abort=0;
                        ca=0;

                    }

                    /**send commit to clients**/
                    if(compile_abort==24){
                       // ca=commit+abort;
                        commit3=compile_abort;
                       // System.out.println(commit3);
                        observer.onNext(KeyValueStoreProcedures.FromServer.newBuilder().setMessage(broadcasttoallclients).setCheckglobalcommit(commit3).build());
                        commit=0;
                        abort=0;
                        compile_abort=0;
                        commit3=0;
                    }

                }

            }
            @Override
            public void onError(Throwable throwable) {
                observers.remove(responseObserver);
                responseObserver.onError(throwable);

            }

            @Override
            public void onCompleted() {
                observers.remove(responseObserver);
            }
        };

    }

    /**
     * Client request for server lists
     * @param request is the client request
     * @param responseObserver is the server list response
     */
    @Override
    public void requestServerList(KeyValueStoreProcedures.RequestListofServers request, StreamObserver<KeyValueStoreProcedures.Dictionary> responseObserver) {
        //super.requestServerList(request, responseObserver);
        KeyValueStoreProcedures.Dictionary.Builder response = KeyValueStoreProcedures.Dictionary.newBuilder();
        response.putAllPairs(remainingserverlist);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    /**
     * Clients request to remove server
     * @param request is the request to remove a server
     * @param responseObserver is the response for client to take a decision on removed server
     */
    @Override
    public void removeServer(KeyValueStoreProcedures.BringServerDown request, StreamObserver<KeyValueStoreProcedures.Dictionary> responseObserver) {
        //super.removeServer(request, responseObserver);
        KeyValueStoreProcedures.Dictionary.Builder response = KeyValueStoreProcedures.Dictionary.newBuilder();

        int targetserver=request.getServertobringdown();

        if(remainingserverlist.isEmpty()){
            //System.out.println("You called");
            response.setMessage("Server List Empty");

        }


        //for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
        else if(!remainingserverlist.containsValue(targetserver)){



            response.putAllPairs(remainingserverlist).setMessage("Server Non Existent or Already Down");

            for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
                Integer value = i.getValue();
                //System.out.println( "Server: " + value);
            }
            //break;
        }
        else if(remainingserverlist.containsValue(targetserver)){
               remainingserverlist.values().remove(targetserver);
            for (ConcurrentHashMap.Entry<Integer,Integer> i : remainingserverlist.entrySet()) {
                Integer value = i.getValue();
                //
                // System.out.println( "Server: " + value);
            }
            response.putAllPairs(remainingserverlist).setMessage("Server Down");

            //break;
        }

        //}


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    /**
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public synchronized void namesOfClients(KeyValueStoreProcedures.GetNamesofClients request, StreamObserver<KeyValueStoreProcedures.ListofClients> responseObserver) {
        //super.namesOfClients(request, responseObserver);

        KeyValueStoreProcedures.ListofClients.Builder response = KeyValueStoreProcedures.ListofClients.newBuilder();

        response.setMessage(clientListWithoutDuplicates.size());

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    /**
     * Determine consensus in application
     * @param request is the request to determine consensus
     * @param responseObserver is the callback from server/acceptor to call with decision on consensus
     */
    @Override
    public void consensus(KeyValueStoreProcedures.SendConsensus request, StreamObserver<KeyValueStoreProcedures.ClientConsensus> responseObserver) {
        //super.consensus(request, responseObserver);
        KeyValueStoreProcedures.ClientConsensus.Builder response = KeyValueStoreProcedures.ClientConsensus.newBuilder();


        consensusFinalClientList.add(request.getClientname());
        System.out.println("List with duplicates" + consensusFinalClientList.size());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(consensusFinalClientList);
        ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);


            try {
            Thread.currentThread().sleep(10000);

                System.out.println("List without duplicates" + listWithoutDuplicates.size());


                if(consensusFinalClientList.size() < 2) {

                response.setMessage("Consensus Not Reached");
                    listWithoutDuplicates.clear();

            }

            else if(listWithoutDuplicates.size() == 2) {

                    response.setMessage(String.valueOf(consensusFinalClientList.size()));
            }

            else if(listWithoutDuplicates.size() > 2) {
                    response.setMessage(String.valueOf(consensusFinalClientList.size()));

                    consensusFinalClientList.clear();
                   listWithoutDuplicates.clear();
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    /**
     * Not used
     * @param request
     * @param responseObserver
     */
    @Override
    public synchronized void acceptabortorcommit(KeyValueStoreProcedures.Abortorcommit request, StreamObserver<KeyValueStoreProcedures.SuccessfulAbort> responseObserver) {
        System.out.println("Inside acceptabortorcommit");
        int acceptabortcommit = request.getAborco();
        System.out.println(acceptabortcommit);
        //String clientname = request.getClientname();

        KeyValueStoreProcedures.SuccessfulAbort.Builder response = KeyValueStoreProcedures.SuccessfulAbort.newBuilder();

        if(acceptabortcommit == 5) {

            System.out.println(acceptabortcommit);

            response.setFailure(0).setMessage("ABORT");

        }
    }

    /**
     * Function to log to server/client
     * @param message is the message to be displayed on the logger
     */
    public  static synchronized void Logger_Function(String message) {
        LogRecord record = new LogRecord(Level.INFO, message);
        System.out.println(String.format(format,
                new java.util.Date(record.getMillis()),
                record.getSourceClassName(),
                record.getLoggerName(),
                record.getLevel().getLocalizedName(),
                record.getMessage(),
                String.valueOf(record.getThrown())));

    }








}
