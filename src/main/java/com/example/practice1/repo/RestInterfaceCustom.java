package com.example.practice1.repo;


import com.example.practice1.Model.User;

import java.util.List;

public interface RestInterfaceCustom {

      long GetAllUserCnt();

      List<User> UserSearch(User userSearch);
}
