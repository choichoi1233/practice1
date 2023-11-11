package com.example.practice1.service;

import com.example.practice1.Model.User;
import com.example.practice1.repo.RestInterface;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class RestService {

  private final RestInterface restInterface;

    public int GetAllUserCnt(){

      int result = (int)restInterface.GetAllUserCnt();
      return result;
    }

    public long UserSaveProc(long userid , String name) {
      User user = new User(userid, name, (int) (Math.random()*100));

      System.out.println(user.toString());
      User result = restInterface.save(user);
      return  result.getId();
    }

  public List<User> UserSearch(User userSearch) {
      return restInterface.UserSearch(userSearch);
  }
}
