import com.tyza66.essimple.dao.EsClientIniter;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.tyza66.essimple.dao.EsClientIniter.getClient;

public class SimpleDocTest {

    @Test
    public void ping() throws Exception {
        RestHighLevelClient client = getClient();
        try {
            boolean response = client.ping(RequestOptions.DEFAULT);
            System.out.println("Ping response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void AddSimpleDoc() throws Exception {
        RestHighLevelClient client = getClient();
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2023-01-31\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        IndexRequest request = new IndexRequest("posts")
                .id("1")
                .source(jsonString, XContentType.JSON);

        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
        client.close();

    }
}
