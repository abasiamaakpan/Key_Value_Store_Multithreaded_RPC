package ServerPackage;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import keyvaluestore.Key_Value_Store_Service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * GRPC Server
 */
public class GRPCServer {
    private static final Logger logger = Logger.getLogger(GRPCServer.class.getName());
    private static Server server ;
    /**Handle Milliseconds for Log**/
    public static final String format = "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS.%1$tL %1$Tp %2$s%n%4$s: %5$s%n";

    /**
     * Main launches the server from the command line.
     */
    public static void main(String args[]) {

        server= ServerBuilder.forPort(Integer.parseInt(args[0])).addService(new Key_Value_Store_Service()).build();

        try {
            server.start();
            Logger_Function("Server started, listening on " + server.getPort());
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                stop();
                System.err.println("*** server shut down");
            }));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
           // System.out.println("Server started at " + server.getPort());
            /**
             * Await termination on the main thread since the grpc library uses daemon threads.
             */
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Stop serving requests and shutdown resources. */
    public static void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Function to log to server/client
     * @param message is the message to be displayed on the logger
     */
    public static void Logger_Function(String message){
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

