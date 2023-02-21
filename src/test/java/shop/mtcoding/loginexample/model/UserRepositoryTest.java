package shop.mtcoding.loginexample.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

@MybatisTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();
        String username = "ssar";
        String password = "1234";

        // when
        User result = userRepository.findByUsernameAndPassword(username, password);
        String responseBody = om.writeValueAsString(result);
        System.out.println("테스트 : " + responseBody);

        // then
        assertThat(result.getUsername()).isEqualTo("ssar");
    }

}
