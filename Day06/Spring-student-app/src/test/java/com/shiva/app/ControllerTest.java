package com.shiva.app;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @InjectMocks
    static
    Controller controller;
    @MockBean
    StudentOperation studentOperation;

    @BeforeEach
    void setUp(){
        studentOperation= Mockito.mock(StudentOperation.class);
        controller=new Controller(studentOperation);
    }

    @Test
    public void getStudentDataTest(){
        String name="myname";
        String role = "3454612";
        String schoolname="myschool";
        String age ="24";

        String expectedResult="Student data is :"+ name + "role number :" + role + "SchoolName :" + schoolname + " age :" + age;
        String result=controller.getStudentData(name,role,schoolname,age);
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void appendDataTest(){
        String name="myname";
        String age="21";
        String expectedResult=studentOperation.addString(name, age);
        String result=controller.appendData(name,age);
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void findprimeTest() {

        List<Integer> expectedResult= new ArrayList<>(Arrays. asList(0,1,1,2,3,5));
        //Mocking
        Mockito.when(studentOperation.findprime(anyInt())).thenReturn(expectedResult);
        List<Integer> result= controller.findprime(5);
        Assert.assertEquals(expectedResult.size(),result.size());
    }
    @Test
    public void studentDataTest(){

        StudentData data=new StudentData("myname","5643","myschool","23");
        StudentData result=controller.CreateStudentData(data);
        Assert.assertEquals(data.getName(),result.getName());
        Assert.assertEquals(data.getRoll(),result.getRoll());
        Assert.assertEquals(data.getSchoolName(),result.getSchoolName());
        Assert.assertEquals(data.getAge(),result.getAge());

        }


}
