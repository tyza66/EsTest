import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import org.junit.jupiter.api.Test;

import static com.tyza66.essimple.dao.EsClientIniter.getClient;


import com.tyza66.essimple.entity.Post;

public class SimpleDocTest {

    @Test
    public void ping() throws Exception {
        ElasticsearchClient client = getClient();
        // 进行 ping 测试
        InfoResponse infoResponse = client.info();
        System.out.println("Cluster name: " + infoResponse.clusterName());

    }

    // 插入文档示例
    // 日期格式为 yyyy-MM-dd会自动存为Date类型
    @Test
    public void AddSimpleDoc() throws Exception {
        ElasticsearchClient client = getClient();
        // 插入文档示例
        IndexRequest<Object> request = IndexRequest.of(i -> i
                .index("posts")
                .id("1")
                .document(new Post("kimchy", "2023-01-31", "trying out Elasticsearch"))
        );

        IndexResponse response = client.index(request);
        System.out.println("Indexed with version: " + response.version());
    }

    @Test
    public void getSimpleDoc() throws Exception {
        ElasticsearchClient client = getClient();
        // 获取文档示例
        GetRequest getRequest = GetRequest.of(g -> g
                .index("posts")
                .id("1")
        );

        GetResponse<Post> getResponse = client.get(getRequest, Post.class);
        if (getResponse.found()) {
            Post post = getResponse.source();
            System.out.println("Document retrieved: " + post);
        } else {
            System.out.println("Document not found.");

        }

    }
}
