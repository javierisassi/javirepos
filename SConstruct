env = Environment()
import os
import sys
print 'Argument List:', str(sys.argv)
#remove proto packages when clean is requested
if env.GetOption('clean'):
    Execute(Delete("src/proto")) 
    Execute(Delete("classes/")) 
    Exit(0)

def ProtobufTarget(target, action):
        proto = Environment(ENV = os.environ,
                            BUILDERS = { 'proto' : Builder(action = action) })
        AlwaysBuild(proto.proto(target = target, source = 'SConstruct'))

if ( len(sys.argv) > 1 ):
    if str(str(sys.argv[1]) == "PROTOBUF"):
	Execute(Mkdir("src/proto"))
	ProtobufTarget('PROTOBUF', 'protoc --java_out=src/proto msg/*.proto')

#if the protocol buffer java files have not been created, create them
if not os.path.isdir("src/proto"):
    print("You need to build the protocol buffers java files first\n")
    print("Type: scons PROTOBUF")
    Exit(0)

#the project expect the following 2 jars to exist
#append zmq, protocol buffer and classes directory
env.Append( JAVACLASSPATH = ['/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar'] ) 
env.Append( JAVACLASSPATH = ['/usr/local/share/java/zmq.jar'] )
env.Append( JAVACLASSPATH = ['classes'] )

#lastly build the client and the server
env.Java('classes', 'src')
