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
#bldproto = env.Alias('Buildproto', env.Command('run.dummy', [], 'protoc --java_out=msg/java msg/*.proto'))
#env.AlwaysBuild(bldproto)
#Exit(0)
def ProtobufTarget(target, action):
        proto = Environment(ENV = os.environ,
                            BUILDERS = { 'proto' : Builder(action = action) })
        AlwaysBuild(proto.proto(target = target, source = 'SConstruct'))

ProtobufTarget('PROTOBUF', 'protoc --java_out=msg/java msg/*.proto')

#the project expect the following 2 jars to exist
#append zmq, protocol buffer and classes directory
env.Append( JAVACLASSPATH = ['/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar'] ) 
env.Append( JAVACLASSPATH = ['/usr/local/share/java/zmq.jar'] )
env.Append( JAVACLASSPATH = ['classes'] )

#build the protocol buffers classes
t = env.Java('classes', 'msg/java/hellomsg')
t = env.Java('classes', 'msg/java/worldmsg')
# make 2 jars. one for the hello msg client and the other for the world message
#server
env.Jar('classes/hellomsg.jar', 'classes/hellomsg')
env.Jar('classes/worldmsg.jar', 'classes/worldmsg')

#lastly build the client and the server
t = env.Java('classes', 'src')

#env.Jar('hwserver.jar', 'classes', JARCHDIR='classes')
