package ClientPackage;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreGrpc;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
//import javafx.application.Platform;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * GRPC CLIENT
 */
public class GRPCClient2 {
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


    /**
     * Clientname
     */
    public static final String sendclientname="Client 2";


    public static void main(String args[]) {

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
        //  System.out.println(channel.getState(false));

        ClientHandler chandler = new ClientHandler(counter);

        chandler.start();

    }

    /**
     * Create client thread
     */
    public static class ClientHandler extends Thread{
        int newClient;
        BufferedReader commandreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader keyreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader valuereader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader commitorabortreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader preparetocommitorabortreader = new BufferedReader(new InputStreamReader(System.in));


        /**Key Store Variables**/
        int command = 0;
        int key = 0;
        String value = "";
        int server_number=0;
        int commitorabort=0;
        int preparetocommitorabort=0;



        ClientHandler(int counter){
            //clientHandler = fromClientSocket;
            newClient=counter;
        }

        /**New synchronous stubs are instantiated for each channel**/
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub = KeyValueStoreGrpc.newBlockingStub(channel);
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub2 = KeyValueStoreGrpc.newBlockingStub(channel2);
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub3 = KeyValueStoreGrpc.newBlockingStub(channel3);
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub4 = KeyValueStoreGrpc.newBlockingStub(channel4);
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub5 = KeyValueStoreGrpc.newBlockingStub(channel5);
        KeyValueStoreProcedures.FromServer e= null;
        //KeyValueStoreProcedures.FromServer fS=null;

        /**
         * Start client
         */
        public void run() {
            try {

                /**
                 * Check for valid commands which are PUT,GET,DELETE.
                 * This is the Communication logic with the client
                 */
                while (true) {

                    // int right_server_number = specifyServerNumber(server_number,serverreader);
                    // int right_commit_or_abort=validateCommitorAbort(commitorabort,commitorabortreader);

                    /**New asynchronous stubs are instantiated for each channel**/
                    KeyValueStoreGrpc.KeyValueStoreStub bidirectionalStreamStub = KeyValueStoreGrpc.newStub(channel5);

                    /**Stream Observer for biderecitonal communication between clients**/
                    StreamObserver<KeyValueStoreProcedures.Broadcasttoallclients> observer = bidirectionalStreamStub.chat(new StreamObserver<KeyValueStoreProcedures.FromServer>() {


                        /**Print out returned information when a client sends a command (Prepare,abort,commit) to server**/
                        @Override
                        public void onNext(KeyValueStoreProcedures.FromServer fromServer) {


                            e =  fromServer;

                            /**Check if servers are prepared**/
                            if(fromServer.getMessage().getSendprepared()==CMD_PREPARED && fromServer.getMessage().getClientname().equalsIgnoreCase("Client 2")){
                                System.out.println("SERVERS_ARE_PREPARED");

                                //return;
                            }

                            /**This application aborts**/
                            if((fromServer.getMessage().getSendabort()==CMD_ABORT)){
                                System.out.println("GLOBAL_ABORT");
                                System.exit(0);
                            }

                            /**One Client Commits and the Other Aborts**/
                            if((fromServer.getMessage().getSendabort()==CMD_ONE_CLIENT_ABORTS)){
                                System.out.println("GLOBAL_ABORT");
                                System.exit(0);
                            }

                            /**Check if both clients entered a COMMIT**/
                            if(fromServer.getCheckglobalcommit()==CMD_COMMIT){
                                // System.out.println("BULL");
                                System.out.println("GLOBAL_COMMIT");
                            }


                            /*System.out.println("Erdersiveeeeeeeeeeee   "+ fromServer.getCheckglobalcommit());
                            System.out.println("Erdersiveeeeeeeeeeee   " + fromServer.getMessage().getSendcommit());
                            System.out.println("Erdersiveeeeeeeeeeee   " + fromServer.getMessage().getSendabort());
                            System.out.println("Erdersiveeeeeeeeeeee   " + fromServer.getCheckabort());
                            System.out.println("Erdersiveeeeeeeeeeee   " + fromServer.getMessage().getClientname());*/



                          /*  if(fromServer.getCheckglobalcommit()==24 && ((fromServer.getMessage().getClientname().equalsIgnoreCase("Client 1"))||(fromServer.getMessage().getClientname().equalsIgnoreCase("Client 2")))){
                                System.out.println("GLOBAL_COMMIT");

                            }*/

                            /*System.out.println("Erdersiveeeeeeeeeeee client   " + fromServer.getMessage().getSendcommit());*/





                        }


                        /**Error Checking**/
                        @Override
                        public void onError(Throwable throwable) {


                        }

                        @Override
                        public void onCompleted() {




                        }
                    });

                    /**Check if server is prepared to communicate**/
                    int rightpreparetocommitorabort = preparetoCommitorAbort(preparetocommitorabort, preparetocommitorabortreader);
                    observer.onNext(KeyValueStoreProcedures.Broadcasttoallclients.newBuilder().setSendprepared(rightpreparetocommitorabort).setClientname(sendclientname).build());


                    //System.exit(0);
                    /**COMMIT OR ABORT from client**/
                    int right_commit_or_abort = validateCommitorAbort(commitorabort, commitorabortreader);
                    observer.onNext(KeyValueStoreProcedures.Broadcasttoallclients.newBuilder().setSendabort(right_commit_or_abort).setClientname(sendclientname).build());
                    // System.out.println("Checking value of abort" + e.getMessage().getSendabort());
                    if(right_commit_or_abort==6){
                        System.out.println("COMMIT.....waiting on other clients");
                    }
                    /*System.out.println(e.getCheckglobalcommit());
                    System.out.println(e.getMessage().getSendcommit());
                    System.out.println(e.getMessage().getSendabort());
                    System.out.println(e.getCheckabort());*/

                    /**Specify server to be contacted**/
                    int right_server_number = specifyServerPortNumber(server_number, serverreader);


                    //System.out.println("Are specifying server number");
                    int right_command = validateCommand(command, commandreader);
                    //System.out.println("After validating command");

                    int right_key;
                    String right_value;
                    /**
                     * Check if command from client is PUT
                     */
                    if (right_command == CMD_PUT) {

                        //   stub2.send_Command_To_Server_get_Command_From_Client(right_command);

                        right_key = validateKey(key, keyreader);
                        // stub2.send_Key_To_Server_get_Key_From_Client(right_key);

                        right_value = validateValue(value, valuereader);
                        // stub2.send_Value_To_Server_get_Value_From_Client(right_value);

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
                        right_key = validateKey(key, keyreader);
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

                    //System.out.println("COMMIT checkglobalcommit" +e.getCheckglobalcommit() );
                    //System.out.println("COMMIT send abort" +e.getMessage().getSendabort() );
                    //System.out.println("COMMIT check abort" +e.getCheckabort()) ;
                    //System.out.println("COMMIT check prepared " +e.getCheckprepared()) ;

                   /* if(e.getCheckglobalcommit()==24){
                        Logger_Function("GLOBAL_COMMIT");
                    }*/

                }

            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } finally {
                Logger_Function(sendclientname + " exited!!");
                //System.exit(0);

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
         * @return validated server port number
         */
        public static synchronized int specifyServerPortNumber(int serverNumber, BufferedReader sn){
            while (true) {
                try {
                    System.out.println("Enter Server Port Number 9090 to 9094");
                    serverNumber = Integer.parseInt(sn.readLine());
                    System.out.println(serverNumber);
                    if((serverNumber>=9090 && serverNumber<=9094)){
                        break;
                    }
                } catch (NumberFormatException e) {
                    Logger_Function("Server port number is either not an int value, or is not in the range 9090-9094. Reneter server port number");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return serverNumber;

        }

        /**
         * Validate clients commit or abort
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


    }


}

