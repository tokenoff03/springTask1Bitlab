package com.example.task1spring.Controller;


import com.example.task1spring.DB.DBManager;
import com.example.task1spring.DB.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){

        return "index";
    }

    @GetMapping("/list")
    public String studentList(Model model){
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("students", students);

        return "students-list";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(Model model,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name="exam") int exam){

        ArrayList<Student> students = DBManager.getStudents();
        String mark = null;
        if(exam>=90){
            mark = "A";
        }
        else if(75<=exam && exam <=89){
            mark = "B";
        }

        else if(60<=exam && exam <=74){
            mark = "C";
        }
        else if(50<=exam && exam <=59){
            mark = "D";
        }
        else mark = "F";
        students.add(new Student((long) (students.size()+1),name,surname,exam,mark));

        model.addAttribute("students", students);
        return "redirect:/list";
    }

}
