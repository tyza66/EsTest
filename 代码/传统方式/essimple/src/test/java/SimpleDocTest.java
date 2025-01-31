import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import org.junit.jupiter.api.Test;

import static com.tyza66.essimple.dao.EsClientIniter.getClient;


import com.tyza66.essimple.entity.Post;

import java.util.HashMap;
import java.util.Map;

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

    // 删除文档示例
    @Test
    public void deleteSimpleDoc() throws Exception {
        ElasticsearchClient client = getClient();
        // 删除文档示例
        DeleteRequest deleteRequest = DeleteRequest.of(d -> d
                .index("posts")
                .id("1")
        );

        DeleteResponse deleteResponse = client.delete(deleteRequest);
        System.out.println("Document deleted: " + deleteResponse.result());
    }

    // 更新文档示例
    @Test
    public void updateSimpleDoc() throws Exception {
        ElasticsearchClient client = getClient();
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "update message");
        // 更新文档示例 - 局部更新
        UpdateRequest<Map<String, Object>, Map<String, Object>> updateRequest = UpdateRequest.of(u -> u
                .index("posts")
                .id("1")
                .doc(map)
        );

        UpdateResponse<Map<String, Object>> updateResponse = client.update(updateRequest, Map.class);
        System.out.println("Updated version: " + updateResponse.version());
    }

    // 获取指定id的文档示例
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
