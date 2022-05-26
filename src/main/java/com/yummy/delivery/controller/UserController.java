package com.yummy.delivery.controller;

import com.yummy.delivery.dto.UserRequestDTO;
import com.yummy.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.yummy.delivery.httpStatus.httpComponent.RESPONSE_ENTITY_OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /* 사용자 조회 */
    @GetMapping("/{id}")
    public UserRequestDTO getUserList(@PathVariable("id") Long id) {
        return userService.getUserList(id);
    }

    /* 아이디(이메일) 중복확인 */
    @GetMapping("/signup/{email}")
    public void checkSameEmail(@PathVariable("email") String email) {
        userService.checkSameEmail(email);
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody UserRequestDTO userDTO) {
        userService.signUp(userDTO);
    }

    /* 가게 목록 조회
    @GetMapping("/home/{category}")
    public List<Store> findStoreListByCategory(@PathVariable("category") String category){
        return userService.findStoreListByCategory(category);
    }*/

    /* 회원 탈퇴 */
    @DeleteMapping("mypage/{email}")
    public void userWithdrawal(@PathVariable("email") String email) {
        userService.userWithdrawal(email);
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody UserRequestDTO userDTO) {
        userService.login(userDTO);
        return RESPONSE_ENTITY_OK;
    }

    /* 로그아웃 */
    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return RESPONSE_ENTITY_OK;
    }
}

/* @Param Annotation 방식 */
//@PostMapping("/user")
//    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        userService.signUp(email, password, name, phone, address);
//    }
