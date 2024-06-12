package com.kh.TotalEx.cotroller;

import com.kh.TotalEx.dto.MemberReqDto;
import com.kh.TotalEx.dto.MemberResDto;
import com.kh.TotalEx.dto.TokenDto;
import com.kh.TotalEx.service.AuthService;
import com.kh.TotalEx.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final MemberService userService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberReqDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberResDto>> memberList() {
        List<MemberResDto> list = userService.getMemberList();
        return ResponseEntity.ok(list);
    }
}
