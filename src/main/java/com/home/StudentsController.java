package com.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StudentsController {
	@RequestMapping(value = "/students")
	public String index(Model model) {
		model.addAttribute("message", "トップページプルリク");
		return "students";
	}
	@RequestMapping(value = "/students/detail/{id}")
    public String detail(Model model,@PathVariable("id")int id) {
	    model.addAttribute("message", "詳細画面");
	    model.addAttribute("student", get_student(id));
        return "/students/detail";
	}

	public Student get_student(int id){
	  List<Student> all_student = stinit();
	  return all_student.get(id);
	}
	public List<Student> stinit(){
	  List<Student> stlist = new ArrayList<>(Arrays.asList(
	      new Student(0,"a",0,170f,true),
	      new Student(1,"b",1,166f,false),
	      new Student(2,"c",2,145f,true),
	      new Student(3,"d",3,185f,false)
	      ));
	  return stlist;
	}
}
