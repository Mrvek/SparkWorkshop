# Java Spark Workshop 

This project utilises the Java Spark Framework to test the various assignments related to the framework in a workshop that was given in december 2016. The names of the attendees were tied to a port number beforehand and linked to an IP during the first visit to their assignment page.

It consists of four assigments to complete once the framework was set up:
* Create a GET route using the assigned port that returns 'Hello yourname' with the attendee its name. (name has to match)
* Create a GET route that returns the constantly random generated number on the workshop server on their server.
* Create a websocket that listens to 'ping' that returns 'pong'.
* Create websockets on '/server' and '/front' that displays all received messages and is also capable to send messages. The idea was to create a functional chatroom,

The server implementation would serve a page that checks if these assignements were completed and return to the users if they were succesful. To properly finish up this project an overview page of completed assignments was planned, but not implemented. A related serveroverload error was not solved and needs to be fixed if you want to use this feature.

The attendees were supplied a [basic setup](https://github.com/Mrvek/SparkWorkshop) for spark to speed the setup.

###### Dependencies:
* [Java Spark Framework](http://sparkjava.com/)
* Additional dependencies can be found in the [pom.xml](https://github.com/Mrvek/SparkWorkshop/blob/master/pom.xml)
