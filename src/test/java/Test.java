import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
    @org.junit.Test
    public void testMd5() throws NoSuchAlgorithmException {
        String a = "123456";
        String b = StringUtil.encode(a);
        System.out.println(b);

    }

}
