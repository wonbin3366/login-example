package shop.mtcoding.loginexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.loginexample.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.loginexample.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.model.UserRepository;
import shop.mtcoding.loginexample.util.Hash;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinReqDto joinReqDto) {
        String password = joinReqDto.getPassword();

        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        String encodedPassword = Hash.encodePassword(password);

        int result = userRepository.insert(joinReqDto.getUsername(), encodedPassword, joinReqDto.getEmail());
        if (result != 1) {
            throw new CustomException("회원가입실패");
        }
    }

    @Transactional
    public User 로그인(LoginReqDto loginReqDto) {
        String password = loginReqDto.getPassword();

        String encodedPassword = Hash.encodePassword(password);

        User principal = userRepository.findByUsernameAndPassword(loginReqDto.getUsername(), encodedPassword);
        if (principal == null) {
            throw new CustomException("유저네임 혹은 패스워드가 잘못 입력되었습니다");
        }
        return principal;
    }
}
