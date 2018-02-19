// HTMLParser.java

import java.io.IOException;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HTMLParser {

  private HttpTransport transport;

  public HTMLParser() {
    transport = new ApacheHttpTransport();
  }

  public HTMLParser(HttpTransport xport) {
    transport = xport;
  }

  public String getTitle(String url) throws IOException {
    GenericUrl gurl = new GenericUrl(url);
    return getTitle(gurl);
  }

  public String getTitle(GenericUrl url) throws IOException {
    HttpRequest req = transport.createRequestFactory().buildGetRequest(url);
    HttpResponse res = req.execute();
    String html = res.parseAsString();
    Pattern p = Pattern.compile("<title>(.*?)</title>");
    Matcher m = p.matcher(html);
    m.find();
    return m.group(1);
  }
}