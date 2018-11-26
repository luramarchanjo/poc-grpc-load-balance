import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import server.domain.person.PersonRequest;
import server.domain.person.PersonServiceGrpc;
import server.domain.person.PersonServiceGrpc.PersonServiceBlockingStub;

public class ClientApplication {

  public static void main(String... arguments) throws InterruptedException {
    while (true) {
      ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8443)
        .usePlaintext(true)
        .build();

      PersonServiceBlockingStub stub = PersonServiceGrpc.newBlockingStub(managedChannel);
      PersonRequest personRequest = PersonRequest.newBuilder()
        .setName(UUID.randomUUID().toString())
        .setAge(new Random().nextInt())
        .build();
      System.out.println("Sending request " + personRequest);
      stub.createPerson(personRequest);
      managedChannel.shutdown();
      TimeUnit.MILLISECONDS.sleep(250l);
    }
  }

}
