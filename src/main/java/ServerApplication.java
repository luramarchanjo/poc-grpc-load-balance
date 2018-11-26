import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServerApplication {

  public static void main(String... arguments) throws IOException, InterruptedException {
    Integer port = Integer.valueOf(System.getenv("PORT"));
    Server server = ServerBuilder
      .forPort(port)
      .addService(PersonService.builder().build())
      .build();

    System.out.println("Started application on " + port);
    server.start();
    server.awaitTermination();
  }

}
