# Chat-App-using-JAVA
I have Created a  LAN based One to One Chat Application by using Core JAVA Fundamentals,Java Swing and JAVA Sockets.
This is my 3rd Semester Java Project Covering Core JAVA and Few of Advanced JAVA Concepts such as Socket Programming.

The Project Consists of Two-way Client and Server communication where each Node can transfer textual DATA of its own. 

This can be implemented by using 2 classes  of java.net package ServerSocket and Socket.

The project follows core understanding of Core JAVA and TCP/IP  (stateless)  protocols for communicating to each other over a same network (Here LAN).

Any two devices connected over the same network can run this program provided that the Corresponding IP  Addresses are feeded into the program first.

For the sake of simplicity we created only  two nodes which can connect to each other one is called Server (executed using Server.java)

which is responsible for hosting and accepting the request from the other nodes

and another node is called  a Client (executed using Client.java) which sends a request to already running Server program to get connected, after successfull connection between the two nodes a simple GUI application (.exe file) starts running .This GUI helps to send texts to other node and is simple to use implemented using java swing lib, though we have created GUI  for more immersive experience a user can choose to  send data through console also.
