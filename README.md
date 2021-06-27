# FlightSimulator

## Overview and Features: 

Our project consists of a GUI interface (using WPF application and .NET framework) which will allow us to view and control the plane in FlightGear simulator. By recieving the data of a flight, we are able to simulate it through FlightGear and analyze several attributes related to the flight, such as throttle, altitude, airspeed, etc. Moreover, we are able to view the joystick of the plane to help us inspect the direction the plane is heading, along with a few graphs that help us visually evaluate the various aspects of the flight: the first graph is a view of the attribute selected in the attribute box, the second graph is a view of the attribute most correlated to the attribute we selected, the third graph shows the linear regression between the two attributes from the first two graphs, and the fourth graph displays anomalies from the flight in relation to the two attributes. Lastly, we developed a control panel that aids us in controlling the play speed of the flight, pause or play the simulation, and fast forward/backtrack. 
The project runs on multiple threads and was developed using MVVM architechture.

Regarding the graphs and anomalies, we imported all of the code written in Advanced Programming I as a c++ dll, to a WPF library that forms the shapes required and sends it to our application. The c++ dll's job is to send information about the anomaly. We were able to implement this in an abstract manner by sending an Annotation object back to the c# application, therefore it doesn't matter if we are sending back a circle annotation or a line annotation. As a result, we were able to plot on our graphs the required lines, circles, and calculate pearsons without rewriting last semester's code in c#. 

## Structure of the Project: 

Our project is organized in three folders: 

1. WpfApp1- the main folder, contains the main window, view model, and model. 
2. controls- contains all of the controls in our main window, such as the joystick, graphs, and control panel.
3. plugins- the folder that contians the dynamic link libraries of our project.

## Required Installations: 

1. Import oxyplot in appropriate files in order to view graphs
2. Install the latest version of FlightGear on your computer 

## Manual: 
Downloading from GitHub:
1. Clone the repository
2. Build the solution
3. Insert the plugins folder where the executable file is located. In addition insert the "csvs" folder in the same location with a trainFile. 
4. Run the app and a GUI should open.
5. Upload your CSV and XML files and press Upload File on your right hand side. 
6. The simulation will begin, and you are free to use the controls and sliders to analyze the flight 
7. implement the following if you wish to import your own dll:
```cs
List<Tuple<string, int>> getAnomalies(string trainFile, string testFile){}
void getAttributeWithADAnnotations(string trainFile){}
```

## UMLs and Class Diagrams: 

Our desktop application consists of 3 main parts that communicate and run. The first component is the MyFlightModel that interacts with the server via TCP communication. The second component is the ViewModel that sends data requests to the MyFlightModel and recieves notifications when data changes from the MyFlightModel. Our last component is the View (MainWindow file) that sends commands to the ViewModel and gets notified about changed data from the ViewModel. Data is displayed in our MainWindow through the process of data binding. The following link is our project UML: https://github.com/dhshark1/FlightSimulator/tree/Main_Branch/WpfApp1/WpfApp1/class%20diagram

## Short Video About Our Project: 
https://www.youtube.com/watch?v=lR0nlxIm9Q0&ab_channel=%D7%9E%D7%99%D7%9B%D7%90%D7%9C%D7%92%D7%A0%D7%95%D7%9F
