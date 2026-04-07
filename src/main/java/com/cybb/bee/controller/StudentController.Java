package com.cybb.bee.controller;

import com.cybb.bee.model.Student;
import com.cybb.bee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    /**
     * 1、使用 @Autowired 告诉系统
     * 2、我需要一个 StudentService 类型的工具
     * 3、系统就会从容器（Spring 容器）当中找到 StudentService 类型的工具
     * 4、并且放到这里，成为这个类的成员变量
     */
    @Autowired
    private StudentService studentService;

    //GET 
    @GetMapping("/query")
    public Student ff1(@RequestParam("id") long id) {
        return studentService.get(id);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") long id) {
        studentService.delete(id);
    }

    @GetMapping("/list1")
    public List<Student> ff2(@RequestParam("id")long id){
        return studentService.list();
    }

    @GetMapping("/update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }
    /**
     * curl -X POST http://localhost:8080/user \
     *   -H "Content-Type: application/json" \
     *   -d '{"name":"cy","age":25}'
     *
     * RequestBody 作用是 将 http post请求中的 -d '{"name":"cy","age":25}' 转换成对象
     */
    @PostMapping("/add")
    public void add(@RequestBody Student student){
        studentService.add(student);
    }

}