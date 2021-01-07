package com.vwits.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.model.DaoImplementation;
import com.vwits.model.Faculty;
import com.vwits.model.Result;
import com.vwits.model.Student;
import com.vwits.model.Test;

@Controller
public class Login {
	
	//Redirecting from Jsp pages
	@RequestMapping(value = "/redirect", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doMainStudentLogin(String url) {
		ModelAndView model = new ModelAndView();
		System.out.println(url);
		model.setViewName(url);
		
		
		
		return model;
	}
	//Main Page to studentLogin
	@RequestMapping(value = "/mainstudentlogin", method = RequestMethod.GET)
	public ModelAndView doMainStudentLogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("StudentLogin");
		
		
		
		return model;
	}
	//Main page to faculty login
	@RequestMapping(value = "/mainfacultylogin", method = RequestMethod.GET)
	public ModelAndView doMainFacultyLogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("FacultyLogin");
		
		
		
		return model;
	}
	//logout from student
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView doLogoutStudent(HttpSession session) {
		ModelAndView model = new ModelAndView();
		List<Student> l=(List<Student>) session.getAttribute("CurrentUser");
		if(l.size()>0)
		model.setViewName("StudentLogin");
		
		
		
		return model;
	}
	//logout from faculty
	@RequestMapping(value = "/flogout", method = RequestMethod.GET)
	public ModelAndView doLogoutFaculty(HttpSession session) {
		ModelAndView model = new ModelAndView();
		List<Faculty> l=(List<Faculty>) session.getAttribute("CurrentFacultyUser");
		if(l.size()>0)
		model.setViewName("FacultyLogin");
		
		
		
		return model;
	}
	//Controller for student Login
	@RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
	public ModelAndView doStudentLogin(@RequestParam("username") String a,@RequestParam("pass") String b, HttpSession session) {
		
		
		
		
		List<Student>list;
		ModelAndView model = new ModelAndView();
		DaoImplementation d=new DaoImplementation();
		list=d.getLogin(a, b);
		System.out.println(list.size());
		if(list.size()>0) {
			session.setAttribute("CurrentUser", list);
			model.setViewName("starttest");
		}else {
			model.setViewName("StudentLogin");
			model.addObject("data", "Invalid Credentials!!!!!");
		}
		
		
		return model;
	}
	//Controller for faculty login
	@RequestMapping(value = "/facultylogin", method = RequestMethod.POST)
	public ModelAndView doFacultyLogin(@RequestParam("username") String a,@RequestParam("pass") String b,HttpSession session) {
		
		
		List<Faculty>list;
		ModelAndView model = new ModelAndView();
		DaoImplementation d=new DaoImplementation();
		list=d.getLoginFaculty(a, b);
		if(list.size()>0) {
			session.setAttribute("CurrentFacultyUser", list);
			model.setViewName("FacultyInfo");
		}else {
			model.setViewName("FacultyLogin");
			model.addObject("data", "Invalid Credentials!!!!!");
		}
		
		
		return model;
	}
	//Controller for Student Registration
	@RequestMapping(value = "/studentregistration", method = RequestMethod.POST)
	public ModelAndView doRegisterStudent(@RequestParam("roll") int a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e) {
		ModelAndView model=new ModelAndView();
		Student s=new Student(a,b,c,d,e);
		DaoImplementation d1=new DaoImplementation();
		d1.insert(s);
		model.setViewName("StudentLogin");
		model.addObject("data", "Registered Successfully!!!!");
		d1.getAll();
		return model;
	}
	@RequestMapping(value = "/facultyregistration", method = RequestMethod.POST)
	public ModelAndView doRegisterFaculty(@RequestParam("id") int a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e) {
		ModelAndView model=new ModelAndView();
		Faculty f=new Faculty(a,b,c,d,e);
		DaoImplementation d1=new DaoImplementation();
		d1.insertFaculty(f);
		model.setViewName("FacultyLogin");
		model.addObject("data", "Registered Successfully!!!!");
		d1.getAllFaculty();
		return model;
	}
	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public ModelAndView doTest() {
		ModelAndView model=new ModelAndView();
		
		DaoImplementation d1=new DaoImplementation();
		
		
		List<Test> list=d1.getAllTest();
		model.setViewName("TestForm");
		model.addObject("data", list);
		
		
		return model;
	}
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView doCalculateResult(@RequestParam Map<String,String> answers,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		ModelAndView model=new ModelAndView();
		//request.getSession(false);
		DaoImplementation d1=new DaoImplementation();
		System.out.println("Map is"+answers);
		String name="";
		int roll=0;
		List<Student> list= (List<Student>) session.getAttribute("CurrentUser");
		
		if(list!=null)
		{
			
		String[] answer = new String[100];
		int[] tmarks=new int[100];
        List<Test> questionList = d1.getAllTest();
        int i = 0;
        int marks = 0;
        int total=0;
        int size = questionList.size();
        for(Test q : questionList)
               {   
                     answer[i] = q.getCorrectans();
                     tmarks[i]=q.getMarks();
                       i++;
               }
        String[] studentAnswer = new String[100];
        for(int j = 0 ; j < size ; j++)
               {
        	String opt=j+"";
                    studentAnswer[j] = answers.get(opt);
                     System.out.println(studentAnswer[j]);
               }
        
        int correctanswer=0;
        int unattempted = 0;
        int wronganswer=0;
        for(int k = 0 ; k< size;k++)
        {
               if(studentAnswer[k].equalsIgnoreCase(answer[k]))
               {
                     correctanswer++;
                     marks=marks+tmarks[k];
               }
               else if(studentAnswer[k].equals("e"))
               {
                     unattempted++;
               }
               else
               {
                     wronganswer++;
               }
               total=total+tmarks[k];
        }
        int attemped = size - unattempted;

			System.out.println(marks+"/"+total);
		model.setViewName("score");
		model.addObject("marks", marks);
		model.addObject("Total",total);
		model.addObject("attempted",attemped);
		
		
		
		for(Student l:list)
		{
			
			name=l.getName();
			roll=l.getRoll_no();
		}
		Result r=new Result(roll,name,marks,total);
		d1.insertResult(r);
		
		}
		
		return model;
	}
	@RequestMapping(value = "/insertquestion", method = RequestMethod.POST)
	public ModelAndView doInsertTest(@RequestParam("txtid") int a,@RequestParam("txtque") String b,@RequestParam("txtopt1") String c,@RequestParam("txtopt2") String d,@RequestParam("txtopt3") String e,@RequestParam("txtopt4") String f,@RequestParam("txtcorrect") String g,@RequestParam("txtmarks") int h) {
		ModelAndView model=new ModelAndView();
		
		DaoImplementation d1=new DaoImplementation();
		
		
		Test t=new Test(a,b,c,d,e,f,g,h);
		d1.insertTest(t);
		model.setViewName("AddQuestion");
		model.addObject("data", "Question Inserted!!!!");
		
		
		return model;
	}
	@RequestMapping(value = "/showquestions", method = RequestMethod.GET)
	public ModelAndView doDisplayQue() {
		ModelAndView model=new ModelAndView();
		
		DaoImplementation d1=new DaoImplementation();
		
		
		List<Test> list=d1.getAllTest();
		model.setViewName("DisplayQue");
		model.addObject("data", list);
		
		
		return model;
	}
	
	@RequestMapping(value = "/viewresult", method = RequestMethod.GET)
	public ModelAndView doDisplayResult() {
		ModelAndView model=new ModelAndView();
		
		DaoImplementation d1=new DaoImplementation();
		
		
		List<Test> list=d1.getAllResult();
		model.setViewName("ViewResult");
		model.addObject("data", list);
		
		
		return model;
	}
	
	@RequestMapping(value = "/getupdateFaculty", method = RequestMethod.GET)
	public ModelAndView doFacultyUpdate(HttpSession session) {
		ModelAndView model=new ModelAndView();
		String name="";
		String email="";
		String pass="";
		int con=0;
		int id=0;
		DaoImplementation d1=new DaoImplementation();
		List<Faculty> list= (List<Faculty>) session.getAttribute("CurrentFacultyUser");
		
		if(list!=null) {
			for(Faculty f:list) {
				id=f.getId();
				name=f.getName();
				email=f.getEmail();
				pass=f.getPassword();
				con=f.getContact();
			}
		}
		System.out.println(id+" "+name+" "+pass+" "+email+" "+con+" ");
		model.setViewName("UpdateFaculty");
		model.addObject("id", id);
		model.addObject("name", name);
		model.addObject("pass", pass);
		model.addObject("email", email);
		model.addObject("con", con);
		
		
		return model;
	}
	@RequestMapping(value = "/updatefaculty", method = RequestMethod.POST)
	public ModelAndView doFacultyUpdated(HttpSession session,@RequestParam("id") int a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e) {
		ModelAndView model=new ModelAndView();
		
			DaoImplementation d1=new DaoImplementation();
			Faculty f=new Faculty(a,b,c,d,e);
			d1.updateFaculty(f);
			model.setViewName("UpdateFaculty");
			return model;
		}
}
