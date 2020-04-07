
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {
    Logger logger = Logger.getLogger(UnitTest.class);

    @Test
    public void  print() {
        logger.info("这是一条info 日志");
        logger.warn("这是一条warn 日志");
        logger.debug("这是一条debug 日志");
        logger.error("这是一条error 日志");
    }
}
