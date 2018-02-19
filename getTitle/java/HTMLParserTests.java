import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

public class HTMLParserTests {

  @Test
  public void getTitleTest() {
    HttpTransport transport = new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setContent(
              "<html>\n" +
              "  <head>\n" +
              "    <title>Cool Title, Bro</title>\n" +
              "  </head>\n" +
              "  <body>\n" +
              "    <p>yo</p>\n" +
              "  </body>\n" +
              "</html>"
            );
            return response;
          }
        };
      }
    };
    HTMLParser p = new HTMLParser(transport);
    String title = "";
    try {
      title = p.getTitle(HttpTesting.SIMPLE_GENERIC_URL);
    } catch (IOException e) {
      System.out.println(e);
    }
    assertEquals(
      "Cool Title, Bro",
      title
    );
  }
}