package com.home;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentsController {
	@RequestMapping(value = "/students")
	public String index(Model model) {
	    List<Student> stlist = stinit();

		model.addAttribute("stlist", stlist);
		return "students";
	}
	@RequestMapping(value = "/students/detail/{id}")
    public String detail(Model model,@PathVariable("id")int id) {
	    Student target = get_student(id);
	    model.addAttribute("name", target.name);
	    model.addAttribute("height", target.height);
	    model.addAttribute("weight", target.weight);
	    model.addAttribute("todays", target.isTodayDinner);
	    model.addAttribute("zayuu", target.zayuu);
        return "/studentsdetail";
	}

	public Student get_student(int id){
	  List<Student> all_student = stinit();
	  return all_student.get(id);
	}
	public List<Student> stinit(){
	  List<Student> stlist = new ArrayList<>(11);

	  try {
        BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("students.csv")));
        String line;
        line = br.readLine();
        while((line = br.readLine()) != null) {
          String [] data = line.split(",",0);
          stlist.add(new Student(data[0], data[1], data[2], data[3], data[4], data[5]));
        }
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return stlist;
	}
}
