# HEIG-RES-2018-Blanco-Silvestri-SMTP-PRANKS

**The project:**  
The goal of this laboratory is the develop a client application allowing a user to send forged emails to chosen groups of people. The application is a Meaven project written in Java. The program configuration can be edited by the user.

**Mock server using docker:**
* The docker directory at the root of the progam contain the dockerfile and the sources folder required by the docker. To build a docker image, simply write ``docker build -t containerName .``in a docker bash. By writing ``docker images``, you can see the build images on your computer. This allow to check if the building is successful.  

* To setup the docker container of the mockmock server, just write ``docker run -p 2525:2525 -p 8080:8080 containerName`` in a docker bash. The server will use the port 8080 for the HTTP and the 2525 for SMTP. If you need to change those ports, the dockerfile must be edited and the image rebuild.

* You can go to the mail overview page by typing ``192.168.99.199:8080`` in your internet navigator. If the HTTP port has been changed, change the instruction above to match the new port.

* To send messages to the server from the program, start a TCP connection from your client to the server using ``192.168.99.100`` as the server adress and ``2525`` as the server port.

* If you want to launch the server without docker, just go in the /docker/src folder and launch the .jar file using the ``java -jar MockMock.jar -p 2525 -h 8080`` command.

**Configuration:**
* The configuration files of the program are in the ``config`` directory in the root folder of the project.

* The ``config.properties`` file contains the configuration for the smtp protocol (SMTP server adress and port), the number of groups and the user to CC. Note: a group must contain at least 3 people. If there is not enough people for the amount of groups required, less groups will be generated.

* The ``victims.utf8`` file contains the list of email adresses (one per line).

* The ``messages.utf8`` file contains the messages that will be send. They are separated by ``==``. The first line of each message must be ``Subject: `` otherwise, the mail received by the victims won't have any.

**Implementation:**  
Our program is separated in two parts: the SMTP client code and the pranks one.  
For the pranks:
* We have a JavaObject called PrankGenerator that have a method creating then returning a list of pranks.
* Each pranks contain a sender, some victims and a message. Those informations are read from the config file using the ConfigurationManager Object.

For the SMTP Client:
* We start a connection with the SMTP server then we send go through the protocol for each pranks in the list.
* Once all the mails are sent, the client drop the connection with the server and exit the program.
