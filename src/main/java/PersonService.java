import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.util.Random;
import lombok.Builder;
import server.domain.person.PersonRequest;
import server.domain.person.PersonResponse;
import server.domain.person.PersonServiceGrpc.PersonServiceImplBase;

@Builder
public class PersonService extends PersonServiceImplBase {

  @Override
  public void createPerson(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
    System.out.println(LocalDateTime.now() + " : Received " + request);

    PersonResponse personResponse = PersonResponse.newBuilder()
      .setId(new Random().nextInt())
      .setName(request.getName())
      .setAge(request.getAge())
      .build();

    responseObserver.onNext(personResponse);
    responseObserver.onCompleted();
  }

}
