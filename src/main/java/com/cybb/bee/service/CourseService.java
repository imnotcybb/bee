package com.cybb.bee.service;

import com.cybb.bee.mapper.CourseMapper;
import com.cybb.bee.model.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public void add(Course course){
        courseMapper.insert(course);
    }

    public void update(Course course){
        courseMapper.update(course);
    }

    public void delete(Long id){
        courseMapper.delete(id);
    }

    public Course get(Long id){
        return courseMapper.findCourse(id);
    }

    public boolean exists(Long id){
        return courseMapper.findCourse(id) != null;
    }

    public List<Course> findCourseList(){
        return courseMapper.findCourseList();
    }
}
