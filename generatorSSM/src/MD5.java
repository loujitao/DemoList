import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

    public static void main(String[] args) {
     String upwd="123456";
      String md5String= DigestUtils.md5Hex(upwd.getBytes());
        System.out.println(md5String);
    }
}
