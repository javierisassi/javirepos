# javirepos
My tools of the trade
A Hello World using:

scons

java

protocol buffers

zeromq

All is well

Why?

Because this tiny project puts together the tools of the trade.

       __________                   ___________
      |          |                 |           |        
      | hwclient |                 | hwserver  |
      |          |                 |           |
       ----------                   -----------
           |                            |
           |                            |
           |---- "Hello" -------------->|
           |                            |
           |                            |
           |<------"World"--------------|
           |                            |
           |                            |
           |                            |
           |                            |
           |                            |

 
To the untrained eye the feat my look idiotic. Close inspection
reveals the use of three, count them, three,
 popular technologies, together:

Protocol Buffers
Zero MQ
Scons

The Java implementation (which of course is harde to install and run)
is not by choice but If you put all this pieces you will be on 
the starting point to develop highly scalable distributed solutions
in multiple languges.

What you need to do:

Install scons >apt-get install scons
Install zeromq from  zeromq.org
Install the java bindings from zeromq.org
Install protobuffers from developers.google.com/protocol-buffers
Install maven so you can create a jar file for the protocol buffers
follow the instructions in the java directory of the protocol buffers project
For simplicty all third party java libs are in /usr/local/share/java

To build:

type 
>scons PROTOBUF (yes 2 commands I am pissed off)
type 
>scons

To Run:

>./testhelloworld

read more on the how_i_did_it.txt for specific commands and such
