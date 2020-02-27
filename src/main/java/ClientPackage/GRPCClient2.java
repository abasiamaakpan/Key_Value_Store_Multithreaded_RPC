package ClientPackage;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreGrpc;
import com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

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
    public static final int SUCCESS = 0;
    public static final int INVALID_KEY = -1;
    public static final int CMD_PUT = 1;
    public static final int CMD_GET = 2;
    public static final int CMD_DEL = 3;
    public static final int CMD_EXIT = 4;


    /**
     * Channel for communication between client and server
     */
    public static ManagedChannel channel;

    /**
     * Clientname
     */
    public static final String sendclientname="Client 2";



    public static void main(String args[]) {

        /**
         * Create channel with host name and port number and send client information to server
         */
        channel = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(args[0])).usePlaintext().build();
        KeyValueStoreProcedures.SendNameofClient nameofclient = KeyValueStoreProcedures.SendNameofClient.newBuilder().setNameofclient(sendclientname).build();
        StreamObserver<KeyValueStoreProcedures.SendNameofClient> responseob = null;

        KeyValueStoreGrpc.KeyValueStoreStub enterNameofClientStub = KeyValueStoreGrpc.newStub(channel);
        enterNameofClientStub.enterNameofClient(nameofclient, responseob);

        int counter = 0;

        counter++;
        System.out.println(" >> " + sendclientname +" started!");

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
        /**Key Store Data**/
        int command = 0;
        int key = 0;
        String value = "";




        ClientHandler(int counter){
            //clientHandler = fromClientSocket;
            newClient=counter;
        }
        KeyValueStoreGrpc.KeyValueStoreBlockingStub syncKeyValueStoreStub = KeyValueStoreGrpc.newBlockingStub(channel);
        /**
         * Start client
         */
        public void run(){
            try{

                /**
                 * Check for valid commands which are PUT,GET,DELETE,POPULATE,EXIT.
                 * This is the Communication logic with the client
                 */
                while (true){
                    int right_command= validateCommand(command,commandreader);
                    int right_key;
                    String right_value;


                    if (right_command == CMD_EXIT) {
                        KeyValueStoreProcedures.ClientExit exitcall = KeyValueStoreProcedures.ClientExit.newBuilder().setClientname(sendclientname).setInputkey(4).build();

                        KeyValueStoreGrpc.KeyValueStoreStub exitClient = KeyValueStoreGrpc.newStub(channel);
                        StreamObserver<KeyValueStoreProcedures.SuccessfulExit> responseobs = null;
                        exitClient.clientExited(exitcall,responseobs);

                        Logger_Function("Goodbye");
                        break;
                    }

                    else if(right_command == CMD_PUT){

                        //   stub2.send_Command_To_Server_get_Command_From_Client(right_command);

                        right_key=validateKey(key,keyreader);
                        // stub2.send_Key_To_Server_get_Key_From_Client(right_key);

                        right_value=validateValue(value,valuereader);
                        // stub2.send_Value_To_Server_get_Value_From_Client(right_value);

                        KeyValueStoreProcedures.Pair request = KeyValueStoreProcedures.Pair.newBuilder().setKey(right_key).setValue(right_value).setClientname(sendclientname).build() ;

                        //request.getKey()=key;

                        KeyValueStoreProcedures.SuccessfulPut response = syncKeyValueStoreStub.insertKeyValue(request);

                        System.out.println(response.getMessage());
                    }

                    else if (right_command == CMD_GET){
                        right_key=validateKey(key,keyreader);
                        KeyValueStoreProcedures.GetKey request = KeyValueStoreProcedures.GetKey.newBuilder().setInputkey(right_key).setClientname(sendclientname).build() ;

                        KeyValueStoreProcedures.SuccessfulGet response = syncKeyValueStoreStub.getKeyValue(request);
                        System.out.println(response.getMessage());

                    }

                    else if (right_command == CMD_DEL){
                        right_key=validateKey(key,keyreader);
                        KeyValueStoreProcedures.DeleteKey request = KeyValueStoreProcedures.DeleteKey.newBuilder().setTheinputkey(right_key).setClientname(sendclientname).build() ;

                        KeyValueStoreProcedures.SuccessfulDelete response = syncKeyValueStoreStub.deleteKeyValue(request);
                        System.out.println(response.getMessage());

                    }

                }


            } catch(NullPointerException ex){
                System.out.println(ex);
            } finally{
                System.out.println(sendclientname + " exited!!" );
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
                    System.out.println("Enter 1 to PUT, 2 to GET, 3 to DELETE, 4 to EXIT");
                    System.out.println("Enter Command: ");
                    c = Integer.parseInt(cr.readLine());

                    //Validate Command PUT(1),GET(2),DELETE(3),EXIT(4) from Client
                    if(c>=1 && c<=4){
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("command is not an int value or must be in range 1<=command<4. Re-enter command");
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
                    System.out.println("key is not an int value. Reneter key");
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
                    System.out.println("key is not an int value. Reneter key");
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
    }






}

