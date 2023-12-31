/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Account;
import com.ttn.service.AccountService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiAccountController {
    @Autowired
    private AccountService accountService; 
    
    @DeleteMapping("/account/accountManagement/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable (value = "id") int id) {
        this.accountService.deleteAccount(id);
    }
    
    @GetMapping("/accounts")
    @CrossOrigin
    public ResponseEntity<List<Account>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.accountService.getAccounts(params), HttpStatus.OK);
    }

}
