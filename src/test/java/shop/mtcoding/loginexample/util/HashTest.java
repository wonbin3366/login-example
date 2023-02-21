package shop.mtcoding.loginexample.util;

import org.junit.jupiter.api.Test;

public class HashTest {

    @Test
    public void encodePassword_test() throws Exception {

        System.out.println("테스트 : " + Hash.encodePassword("1234"));
    }
}
