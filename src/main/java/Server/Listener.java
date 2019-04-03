package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void start(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("connection accepted");
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;
            StringBuilder responseBody = new StringBuilder();

            inputLine = in.readLine();
            String[] requestLine = inputLine.split(" ");

            String message = String.format("this is the %s page", requestLine[1]);

            responseBody.append(String.format("You sent a %s request to the route %s\n", requestLine[0], requestLine[1]));

            inputLine = in.readLine();
            requestLine = inputLine.split(" ");

            responseBody.append(String.format("You sent the request using host %s", requestLine[1]));

            System.out.println(responseBody.toString());
//            out.println(responseBody.toString());
//            out.println("<h1> Welcome to my Website</h1>");
//            out.println(String.format("<p>%s</p>", message));
//
//            out.println("<img src=\"https://images.mentalfloss.com/sites/default/files/styles/mf_image_16x9/public/57159-istock-486456250.jpg?itok=pYToxS1l&resize=1100x1100\" />");
            out.println("{\"name\": \"Jim\", \"favorite_food\": \"bananas\", \"profile_pic\": \"https://www.ripleys.com/wp-content/uploads/2018/11/koala-thumb.jpg\"}");
            out.close();
        }
    }
}
