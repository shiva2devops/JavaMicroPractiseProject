package com.account.app;

import com.account.app.controller.AccountController;
import com.account.app.model.Account;
import com.account.app.service.RepositoryService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
    @InjectMocks
    AccountController accountController;
    @MockBean
    RepositoryService repositoryService;
    @BeforeEach
    void setUp(){
        repositoryService= Mockito.mock(RepositoryService.class);
        accountController=new AccountController(repositoryService);
    }
    @Test
    public void testGetAccount(){
        Account expectedAccount= new Account("123",20000,"account1");
        Mockito.when(repositoryService.getDetail(anyString())).thenReturn(expectedAccount);
        Account actualAccount=accountController.getAccountDetail("1234");
        Assert.assertEquals(actualAccount.getBalance(),expectedAccount.getBalance());
        Assert.assertEquals(actualAccount.getId(),expectedAccount.getId());
        Assert.assertEquals(actualAccount.getName(),expectedAccount.getName());
    }
    @Test
    public void testSaveAccount(){
//        Account expectedAccount= new Account("123",20000,"account1");
//        Mockito.when(repositoryService.saveAccounts(acc)).thenReturn((Map) expectedAccount);
//        Account actualAccount=accountController.saveAccount("121");

    }
    @Test
    public void testUpdateAccount(){
        Account expectedAccount= new Account("121",321,"SBI");
        Mockito.when(repositoryService.updateAccount(anyString(),anyInt())).thenReturn(expectedAccount);
        Account actualAccount=accountController.updateAccount("54674",234);
        Assert.assertEquals(actualAccount.getBalance(),expectedAccount.getBalance());

    }
    @Test
    public void testDeleteAccount(){
//        Account expectedAccount= new Account("121",321,"SBI");
//        Mockito.when(repositoryService.deleteAccount(anyString())).thenReturn((Map) expectedAccount);
//        Account actualAccount= (Account) accountController.deleteAccount("54674");
//        Assert.assertEquals(actualAccount.getId(),expectedAccount.getId());
    }

}
