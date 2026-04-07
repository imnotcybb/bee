package com.cybb.bee.controller;

import com.cybb.bee.model.Course;
import com.cybb.bee.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public void add(@RequestBody Course course) {
        courseService.add(course);
    }

    @PostMapping("/update")
    public void update(@RequestBody Course course) {
        courseService.update(course);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") long id) {
        courseService.delete(id);
    }

    @GetMapping("/query")
    public Course qq(@RequestParam("id") long id) {
        return courseService.get(id);
    }

    @GetMapping("/list")
    public List<Course> list() {
        return courseService.findCourseList();
    }
}
