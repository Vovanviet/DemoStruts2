package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;

public class StudentAction extends ActionSupport {
    StudentDao studentDao=new StudentDaoImpl();
    String name="";
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Student student=new Student(name,age);

    @Override
    public String execute() throws Exception {
        try {
            studentDao.create(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTER";
    }
}
