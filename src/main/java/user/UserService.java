package user;

import io.grpc.stub.StreamObserver;
import org.grpc.grpc.User;
import org.grpc.grpc.userGrpc;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("login----");
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)){
            response.setResponseCode(0).setResponsemessage("SUCCESS");
        } else {
            response.setResponseCode(1).setResponsemessage("INVALID PASSWORD");
        }

        // response를 전달하고 닫는다.
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();;
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
