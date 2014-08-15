package fi.iki.elonen;

import java.io.IOException;

public class ServerRunner {
    public static void run(NanoHTTPD sv) throws IOException {
            executeInstance(sv);
        
    }

    public static void executeInstance(NanoHTTPD server) throws IOException {
      
            server.start();
            //  System.out.println("Server started, Hit Enter to stop.\n");
    }
}
