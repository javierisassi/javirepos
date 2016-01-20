echo test hello world
export LD_LIBRARY_PATH=/usr/local/lib
java -classpath /usr/local/share/java/zmq.jar:/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar:classes hwserver &
#let us capture the pid to kill the server when done
PID=$(pgrep -f java)
java -classpath /usr/local/share/java/zmq.jar:/usr/local/share/java/protobuf-java-3.0.0-beta-2.jar:classes hwclient
echo this is your guy pid:$PID take care of it
kill -15 $PID

