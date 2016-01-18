env = Environment()
env['BUILD_ROOT'] = Dir('.');

# the 3 lines below build the protocol buffer java packages
Execute(Mkdir("msg/java"))
bldproto = env.Alias('Buildproto', env.Command('run.dummy', [], 'protoc --java_out=msg/java msg/*.proto'))
env.AlwaysBuild(bldproto)

# the 2 lines below builds the java source and puts them in the classes directory
env.Append( JAVACLASSPATH = ['/usr/local/share/java/zmq.jar'] )
t = env.Java('classes', 'src')

# also remove proto packages when clean is requested
if env.GetOption('clean'):
    Execute(Delete("msg/java")) 




#this jar command doesnt work. Need to figure that out
#env.Jar('hwserver.jar', 'classes', JARCHDIR='classes')
