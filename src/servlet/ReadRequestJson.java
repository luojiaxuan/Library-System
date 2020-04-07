package servlet;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class ReadRequestJson {
    public static String readJSONString(HttpServletRequest request){
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            String line;
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return URLDecoder.decode(json.toString());
    }
}
