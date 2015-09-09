/**
 * Created by bulbatross on 2015-09-08.
 */
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws IOException
    {
        String serverHostname = args[0]; int port = Integer.parseInt(args[1]);
        Socket echoSocket = new Socket(serverHostname, port);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                        echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;
        while(!in.readLine().equals("OK"))
        {
            System.out.print ("input(write 'HELLO' to poke the server): ");
            out.println(stdIn.readLine());
        }

        while(!in.readLine().equals("READY"))
        {
            System.out.print ("input (write 'ŚTART' whenever you are ready): ");
            out.println(stdIn.readLine());
        }

        System.out.print ("input (GUESS [number]): ");
        while ((userInput = stdIn.readLine()) != null)
        {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
            System.out.print("input (GUESS [number]): ");
        }


        out.close(); in.close(); stdIn.close(); echoSocket.close();
    }
}
