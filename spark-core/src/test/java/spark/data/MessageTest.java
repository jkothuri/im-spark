package spark.data;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageTest {
    @Tag("DEV")
    @Test
    void testMessage(){
        Message message=new Message("hello","Matt","Chris");
        assertAll(
                ()->assertTrue(true),
                ()->assertNotNull(message),
                ()->assertTrue(message.getId()==0)
        );
    }
}
