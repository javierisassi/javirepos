import org.zeromq.ZMQ;

// the hello world server here is a bit different.
// It expects the hello message defined as a protocol buffer
// string and replies with a string: world also defined as a
// protocol buffer
import worldmsg.WorldOuterClass.World;

public class hwserver {

    public static void main(String[] args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);
        World.Builder msg = World.newBuilder();

        //  Socket to talk to clients
        ZMQ.Socket responder = context.socket(ZMQ.REP);
        responder.bind("tcp://*:5555");

        while (!Thread.currentThread().isInterrupted()) {
            // Wait for next request from the client
            byte[] request = responder.recv(0);
            System.out.println("Received: " + new String(request));

            // Do some 'work'
            Thread.sleep(1000);

            msg.setWorld("World");
            // Send reply back to client
            String reply = "World";
            //responder.send(reply.getBytes(), 0);
            responder.send(msg.getWorld(), 0);
        }
        responder.close();
        context.term();
    }
}
