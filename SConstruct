env = Environment()
import os
#remove proto packages when clean is requested
if env.GetOption('clean'):
    Execute(Delete("msg/java")) 
    Execute(Delete("classes/hellomsg")) 
    Execute(Delete("classes/hellomsg.jar")) 
    Execute(Delete("classes/worldmsg")) 
    Execute(Delete("classes/worldmsg.jar")) 
    Execute(Delete("classes/hwclient.class")) 
    Execute(Delete("classes/hwserver.class")) 
    Exit(0)

# build the protoco buffers
Execute(Mkdir("msg/java"))

def ProtobufTarget(target, action):
        proto = Environment(ENV = os.environ,
                            BUILDERS = { 'proto' : Builder(action = action) })
        AlwaysBuild(proto.proto(target = target, source = 'SConstruct'))

ProtobufTarget('PROTOBUF', 'protoc --java_out=msg/java msg/*.proto')
#copy the dynamicall protobuf java files to src directory for convenience
Command("msg/java/hellomsg/HelloOuterClass.java", [], Copy("$TARGET", "src"))
Command("msg/java/worldmsg/WorldOuterClass.java", [], Copy("$TARGET", "src"))

#the project expect the following 2 jars to exist
#append zmq, protocol buffer and classes directory
env.Append( JAVACLASSPATH = ['/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar'] ) 
env.Append( JAVACLASSPATH = ['/usr/local/share/java/zmq.jar'] )
env.Append( JAVACLASSPATH = ['classes'] )

#build the protocol buffers classes
t = env.Java('classes', ['msg/java/hellomsg','msg/java/worldmsg'])

#lastly build the client and the server
env.Java('classes', 'src')
