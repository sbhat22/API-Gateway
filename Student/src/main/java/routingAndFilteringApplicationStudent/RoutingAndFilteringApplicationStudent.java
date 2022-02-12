package routingAndFilteringApplicationStudent;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class RoutingAndFilteringApplicationStudent {

    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, 12, "Emmy Jackson", "Class 7-A"));
        studentList.add(new Student(2, 15, "John Stephan", "Class 10-D"));
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/get-students/internal"})
    public List<Student> getStudentsPersonal() {
        return studentList;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/get-students"})
    public List<Student> getStudents() {
        return studentList;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/get-student/{id}"})
    public Student getStudent(@PathVariable int id) {
        return studentList.stream().filter(s -> (s.getId() == id)).findFirst().get();
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add-student"}, consumes = {"application/json"})
    public String addStudent(@RequestBody Student student) {
        studentList.add(student);
        return "Student data added successfully!!";
    }

    @RequestMapping(method = {RequestMethod.PATCH}, value = {"/update-student/{id}"})
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (id == s.getId()) {
                studentList.set(i, student);
                return "Updated data successfully!!";
            }
        }
        return "No such student data present.";
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = {"/delete-student/{id}"})
    public String deleteStudent(@PathVariable int id) {
        studentList.removeIf(s -> (s.getId() == id));
        return "Student data deleted successfully!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutingAndFilteringApplicationStudent.class, args);
    }
}
