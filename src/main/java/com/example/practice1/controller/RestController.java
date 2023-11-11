package com.example.practice1.controller;
import com.example.practice1.Model.User;
import com.example.practice1.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final RestService restService;

    @RequestMapping("/GetAllUserCnt")
    public int GetAllUserCnt(){
        int cnt = restService.GetAllUserCnt();
        return cnt;
    }

    @RequestMapping("/UserSaveProc")
    public long UserSaveProc(String name){

        // 방금 삽입한 유저의 pk번호가 반환된다.
        long userId = restService.UserSaveProc(0, name);
        return userId;
    }

    @RequestMapping("/UserSearch")
    public List<User> UserSearch(User userSearch){

        List<User> userlist = restService.UserSearch(userSearch);
        return userlist;
    }
}
