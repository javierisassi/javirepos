env = Environment()
env['BUILD_ROOT'] = Dir('.');

# the 3 lines below build the protocol buffer java packages
Execute(Mkdir("msg/java"))
bldproto = env.Alias('Buildproto', env.Command('run.dummy', [], 'protoc --java_out=msg/java msg/*.proto'))
env.AlwaysBuild(bldproto)

#the project expect the following 2 jars to exist
#append zmq, protocol buffer and classes directory
env.Append( JAVACLASSPATH = ['/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar'] ) 
env.Append( JAVACLASSPATH = ['/usr/local/share/java/zmq.jar'] )
env.Append( JAVACLASSPATH = ['classes'] )

#build the protocol buffers classes
t = env.Java('classes', 'msg/java')

# make 2 jars. one for the hello msg client and the other for the world message
#server
env.Jar('classes/hellomsg.jar', 'classes/hellomsg')
env.Jar('classes/worldmsg.jar', 'classes/worldmsg')

#lastly build the client and the server
t = env.Java('classes', 'src')

# also remove proto packages when clean is requested
if env.GetOption('clean'):
    Execute(Delete("msg/java")) 




#this jar command doesnt work. Need to figure that out
#env.Jar('hwserver.jar', 'classes', JARCHDIR='classes')
