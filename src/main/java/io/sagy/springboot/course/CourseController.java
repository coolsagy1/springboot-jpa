package io.sagy.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sagy.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses") 
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getcourse(@PathVariable String topicId,@PathVariable String courseId){
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addcourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deletecourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updatecourse(@PathVariable String topicId,@PathVariable String id,@RequestBody Course course){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(id, course);
	}
}
