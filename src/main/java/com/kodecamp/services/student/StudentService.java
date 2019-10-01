package com.kodecamp.services.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/student" })
public class StudentService extends HttpServlet {

  private List<StudentDto> students = new CopyOnWriteArrayList<>();

  public StudentService() {
    System.out.println("StudentService : Constructor");
    this.students.addAll(getList());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("method : doGet");

    final ObjectMapper mapper = new ObjectMapper();

    final String jsonString = mapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(this.students);
    final PrintWriter writer = resp.getWriter();
    writer.write(jsonString);
    writer.close();

  }

  private List<StudentDto> getList() {
    final StudentDto studentDto1 = new StudentDto("1", "Dinesh", "Lucknow",
        "B.Tech");

    final StudentDto studentDto2 = new StudentDto("2", "Suresh", "Mumbai",
        "B.Tech");
    final StudentDto studentDto3 = new StudentDto("3", "Mahesh", "M.P",
        "B.Tech");

    students.add(studentDto1);
    students.add(studentDto2);
    students.add(studentDto3);
    return students;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Method : Post");
    final String jsonString = req.getParameter("student");
    System.out.println("request param " + jsonString);
    final ObjectMapper mapper = new ObjectMapper();
    final StudentDto newStudent = mapper.readValue(req.getInputStream(),
        StudentDto.class);
    System.out.println("New Student" + newStudent);
    this.students.add(newStudent);
    resp.getWriter()
        .write(mapper.writeValueAsString(newStudent));
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("method : doDelete");
    final ObjectMapper mapper = new ObjectMapper();
    final StudentDto studentToBeDeleted = mapper.readValue(req.getInputStream(),
        StudentDto.class);
    boolean flag = this.students.remove(studentToBeDeleted);
    resp.getWriter()
        .write("Is record deleted : " + flag);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
    System.out.println("method : doPut");
  }

}
