# FlightSimulator

## Overview and Features: 

Our project consists of an Android app which will allow us to control the plane that displayed on the FlightGear simulator.
By communication with the FlightGear simulator, we are able to simulate a flight with sending several attributes related to the flight, such as throttle, rudder, aileron and elevator.
The project runs on multiple threads and was developed using MVVM architechture.

The app contains one main activity which in it we have the next graphic view components: 
  - Two Edit texts which will be used by the user to enter the ip and port of the pc the FlightGeat is running on.
  - Connect button (shall be clicked by the user after entering the correct ip and port).
  - Vertical seek bar, will be used for updating the throttle's airplane values by the user's touch (between 0-1).
  - Horizontal seek bar, will be used  for updating the rudder's airplane values by the user's touch (between -1 - 1).
  - Joystick, will be used for updating the aileron and elevator values by the user's touch and depending on which axis.

How to use:
  After the FightGear is running with the additional setting mentioned bellow and the engine turned on, open the app and enter the correct ip and port of the FligthGear, click the connect button and note that there are no error messages.
  Now by using the graphic view components you can manage a flight. Enjoy!


Mandatory:
  - FlightGear should be running on the ip and port that are mentioned before and with the next quote in the additional setting: 
  "--telnet=socket,in,10,127.0.0.1,6400,tcp"
  - The cessna engine should be turned on manually in the FlightGear simulator app.


## Structure of the Project: 

Our project is organized in two folders:
 1. java - contains the com.example.flightgearcontroller4 package which contains the MainActivity class and three packages: views, viewmodel, model.
    views contains the VerticalSeekBar and Joystick classes, viewmodel contains the ViewModel class and model contains the Model class
 2. res - contains the next packages: drawable, layout, mipmap, values.
    The layout package contains the activity_main.xml and the layout package contains the strings.xml and color.xml
        
## UMLs and Class Diagrams:     

https://github.com/TomMagdaci/FlightGearControllerAPP/blob/master/Class%20diagram/UML.PNG

## Short Video About Our Project: 

https://youtu.be/zwPtR9BZY14
  
 --
 Kind regards,
 Michael Ganon & Tom Magdaci.
