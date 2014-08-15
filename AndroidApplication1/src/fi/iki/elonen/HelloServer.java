package fi.iki.elonen;

import android.R;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import screenreader.screenreader.MainActivity;
/**
 * android application
 * An example of subclassing NanoHTTPD to make a custom HTTP server.
 */
public class HelloServer extends NanoHTTPD {
    private  TextToSpeech tts;
    MainActivity ma;
   EditText sb;
    public HelloServer(TextToSpeech tts,int port,EditText sb) {
        super(port);
         this.tts=tts;
         this.sb=sb;
         
    }

    @Override public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        String uri = session.getUri();
        System.out.println(method + " '" + uri + "' ");

        String msg = "<html><body><h1>tts  server</h1>\n";
        Map<String, String> parms = session.getParms();
        String tx=parms.get("text");
        if (tx == null)
            msg +="no text sent";
        else
        {

        msg += "text to speak = "+tx+" </body></html>\n";
        try{ 
            tx=rep(tx);
        tts.speak(tx, TextToSpeech.QUEUE_FLUSH, null);
        
        }catch(Exception e){
        msg += "error details = "+e.toString()+" </body></html>\n";
        }
        }
        return new NanoHTTPD.Response(msg);
    }

public String rep(String tx)
{
    String sl[]=sb.getText().toString().split("\n");
    for(int i=0;i<sl.length;i++)
    {
    try{
    String ow=sl[i].substring(0,sl[i].indexOf(":"));
    String nw=sl[i].substring(sl[i].indexOf(":")+1);
    tx=tx.replaceAll(ow, nw);
    }catch(Exception e){}
    }
        return tx;

}
    /*public static void main(String[] args) {
     * try {
     * ServerRunner.run(new HelloServer());
     * } catch (IOException ex) {
     * Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
     * }*/
}

