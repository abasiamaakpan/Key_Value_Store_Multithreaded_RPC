package ClientPackage;

import ServerPackage.GRPCServer;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreGrpc;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
//import javafx.application.Platform;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static ClientPackage.GRPCClient7.ClientHandler.Logger_Function;

/**
 * GRPC CLIENT
 */
public class GRPCClient8 {
    /**Handle Milliseconds for Log**/
    public static final String format = "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS.%1$tL %1$Tp %2$s%n%4$s: %5$s%n";
    /**
     * PROTOCOLS FOR KEY VALUE STORE
     **/
    public static final int CMD_PUT = 1;
    public static final int CMD_GET = 2;
    public static final int CMD_DEL = 3;
    public static final int CMD_PREPARED = 7;
    public static final int CMD_ABORT = 5;
    public static final int CMD_ONE_CLIENT_ABORTS = 11;
    public static final int CMD_COMMIT =24 ;
    public static final int PERMISSION_REQUEST=30;
    public static final int CMD_PERMISSION_GRANTED=100;
    public static final int CMD_PERMISSION_NOT_GRANTED=50;
    public static final int SUGGESTION_MESSAGE=25;




    /**PORT NUMBERS for all servers**/
    private static String port_number1="9090" ;
    private static String port_number2="9091" ;
    private static String port_number3="9092" ;
    private static String port_number4="9093" ;
    private static String port_number5="9094" ;



    /**
     * Channel for communication between client and server
     */
    public static ManagedChannel channel;
    public static ManagedChannel channel2;
    public static ManagedChannel channel3;
    public static ManagedChannel channel4;
    public static ManagedChannel channel5;
    public static  ClientHandler chandler;

    /** List of port numbers available**/
    public static ArrayList<Integer> unavailableserversWithoutDuplicates= new ArrayList<Integer>();


    /**
     * Determine if client has already shut off more than 1 server
     */
    static int loopcount=0;

    /**
     * Clientname
     */
    public static final String sendclientname="Client 8";

    /**
     * List of unavailable servers
     */
    private static LinkedHashSet<Integer> unavailableservers = null;





    public static void main(String args[]) {

        try {
            if (args.length == 0) {
                System.out.println("<Usage: java -jar your_directory_here <jarfilepath> <portnumber>");
            }

        /**
         * Create channel with host name and port number
         */
        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(args[0])).usePlaintext().build();
        channel2 = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(port_number2)).usePlaintext().build();
        channel3 = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(port_number3)).usePlaintext().build();
        channel4 = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(port_number4)).usePlaintext().build();
        channel5 = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(port_number5)).usePlaintext().build();
        KeyValueStoreProcedures.SendNameofClient nameofclient = KeyValueStoreProcedures.SendNameofClient.newBuilder().setNameofclient(sendclientname).build();
        StreamObserver<KeyValueStoreProcedures.SendNameofClient> responseob = null;

        /**New asynchronous stubs are instantiated for each channel**/
        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub = KeyValueStoreGrpc.newStub(channel);
        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub2 = KeyValueStoreGrpc.newStub(channel2);
        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub3 = KeyValueStoreGrpc.newStub(channel3);
        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub4 = KeyValueStoreGrpc.newStub(channel4);
        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub5 = KeyValueStoreGrpc.newStub(channel5);


        /**Send client information to all server**/
        enterNameofClientStub.enterNameofClient(nameofclient, responseob);
        enterNameofClientStub2.enterNameofClient(nameofclient, responseob);
        enterNameofClientStub3.enterNameofClient(nameofclient, responseob);
        enterNameofClientStub4.enterNameofClient(nameofclient, responseob);
        enterNameofClientStub5.enterNameofClient(nameofclient, responseob);

        /**Start Client**/
        int counter = 0;
        counter++;
        System.out.println(" >> " + sendclientname +" started!");
        chandler = new ClientHandler(counter);

        /**
         * Initial Loading up of array for unavailable servers
         */
        unavailableserversWithoutDuplicates= new ArrayList<Integer>(5);
        for (int i = 0; i < 5; i++) {
            unavailableserversWithoutDuplicates.add(0);
        }

        //remainingserverlist= new ConcurrentHashMap<Integer,Integer>(5);


        chandler.start();

        /**
         * Proposer failure and restart
         *
         */
        Random rand= new Random();
        if(rand.nextInt(5)==0) {
            try {
                chandler.sleep((long) (Math.random() * 10000));
                System.out.println("Proposer stopped momentarily. Restarting proposer");
                chandler.start();
                System.out.println("Proposer stopped momentarily. Restarting proposer");
                chandler.interrupt();
            } catch (InterruptedException e) {
                System.out.println("Proposer stopped momentarily. Restarting proposer");
            } catch (IllegalThreadStateException e) {
                System.out.println("Proposer stopped momentarily. Restarting proposer");

            } catch (ExceptionInInitializerError c) {

            }
        }
        } catch (ArrayIndexOutOfBoundsException a){

    }

    }

    /**
     * Create client thread
     */
    public static class ClientHandler extends Thread{
        int newClient;
        /**
         * Readers for user input
         */
        BufferedReader commandreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader keyreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader valuereader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader commitorabortreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader preparetocommitorabortreader = new BufferedReader(new InputStreamReader(System.in));
        static  BufferedReader yornreader = new BufferedReader(new InputStreamReader(System.in));
        static  BufferedReader shutdownreader = new BufferedReader(new InputStreamReader(System.in));

        static  BufferedReader suggintreader = new BufferedReader(new InputStreamReader(System.in));
        static BufferedReader suggstrreader = new BufferedReader(new InputStreamReader(System.in));
        static BufferedReader validate_suggestion_reader = new BufferedReader(new InputStreamReader(System.in));



        /**Key Store Variables**/
        int command = 0;
        int key = 0;
        String value = "";
        int server_number=0;
        int commitorabort=0;
        int preparetocommitorabort=0;
        static int suggint=0;
        static String suggstr="";
        static boolean df=true;
        static int right_suggestion_integer=0;
        static int validate_suggestion_integer=0;
        static int storeSuggint=0;


        int forsuggestioninteger=0;
        String forsuggestionstring="";

        static KeyValueStoreProcedures.ListofClients re=null;
        static KeyValueStoreProcedures.ServerShutdown servshutdown=null;
        static KeyValueStoreProcedures.ClientConsensus consensus=null;





        ClientHandler(int counter){
            //clientHandler = fromClientSocket;
            newClient=counter;
        }

        /**New synchronous stubs are instantiated for each channel**/
        static  KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub = KeyValueStoreGrpc.newBlockingStub(channel);
        static KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub2 = KeyValueStoreGrpc.newBlockingStub(channel2);
        static  KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub3 = KeyValueStoreGrpc.newBlockingStub(channel3);
        static  KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub4 = KeyValueStoreGrpc.newBlockingStub(channel4);
        static  KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub5 = KeyValueStoreGrpc.newBlockingStub(channel5);
        static KeyValueStoreProcedures.FromServer e= null;
        static KeyValueStoreProcedures.PermissionGrantedorDenied pS=null;
        static StreamObserver<KeyValueStoreProcedures.PermissionRequest> permissionobserver = null;
        static StreamObserver<KeyValueStoreProcedures.BringServerDown> serverobserver = null;





        /**
         * Start client
         */
        public void run() {
            try {



                KeyValueStoreProcedures.GetNamesofClients r = KeyValueStoreProcedures.GetNamesofClients.newBuilder().setRequestnamesofClients("Ask For Clients").build();
                ;

                //request.getKey()=key;
                /**
                 * Contact the multiple servers
                 */

                re = syncKeyValueStoreStub.namesOfClients(r);

                System.out.println(re.getMessage());

                /**
                 * Check for valid commands which are PUT,GET,DELETE.
                 * This is the Communication logic with the client
                 *
                 */

                while (true) {

                    // int right_server_number = specifyServerNumber(server_number,serverreader);
                    // int right_commit_or_abort=validateCommitorAbort(commitorabort,commitorabortreader);

                    /**New asynchronous stubs are instantiated for each channel**/
                    KeyValueStoreGrpc.KeyValueStoreStub bidirectionalStreamStub = KeyValueStoreGrpc.newStub(channel5);

                    //while(df) {
                    /** Gain permission from acceptors**/
                    permissionobserver = bidirectionalStreamStub.communicateWithProposers(new StreamObserver<KeyValueStoreProcedures.PermissionGrantedorDenied>() {

                        @Override
                        public void onNext(KeyValueStoreProcedures.PermissionGrantedorDenied permissionGrantedorDenied) {
                            // while(df) {
                            pS = permissionGrantedorDenied;

                            System.out.println("FROM" + sendclientname + ": " + suggint);

                            System.out.println("FROM" + permissionGrantedorDenied.getClientname() + ": " + permissionGrantedorDenied.getSuggestionint());
                            if(storeSuggint < permissionGrantedorDenied.getPermreq().getSuggestioninteger()) {
                                storeSuggint = permissionGrantedorDenied.getPermreq().getSuggestioninteger();
                                //System.out.println("THIS IS THE MAIN VALUE YOU NEED TO WORK" + storeSuggint);

                            }
                            if (permissionGrantedorDenied.getMessage() == CMD_PERMISSION_GRANTED && (suggint >= permissionGrantedorDenied.getSuggestionint())) {
                                System.out.println("Request Granted. The highest proposal was "  + permissionGrantedorDenied.getPermreq().getSuggestioninteger());
                                //break;
                                df = false;

                            } else if (permissionGrantedorDenied.getMessage() == CMD_PERMISSION_NOT_GRANTED && (suggint < permissionGrantedorDenied.getSuggestionint())) {
                                //System.out.println("Request Not Granted-Enter the same or higher proposal pair. The highest proposal was " + "(" + permissionGrantedorDenied.getPermreq().getSuggestioninteger() + ',' + permissionGrantedorDenied.getPermreq().getSuggestionstring()+ ")");
                                System.out.println(df);
                                System.out.println("Request Not Granted-Enter the same or higher proposal value. The highest proposal was " + permissionGrantedorDenied.getSuggestionint());

                            }else if (suggint < permissionGrantedorDenied.getSuggestionint()){
                                System.out.println("Request Not Granted-Enter the same or higher proposal value. The highest proposal was " + permissionGrantedorDenied.getSuggestionint() + " you might need to restart the permission process");

                            }
                        }
                        /**
                         * Error Checking
                         **/
                        @Override
                        public void onError(Throwable throwable) {


                        }

                        @Override
                        public void onCompleted() {


                        }


                    });

                    /**Specify server to be contacted**/
                    int c=2;
                    int right_server_number = specifyServerPortNumber(server_number, serverreader,c);


                    //System.out.println("Are specifying server number");
                    /**  Validate command from client**/
                    int right_command = validateCommand(command, commandreader);
                    //System.out.println("After validating command");

                    int right_key;
                    String right_value;
                    //Thread.sleep(2000);



                    /**
                     * Check if command from client is PUT
                     */
                    if (right_command == CMD_PUT) {


                        //   stub2.send_Command_To_Server_get_Command_From_Client(right_command);

                        right_key = validateKey(key, keyreader);
                        // stub2.send_Key_To_Server_get_Key_From_Client(right_key);

                        right_value = validateValue(value, valuereader);
                        // stub2.send_Value_To_Server_get_Value_From_Client(right_value);
                        initiatePaxos();


                        //if(right_suggestion_integer >= storeSuggint){

                        //else {
                        // in need to check what your suggestion int value is
                        validate_suggestion_integer = validateAcceptanceofSuggestionInteger(suggint, right_suggestion_integer, validate_suggestion_reader);

                        KeyValueStoreProcedures.Pair request = null;

                        //request.getKey()=key;
                        /**
                         * Contact the multiple servers
                         */
                        if (right_server_number == Integer.parseInt(port_number1)) {
                            request=KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulPut response = syncKeyValueStoreStub.insertKeyValue(request);

                            Logger_Function(response.getMessage());
//                            syncKeyValueStoreStub2.insertKeyValue(request);
//                            syncKeyValueStoreStub3.insertKeyValue(request);
//                            syncKeyValueStoreStub4.insertKeyValue(request);
//                            syncKeyValueStoreStub5.insertKeyValue(request);


                        } else if (right_server_number == Integer.parseInt(port_number2)) {
                            request=KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulPut response2 = syncKeyValueStoreStub2.insertKeyValue(request);

                            Logger_Function(response2.getMessage());
//                            syncKeyValueStoreStub.insertKeyValue(request);
//                            syncKeyValueStoreStub3.insertKeyValue(request);
//                            syncKeyValueStoreStub4.insertKeyValue(request);
//                            syncKeyValueStoreStub5.insertKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number3)) {
                            request=KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulPut response3 = syncKeyValueStoreStub3.insertKeyValue(request);

                            Logger_Function(response3.getMessage());
//                            syncKeyValueStoreStub.insertKeyValue(request);
//                            syncKeyValueStoreStub2.insertKeyValue(request);
//                            syncKeyValueStoreStub4.insertKeyValue(request);
//                            syncKeyValueStoreStub5.insertKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number4)) {
                            request=KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulPut response4 = syncKeyValueStoreStub4.insertKeyValue(request);

                            Logger_Function(response4.getMessage());
//                            syncKeyValueStoreStub.insertKeyValue(request);
//                            syncKeyValueStoreStub2.insertKeyValue(request);
//                            syncKeyValueStoreStub3.insertKeyValue(request);
//                            syncKeyValueStoreStub5.insertKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number5)) {
                            request=KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulPut response5 = syncKeyValueStoreStub5.insertKeyValue(request);

                            Logger_Function(response5.getMessage());
//                            syncKeyValueStoreStub.insertKeyValue(request);
//                            syncKeyValueStoreStub2.insertKeyValue(request);
//                            syncKeyValueStoreStub3.insertKeyValue(request);
//                            syncKeyValueStoreStub4.insertKeyValue(request);
                        }

                        /**
                         * Check if command from client is GET
                         */
                    } else if (right_command == CMD_GET) {
                        right_key = validateKey(key, keyreader);

                        KeyValueStoreProcedures.GetKey request = null;
                        /**
                         * Contact the multiple servers
                         */
                        if (right_server_number == Integer.parseInt(port_number1)) {
                            request=KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulGet response = syncKeyValueStoreStub.getKeyValue(request);

                            Logger_Function(response.getMessage());

//                            syncKeyValueStoreStub2.getKeyValue(request);
//                            syncKeyValueStoreStub3.getKeyValue(request);
//                            syncKeyValueStoreStub4.getKeyValue(request);
//                            syncKeyValueStoreStub5.getKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number2)) {
                            request=KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulGet response2 = syncKeyValueStoreStub2.getKeyValue(request);

                            Logger_Function(response2.getMessage());
//                            syncKeyValueStoreStub.getKeyValue(request);
//                            syncKeyValueStoreStub3.getKeyValue(request);
//                            syncKeyValueStoreStub4.getKeyValue(request);
//                            syncKeyValueStoreStub5.getKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number3)) {
                            request=KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulGet response3 = syncKeyValueStoreStub3.getKeyValue(request);

                            Logger_Function(response3.getMessage());
//                            syncKeyValueStoreStub.getKeyValue(request);
//                            syncKeyValueStoreStub2.getKeyValue(request);
//                            syncKeyValueStoreStub4.getKeyValue(request);
//                            syncKeyValueStoreStub5.getKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number4)) {
                            request=KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulGet response4 = syncKeyValueStoreStub4.getKeyValue(request);

                            Logger_Function(response4.getMessage());
//                            syncKeyValueStoreStub.getKeyValue(request);
//                            syncKeyValueStoreStub2.getKeyValue(request);
//                            syncKeyValueStoreStub3.getKeyValue(request);
//                            syncKeyValueStoreStub5.getKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number5)) {
                            request=KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulGet response5 = syncKeyValueStoreStub5.getKeyValue(request);

                            Logger_Function(response5.getMessage());
//                            syncKeyValueStoreStub.getKeyValue(request);
//                            syncKeyValueStoreStub2.getKeyValue(request);
//                            syncKeyValueStoreStub3.getKeyValue(request);
//                            syncKeyValueStoreStub4.getKeyValue(request);
                        }

                        /**
                         * Check if command from client is DELETE
                         */
                    } else if (right_command == CMD_DEL) {


                        //if(right_suggestion_integer >= storeSuggint){

                        //else {
                        // in need to check what your suggestion int value is
                        right_key = validateKey(key, keyreader);

                        initiatePaxos();
                        validate_suggestion_integer = validateAcceptanceofSuggestionInteger(suggint, right_suggestion_integer, validate_suggestion_reader);

                        KeyValueStoreProcedures.DeleteKey request = null;
                        /**
                         * Contact the multiple servers
                         */
                        if (right_server_number == Integer.parseInt(port_number1)) {
                            request=KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulDelete response = syncKeyValueStoreStub.deleteKeyValue(request);

                            Logger_Function(response.getMessage());
//                            syncKeyValueStoreStub2.deleteKeyValue(request);
//                            syncKeyValueStoreStub3.deleteKeyValue(request);
//                            syncKeyValueStoreStub4.deleteKeyValue(request);
//                            syncKeyValueStoreStub5.deleteKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number2)) {
                            request=KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulDelete response2 = syncKeyValueStoreStub2.deleteKeyValue(request);

                            Logger_Function(response2.getMessage());
//                            syncKeyValueStoreStub.deleteKeyValue(request);
//                            syncKeyValueStoreStub3.deleteKeyValue(request);
//                            syncKeyValueStoreStub4.deleteKeyValue(request);
//                            syncKeyValueStoreStub5.deleteKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number3)) {
                            request=KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulDelete response3 = syncKeyValueStoreStub3.deleteKeyValue(request);

                            Logger_Function(response3.getMessage());
//                            syncKeyValueStoreStub.deleteKeyValue(request);
//                            syncKeyValueStoreStub2.deleteKeyValue(request);
//                            syncKeyValueStoreStub4.deleteKeyValue(request);
//                            syncKeyValueStoreStub5.deleteKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number4)) {
                            request=KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulDelete response4 = syncKeyValueStoreStub4.deleteKeyValue(request);

                            Logger_Function(response4.getMessage());
//                            syncKeyValueStoreStub.deleteKeyValue(request);
//                            syncKeyValueStoreStub2.deleteKeyValue(request);
//                            syncKeyValueStoreStub3.deleteKeyValue(request);
//                            syncKeyValueStoreStub5.deleteKeyValue(request);
                        } else if (right_server_number == Integer.parseInt(port_number5)) {
                            request=KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).setPortnumber(right_server_number).build();

                            KeyValueStoreProcedures.SuccessfulDelete response5 = syncKeyValueStoreStub5.deleteKeyValue(request);

                            Logger_Function(response5.getMessage());
//                            syncKeyValueStoreStub.deleteKeyValue(request);
//                            syncKeyValueStoreStub2.deleteKeyValue(request);
//                            syncKeyValueStoreStub3.deleteKeyValue(request);
//                            syncKeyValueStoreStub4.deleteKeyValue(request);
                        }

                    }

                }



            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } //catch (InterruptedException e1) {
            // System.out.println("Acceptor stopped momentarily. Restarting acceptor");

            // Thread t1 = new Thread();

            // t1.start();

            // }
            finally {
                Logger_Function(sendclientname + " exited!!");
                //System.exit(0);

            }


        }

        /**
         * Initiate Paxos mechanism
         */
        public static synchronized void initiatePaxos(){
            Logger_Function("Paxos is initiated");
            while (true) {


                //System.out.println(df);
                right_suggestion_integer = validateSuggestionInteger(suggint, suggintreader);
                //System.out.println(right_suggestion_integer);
                suggint = right_suggestion_integer;
                String right_suggestion_string = validateSuggestionString(suggstr, suggstrreader);
                //System.out.println(right_suggestion_string);
                //suggstr = right_suggestion_string;
                permissionobserver.onNext(KeyValueStoreProcedures.PermissionRequest.newBuilder().setClientname(sendclientname).setSuggestioninteger(right_suggestion_integer).setSuggestionstring(right_suggestion_string).build());
                try {
                    //System.out.println("Client name from server---End of Loop" + pS.getClientname());
                    //System.out.println("Checking initial suggestion integer----End of Loop " +suggint);
                    //System.out.println("Checking final suggestion integer----End of Loop " +right_suggestion_integer);
                    //System.out.println("Suggestion int from server---End of Loop" + pS.getSuggestionint());
                }catch (NullPointerException a){

                }
                try {
                    /**
                     * Give initial permission to first client
                     */
                    //here we check if the client list is less than 1
                    if ((pS==null) && (right_suggestion_integer > 0) && (re.getMessage()==1)|| (right_suggestion_integer >=pS.getSuggestionint())) {
                        break;
                    }
                } catch (NullPointerException a){

                }


            }
        }

        /**
         * Validate Command (GET,PUT,DELETE,EXIT) from Client
         * @param c is the command to be validated
         * @param cr reads the text from an Input stream
         * @return the validated command
         */
        public static synchronized int validateCommand(int c, BufferedReader cr ) {
            while (true) {
                try {
                    System.out.println("Enter 1 to PUT, 2 to GET, 3 to DELETE");
                    System.out.println("Enter Command: ");
                    c = Integer.parseInt(cr.readLine());

                    //Validate Command PUT(1),GET(2),DELETE(3),EXIT(4) from Client
                    if(c>=1 && c<=3){
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("command is not an int value or must be in range 1<=command<=3. Re-enter command");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return c;
        }


        /**
         * Validate Key from User
         * @param k is the key to be validated
         * @param kr reads the text from an Input stream
         * @return the validated key
         */
        public static synchronized int validateKey(int k, BufferedReader kr){
            while (true) {
                try {
                    System.out.println("Enter Numeric Values Only for Key");
                    System.out.println("Enter Key: ");
                    k = Integer.parseInt(kr.readLine());
                    break;
                } catch (NumberFormatException e) {
                    Logger_Function("key is not an int value. Reneter key");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return k;
        }

        /**
         * Validate Value from User
         * @param value is the value to be validated
         * @param vr reads the text from an Input stream
         * @return the validated value
         */
        public static synchronized String validateValue(String value, BufferedReader vr){
            while (true) {
                try {
                    System.out.println("Enter Alphanumeric characters, whitespaces and symbols allowed");
                    System.out.println("Enter Value: ");
                    value = vr.readLine();
                    break;
                } catch (NumberFormatException e) {
                    Logger_Function("key is not an int value. Reneter key");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return value;
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

        /**
         * Validate Server readiness
         * @param c is the command to validate readiness
         * @param pc reads the text from an Input stream
         * @return validated server readiness command
         */
        public static synchronized int preparetoCommitorAbort(int c, BufferedReader pc){
            while (true) {
                try {
                    System.out.println("Check if servers are prepared");
                    System.out.println("Enter 7 to Contact Servers");

                    c = Integer.parseInt(pc.readLine());
                    System.out.println(c);
                    if((c==7)){
                        break;
                    }
                } catch (NumberFormatException e) {
                    Logger_Function("Server port number is either not an int value, or is not in the range 9090-9094. Reneter server port number");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return c;

        }


        /**
         * Validate Client's specified server port number
         * @param serverNumber is the server port number to be validated
         * @param sn reads the text from an Input stream
         * @param s is a placeholder for shutdown command
         * @return validated server port number
         */
        public static synchronized int specifyServerPortNumber(int serverNumber, BufferedReader sn, int s){
            int falseshutdown=s;
            int shutdown=0;
            boolean df=true;
            while (true) {

                try {
                    if (loopcount==0) {
                        Logger_Function("Do you want to shutdown a server? Y/N. Enter 1 for Y, 0 for No");
                        loopcount++;
                    }
                    else {
                        Logger_Function("Do you want to shutdown another server? Y/N. Enter 1 for Y, 0 for No");

                    }

                    shutdown=yesorNo(falseshutdown);


                    /**
                     * Client declines to shut off servrr
                     */
                    if(shutdown==0) {
                        // if ((serverNumber >= 9090 && serverNumber <= 9094)) {

                        // no servers are in the kill server array
                        if(!unavailableserversWithoutDuplicates.contains(9090) && !unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090 to 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber >= 9090 && serverNumber <= 9094)) {
                                df = false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }
                        // No servers in kill server unavailableserversWithoutDuplicatesay except 9090
                        else if(unavailableserversWithoutDuplicates.contains(9090) && !unavailableserversWithoutDuplicates.contains(9091)&&!unavailableserversWithoutDuplicates.contains(9092)&&!unavailableserversWithoutDuplicates.contains(9093)&&!unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9091 to 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber >= 9091 && serverNumber <= 9094)) {
                                df = false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No servers in kill server unavailableserversWithoutDuplicatesay except 9091
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091) && !unavailableserversWithoutDuplicates.contains(9092)&&!unavailableserversWithoutDuplicates.contains(9093)&&!unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9092 to 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (((serverNumber == 9090) || (serverNumber >= 9092 && serverNumber <= 9094))) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }
                        }
                        // No servers in kill server unavailableserversWithoutDuplicatesay except 9092
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&&!unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092) &&!unavailableserversWithoutDuplicates.contains(9093)&&!unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090-9091, or 9093 to 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (((serverNumber == 9090) || (serverNumber == 9091) || (serverNumber == 9093) || (serverNumber == 9094))) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }
                        }
                        // No servers in kill server unavailableserversWithoutDuplicatesay except 9093
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&&!unavailableserversWithoutDuplicates.contains(9091)&&!unavailableserversWithoutDuplicates.contains(9092) && unavailableserversWithoutDuplicates.contains(9093) &&!unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090-9092 or 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (((serverNumber == 9090) || (serverNumber == 9091) || (serverNumber == 9092) || (serverNumber == 9094))) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }
                        // No servers in kill server unavailableserversWithoutDuplicatesay except 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&&!unavailableserversWithoutDuplicates.contains(9091)&&!unavailableserversWithoutDuplicates.contains(9092)&&!unavailableserversWithoutDuplicates.contains(9093)&& unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090-9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber >= 9090 && serverNumber <= 9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090 and 9091
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9092-9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber >= 9092 && serverNumber <= 9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090 and 9092
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9091, 9093 and 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9093 || serverNumber==9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090 and 9093
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9091-9092 and 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9092 || serverNumber==9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9091-9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9092 || serverNumber==9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9091 and 9092
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9093-9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9093 || serverNumber==9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9091 and 9093
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9092, 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9092 || serverNumber==9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9091 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9092, 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9092 || serverNumber==9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9092 and 9093
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093)&& !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9091, 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9091 || serverNumber==9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9092 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093)&& unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090, 9091, 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9091 || serverNumber==9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9093 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093)&& unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9090-9092");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9091 || serverNumber==9092)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }


                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9091 and 9092
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093) && !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number between 9093-9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber >= 9093 && serverNumber <= 9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9091 and 9093
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number  9092 or 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9092 || serverNumber == 9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9091 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number  9092 or 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9092 || serverNumber == 9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9092 and 9093
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number  9091 or 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9092 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number  9091 or 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9090, 9093 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number  9091 or 9092");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9091 || serverNumber == 9092)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }


                        // No server in kill server unavailableserversWithoutDuplicatesay except 9091, 9092 and 9093
                        else if(!unavailableserversWithoutDuplicates.contains(9090) && unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090 or 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9094)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server array except 9091, 9092 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090) && unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090 or 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9093)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server array except 9091, 9093 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090) && unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090 or 9092");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9092)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }

                        // No server in kill server unavailableserversWithoutDuplicatesay except 9092, 9093 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090) && !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090 or 9091");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if ((serverNumber == 9090 || serverNumber == 9091)) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }


                        }


                        // No server in kill server array except 9090, 9091, 9092 and 9093
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && !unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9094");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (serverNumber == 9094) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server array except 9090, 9091, 9092 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& !unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9093");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (serverNumber == 9093) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server array except 9090, 9091, 9093 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& !unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9092");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (serverNumber == 9092) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server array except 9090, 9092, 9093 and 9094
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& !unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9091");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (serverNumber == 9091) {
                                df=false;
                                break;
                            }

                            else {
                                System.out.println("Enter server number from the list");
                            }

                        }

                        // No server in kill server array except 9091, 9092, 9093 and 9094
                        else if(!unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("Enter Server Port Number 9090");
                            serverNumber = Integer.parseInt(sn.readLine());
                            System.out.println(serverNumber);
                            if (serverNumber == 9090) {
                                df=false;
                                break;
                            }
                            else {
                                System.out.println("Enter right server number");
                            }


                        }


                        // All servers in kill server array
                        else if(unavailableserversWithoutDuplicates.contains(9090)&& unavailableserversWithoutDuplicates.contains(9091)&& unavailableserversWithoutDuplicates.contains(9092)&& unavailableserversWithoutDuplicates.contains(9093) && unavailableserversWithoutDuplicates.contains(9094)){
                            System.out.println("No more servers to shutdown");
                            System.exit(0);
                            GRPCServer.stop();

                        }


                        // }
                    }
                    /**
                     * Client Decides to shut down a server
                     */
                    else  if(shutdown==1) {
                        shutdownServer(serverNumber, shutdown);
                        break;
                    }

                } catch (NumberFormatException e) {
                    Logger_Function("Server port number is either not an int value, or is not in the range suggested. Reneter server port number");
                } catch (IOException e1 ) {
                    e1.printStackTrace();
                }  catch (NullPointerException e1) {
                    //e1.printStackTrace();
                }
            }
            loopcount=0;
            unavailableserversWithoutDuplicates.clear();
            return serverNumber;

        }

        /**
         * Validate Option to shut a server or not
         * @param yorn is either yes or no
         * @return validated option to shut server
         */

        public static synchronized int yesorNo(int yorn){
            while (true) {
                try {
                    Logger_Function("Enter 1 for Y, 0 for No");
                    yorn = Integer.parseInt(yornreader.readLine());
                    if(yorn==0 || yorn==1){
                        break;
                    }

                } catch (NumberFormatException e) {
                    Logger_Function("Not a valid option. Choose 1 for Y or 0 for N");

                    //Logger_Function("Server port number is either not an int value, or is not in the range 9090-9094. Reneter server port number");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return yorn;

        }


        public static synchronized int validateservertoshutdown(int serverNumber){

            while (true) {
                try {
                    System.out.println("Enter Server from List above to shutdown");
                    serverNumber = Integer.parseInt(shutdownreader.readLine());
                    if((serverNumber>=9090 && serverNumber<=9094)){
                        break;
                    }
                } catch (NumberFormatException e) {
                    Logger_Function("Server port number is either not an int value, or is not in the range 9090-9094. Reneter server port number");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return serverNumber;

        }

        /**
         * Shutdown server
         * @param servertoshutdown is the server to be shutdown
         * @param command is the command to shut a server or not
         */
        public static synchronized void shutdownServer(int servertoshutdown, int command){
            BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
            int falseservtoshutdown=0;

            try {
                System.out.println("Choose server(s) to shutdown. Select from remaining server list");
                KeyValueStoreProcedures.RequestListofServers serversavailable = KeyValueStoreProcedures.RequestListofServers.newBuilder().setListofservers("What Servers are available?").build();
                StreamObserver<KeyValueStoreProcedures.Dictionary> ra = null;

                KeyValueStoreProcedures.Dictionary responseserversavailable = syncKeyValueStoreStub4.requestServerList(serversavailable);

                System.out.println(responseserversavailable.getPairsMap().entrySet());



                servertoshutdown=validateservertoshutdown(falseservtoshutdown);


                KeyValueStoreProcedures.BringServerDown removethisserver = KeyValueStoreProcedures.BringServerDown.newBuilder().setServertobringdown(servertoshutdown).build();

                KeyValueStoreProcedures.Dictionary responseserverremoved = syncKeyValueStoreStub4.removeServer(removethisserver);


                System.out.println(responseserverremoved.getPairsMap().entrySet());
                System.out.println(responseserverremoved.getMessage());


                if (responseserverremoved.getMessage().equalsIgnoreCase("Server List Empty")){
                    System.out.println("No more servers to shutdown");
                    System.exit(0);
                    GRPCServer.stop();
                }

                //Server has never been shutdown
                else if((servertoshutdown== 9090 || servertoshutdown==9091 || servertoshutdown==9092 || servertoshutdown==9093 || servertoshutdown==9094) && responseserverremoved.getMessage().equalsIgnoreCase("Server Down") ){
                    for (int i=0; i<5; i++){

                        unavailableserversWithoutDuplicates.add(servertoshutdown);

                    }

                    for (Integer i: responseserverremoved.getDroppedserverMap().values()){
                        if(!unavailableservers.contains(i)){
                            unavailableservers.add(i);
                        }
                    }
                    unavailableservers=new LinkedHashSet<Integer>(unavailableserversWithoutDuplicates);

                    unavailableserversWithoutDuplicates=new ArrayList<Integer>(unavailableservers);
                    specifyServerPortNumber(servertoshutdown, sr, command);
                }


                //Server has already been shut
                else if ((servertoshutdown== 9090 || servertoshutdown==9091 || servertoshutdown==9092 || servertoshutdown==9093 || servertoshutdown==9094) && responseserverremoved.getMessage().equalsIgnoreCase("Server Non Existent or Already Down")){
                    System.out.println("Choose another server");
                    specifyServerPortNumber(servertoshutdown, sr, command);

                    //GRPCServer.stop();
                    //System.exit(0);
                }


            }
            catch (NullPointerException e1) {

            }
            catch (IndexOutOfBoundsException e1) {
                Logger_Function("All servers shutdown");
                //Shutdown client
                KeyValueStoreProcedures.removeClientsFromList  nameofclient = KeyValueStoreProcedures.removeClientsFromList.newBuilder().setClientName(sendclientname).build();
                KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub5 = KeyValueStoreGrpc.newStub(channel5);
                StreamObserver<KeyValueStoreProcedures.removeClientsFromList> responseclient = null;

                /**Send client information to all server**/
                enterNameofClientStub5.removeClients(nameofclient,responseclient);
                GRPCServer.stop();
                System.exit(0);

            }


        }


        /**
         * Validate clients commit or abort-Not used
         * @param c is the commit or abort command
         * @param cr is the text to be read from input stream
         * @return validated commit or abort command
         */
        public static synchronized int validateCommitorAbort(int c, BufferedReader cr ) {
            while (true) {
                try {
                    System.out.println("VOTE_REQUEST\nPlease enter ABORT or COMMIT to proceed : ");
                    System.out.println("Enter 5 to ABORT, 6 to COMMIT");
                    System.out.println("Enter Command: ");
                    c = Integer.parseInt(cr.readLine());


                    //Validate commit or abort from client =
                    if(c>=5 && c<=6){
                        break;
                    }
                } catch (NumberFormatException e) {
                    Logger_Function("command is not an int value or must be in range 5<=command<=6. Re-enter command");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return c;
        }




        //increment suggestion id if too low

        /**
         * Validate suggestion integer from proposer
         * @param suggestionInteger is the suggestion integer to be validated
         * @param suggestionIntegerReader is the input reader
         * @return validated suggestion integer
         */
        public static synchronized int validateSuggestionInteger(int suggestionInteger, BufferedReader suggestionIntegerReader){

            while(true) {
                try {
                    Logger_Function("Request Permission from Majority of Peers");
                    Logger_Function("Enter SuggestionInteger");
                    suggestionInteger= Integer.parseInt(suggestionIntegerReader.readLine());

                    //Validate commit or abort from client =
                    if(suggestionInteger > 0){
                        break;
                    }
                } catch (NumberFormatException e) {
                    Logger_Function("SuggestionInteger is not an int or is < = 0 . Re-enter suggestionInteger");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //validate input first

            }

            return suggestionInteger;
        }

        /**
         * Validate suggestion string
         * @param suggestionString is the string to be validated
         * @param suggestionIntegerReader is the input reader
         * @return validated suggestion string
         */
        public static synchronized String validateSuggestionString(String suggestionString, BufferedReader suggestionIntegerReader){
            while(true) {
                try {
                    //Fix whitespaces and
                    Logger_Function("Enter SuggestionString. Must be a single UppercaseLetter from A to Z.");
                    suggestionString= suggestionIntegerReader.readLine();

                    try {
                        char c = suggestionString.charAt(0);
                        if ((c >= 'A' && c <= 'Z') && (suggestionString.length() < 2) && (!suggestionString.matches("^\\s*$"))) {
                            break;
                        }
                    }catch (StringIndexOutOfBoundsException d){

                    }


                } catch (NumberFormatException e) {
                    Logger_Function("SuggestionInteger is not an string or is not in the range A to Z . Re-enter suggestionInteger");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //validate input first

            }

            return suggestionString;
        }

        /**
         * Send client name that's ready for consensus
         * @param suggestionInteger is the verification of the suggestion integer intially proposed
         * @param last_accepted_suggestion_integer is the initially validated suggestion integer from proposer
         * @param suggestionIntegerReader is the inoput reader
         * @return
         */
        public static synchronized int validateAcceptanceofSuggestionInteger(int suggestionInteger, int last_accepted_suggestion_integer, BufferedReader suggestionIntegerReader){

            while(true) {
                try {
                    Logger_Function("Entering Suggestion/Acceptance Phase");
                    Logger_Function("Send suggestion message to Suggest Candidate Value for Consensus");
                    Logger_Function("Enter SuggestionInteger from Previous Entry");
                    suggestionInteger= Integer.parseInt(suggestionIntegerReader.readLine());


                    System.out.println("YOUR SUGGESTION INPUT  " + right_suggestion_integer);
                    System.out.println("SUGGESTION INPUT FROM SERVER " + storeSuggint);
                    System.out.println("WAITING FOR ACCEPTOR RESPONSE................ ");

                    if(suggestionInteger >= storeSuggint ){
                        if(right_suggestion_integer < storeSuggint){
                            Logger_Function("Although you entered the right suggestion, you may not have access to manipulate Key_Value Store");
                            System.out.println("Unable to Enter Suggestion Phase because your previous suggestion to gain access is too low. Reenter a New Suggestion");
                            initiatePaxos();
                        }
                        else {
                            KeyValueStoreProcedures.SendConsensus sendConsensus = KeyValueStoreProcedures.SendConsensus.newBuilder().setClientname(sendclientname).build();

                            consensus=syncKeyValueStoreStub.consensus(sendConsensus);
                            //request.getKey()=key;
                            /**
                             * Contact the multiple servers
                             */

                            Logger_Function(consensus.getMessage());


                            //re = syncKeyValueStoreStub.namesOfClients(r);
                            if(Integer.parseInt(consensus.getMessage()) < 2){

                                // chandler.sleep(10000);

                                Logger_Function("Consensus has not been achieved-Reinitiating Paxos");
                                // chandler.start();
                                //handler.sleep(10000);
                            }

                            else {
                                Logger_Function("Consensus has been achieved");
                            }

                            break;

                        }
                    }
                    else {
                        Logger_Function("Consensus may have not been reached (2 or more acceptors agree), SuggestionInteger does not match previous accepted suggestion integer,is not an int or is < = 0 . Re-enter suggestionInteger");


                    }

                } catch (NumberFormatException e) {
                    Logger_Function("Consensus may have not been reached (2 or more acceptors agree), SuggestionInteger does not match previous accepted suggestion integer,is not an int or is < = 0 . Re-enter suggestionInteger");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //validate input first

            }

            return suggestionInteger;
        }
    }


}


