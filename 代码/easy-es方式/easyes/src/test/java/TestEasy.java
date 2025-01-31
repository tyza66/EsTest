import com.tyza66.essimple.Application;
import com.tyza66.essimple.mapper.DocumentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class TestEasy {
    // 注入这个mapper
    @Autowired
    private DocumentMapper documentMapper;

    @Test
    public void testCreateIndex() {
        // 测试创建索引,框架会根据实体类及字段上加的自定义注解一键帮您生成索引 需确保索引托管模式处于manual手动挡(默认处于此模式),若为自动挡则会冲突
        boolean success = documentMapper.createIndex();
        Assertions.assertTrue(success);
    }
    // 本中间件暂时不支持es8
}
