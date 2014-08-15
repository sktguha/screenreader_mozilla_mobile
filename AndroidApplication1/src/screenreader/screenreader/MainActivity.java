package screenreader.screenreader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import fi.iki.elonen.HelloServer;
import fi.iki.elonen.ServerRunner;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Text;

public class MainActivity extends Activity
{
    public SharedPreferences set ;
    private TextToSpeech ttobj;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        //ServerRunner.run(HelloServer.class);
        setContentView(R.layout.main);
        ttobj=new TextToSpeech(getApplicationContext(), 
      new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int status) {
         if(status != TextToSpeech.ERROR){
             //ttobj.setLanguage(Locale.UK);
            }				
         }
      });
        //Thread.sleep(RESULT_OK);
        
        set=getPreferences(0);
        EditText sb = (EditText) findViewById(R.id.subs);
        String st = set.getString("subs","i.e:that is\n!=:not equals");
        sb.setText(st);
        new Thread(new Runnable() {

            public void run() {
            while(true)
            {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(!MainActivity.this.ttobj.isSpeaking())
                MainActivity.this.ttobj.speak(" ", TextToSpeech.QUEUE_ADD, null);
            }
            }
        }).start();
        }

    @Override
    protected void onStop() {
        EditText sb=(EditText)findViewById(R.id.subs);
        set.edit().putString("subs", sb.getText().toString()).commit();
        
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        EditText sb=(EditText)findViewById(R.id.subs);
        set.edit().putString("subs", sb.getText().toString());
        super.onSaveInstanceState(outState);
    }

    
 
    public void start(View view)
    {
        try {
                  
            ServerRunner.run(new HelloServer(ttobj,8085,(EditText)findViewById(R.id.subs)));
        //Test.main(null);
            TextView msg = (TextView)findViewById(R.id.msg1);
        msg.setText("server started");
        } catch (Exception e) {
        TextView msg = (TextView)findViewById(R.id.msg1);
        msg.setText("exception : "+e.toString());
        }
        
    }
    public void test(View view)
    {
    ttobj.speak("This is a test to see if text to speech is working", TextToSpeech.QUEUE_FLUSH, null);
    }
    
}
