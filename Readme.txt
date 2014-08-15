INTRODUCTION

Hello,
Basically this is a mobile application for the android platform to read aloud the text of web page in a browser(i.e mozilla firefox).
This helps in reducing eyestrain and increased productivity. you can also check my similiar chrome extension (for pc, not part of this project)
you can read this or view the video tutorials on my youtube page.

This is accomplished by two seperate application and this can be viewed as client-server application model.
1.client application is an add-on for mozilla firefox for android, a single file in *.xpi (mozilla firefox add-on) format
2.server application is an android application
Basically the add-on injects a content script into the web page that the user wants to read-aloud. The content script provides buttons to navigate. The server application recieves the text to speak and after performing a few substitutions , if specified(as 'that is' for 'i.e') speaks the text aloud.

INSTALLATION 
(The instructions are for bluestacks app player for windows.It can also be done on any android device although i confess that i have not tested the app thoroughly on any android device)
Mainly this requires firefox mobile version above 25.0.
After the installation, write the absolute address of the scmoz.xpi file (provided on the dvd) in the address bar.
Or else you can go to https://www.mediafire.com/folder/hvqc348fdgynk/screenreaderMob from mozilla firefox mobile itself and download the xpi file from there.

The server app, an android application called screenreader_server.apk also needs to be running in order for the speech to be uttered.So install that also in the bluestacks app player for windows. 

RUNNING

Hence after the installation you can go to a new tab in firefox (hereafter firefox means mozilla firefox for android above version 25.0) and open any web page. You will find a yellow div at the bottom of the page. But before that you need to start the screenreader server app(android app) and click the start server button. you can click the test tts button to hear a sample sentence. now you can
go back to firefox.There will be several buttons. You can click the 'Next sent' button to go to next sentence. and you will see a text selection moved and the selected text spoken aloud. The buttons are
     BUTTON		FUNCTION	
1.prev sentence		 goes to prev sentence. More accurately upto previous '.' character		

2.next sentence 	 goes to next sentence. More accurately upto next '.' character
3.jump			 Jumps to specified location.This usage is slightly complex and will be explained 				          		  later		
4.prev punc		 goes to prev punctuation mark. More accurately upto previous '.' , ')' , '(' ,'?' , 						 ':'character			  
5.prev punc		 goes to next punctuation mark. More accurately upto previous '.' , ')' , '(' ,'?', 						':'character		
6.repeat		 speaks the selected text again.useful if you want to concentrate on a difficult to 		         understand line and need to 'see' or read the text again and again	
7.stop			 stops the currently speaking text

--Jump to any location--

by default when you press next sentence it will start from first. To jump to any location first click the jump/init button. Next select any text within 4 seconds and WAIT for the done message(at bottom). ok now you can use next sentence/prev sentence buttons.

you can also use if you are stuck at some point and the next sentence button cannot jump to next location

COMMON PROBLEMS
If you can't hear audio, set music volume to max
