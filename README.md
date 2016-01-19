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

What you need to do:
Install scons >apt-get install scons
Install zeromq from  zeromq.org
Install the java bindings from zeromq.org
Install protobuffers from developers.google.com/protocol-buffers
Install maven so you can create a jar file for the protocol buffers
follow the instructions in the java directory of the protocol buffers project
For simplicty all third party java libs are in /usr/local/share/java

To build:

type scons PROTOBUF (yes 2 commands I am pissed off)
type scons

To Run:

>./testhelloworld

output:
