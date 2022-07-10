import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleSocket {
    public static void main(String[] args) throws IOException {
//        Соединение с сервером java-course.ru по 80 порту
        Socket socket = new Socket("java-course.ru", 80);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

//Формитуем HTTPзапрос,
        String command = "GET /sitemap.xml HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
//        Формируем  запрос
        os.write(command.getBytes());
//        Немеденно отправляем запрос
        os.flush();

        int c = 0;
//        Читаем ответ
        while ((c = is.read()) != -1){
            System.out.print((char) c);
        }

        socket.close();
    }
}
