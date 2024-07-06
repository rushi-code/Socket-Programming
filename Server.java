import java.net.*;
import java.io.*;

class Server
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Server Application is Running...");

        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is running at port no : 2100");

        Socket s = ssobj.accept();

        System.out.println("Server and Client Connection is Successful");

        PrintStream ps = new PrintStream(s.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Chat Messenger Started ...");

        String str1, str2;

        while((str1 = br1.readLine())!=null)
        {
            System.out.println("Client says : "+str1 );
            System.out.println("Enter Message for client : ");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("Thank you for using Chat Messenger.");

        ssobj.close();
        s.close();
        ps.close();
        br1.close();
        br2.close();
    }
}

