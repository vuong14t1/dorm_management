package com.example.dorm_management.services;

import com.example.dorm_management.entities.Account;

import java.util.List;

public interface AccountService {
    List<Account> findUserByRoomId(Integer roomId);
}
