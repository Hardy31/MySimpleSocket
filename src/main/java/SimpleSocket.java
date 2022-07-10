import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("java-course.ru", 80);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

//        String command = "GET / HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
//        String command = "GET /examples/ HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
//        String command = "GET /docs/ HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
        String command = "GET /sitemap.xml HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
        os.write(command.getBytes());
        os.flush();

        int c = 0;
        while ((c = is.read()) != -1){
            System.out.print((char) c);
        }

        socket.close();
    }
}
