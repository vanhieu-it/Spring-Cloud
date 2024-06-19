package com.example.spring_eureka_client_student_service.controller;


import com.example.spring_eureka_client_student_service.entities.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schoolDB = new HashMap<String, List<Student>>();

	static {
		schoolDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Hieu", "Class 10");
		lst.add(std);
		std = new Student("Hang", "Class 12");
		lst.add(std);

		schoolDB.put("HighSchool_A", lst);

		lst = new ArrayList<Student>();
		std = new Student("Van", "Class 12");
		lst.add(std);
		std = new Student("Thu", "Class 11");
		lst.add(std);

		schoolDB.put("HighSchool_B", lst);

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schoolDB.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}
