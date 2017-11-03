package cn.demo.service0.controller;

import cn.g2link.storage.api.IStorageHandler;
import cn.g2link.storage.common.dto.StorageInputDTO;
import cn.g2link.storage.common.dto.StorageOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Leo
 * @Blog: http://blog.csdn.net/lc0817
 * @CreateTime: 2017/1/19 12:13
 * @Description:
 */
@RestController
public class Service0Controller {
    public static class User {
        private int id;
        private String name;

        private Student student;

        public User() {
        }

        public int getId() {
            return id;
        }

        public User setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Student getStudent() {
            return student;
        }

        public User setStudent(Student student) {
            this.student = student;
            return this;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", student=" + student +
                    '}';
        }
    }

    public static class Student {
        private String stuName;

        public Student() {
        }

        public String getStuName() {
            return stuName;
        }

        public Student setStuName(String stuName) {
            this.stuName = stuName;
            return this;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuName='" + stuName + '\'' +
                    '}';
        }
    }

    /**
     * 用于测试ribbon 重试机制
     */
    int count = 0;

    @Autowired
    private IStorageHandler storageHandler;

    @GetMapping("user/{userId}/{sleepSec}")
    String user(
            @PathVariable String userId,
            @PathVariable int sleepSec
    ) {
        try {
            System.out.println("hello:" + userId);
            count++;
            TimeUnit.SECONDS.sleep(sleepSec - count);

            InputStream is = new FileInputStream(new File("/Users/g2/Downloads/874aa55c0fd12aefd4b924a13d30de38.jpg"));

            StorageInputDTO inputDTO = StorageInputDTO.getBuilder().setInputStream(is).setFileName("aaa.jpg").setBucketName("ucenter-test").builder();
            StorageOutputDTO outputDTO = storageHandler.putObject(inputDTO);
            System.err.println(outputDTO.getOssUrl());
            return "hello:" + userId;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping("test")
    String post(
            @RequestBody User user
    ) {
        System.out.println(user.toString());
        return user.toString();
    }

}
