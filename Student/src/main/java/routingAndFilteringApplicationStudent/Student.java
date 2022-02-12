package routingAndFilteringApplicationStudent;

import java.util.Objects;

public class Student {
    int id;

    int age;

    String name;

    String classDiv;

    public Student() {}

    public Student(int id, int age, String name, String classDiv) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.classDiv = classDiv;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassDiv() {
        return this.classDiv;
    }

    public void setClassDiv(String classDiv) {
        this.classDiv = classDiv;
    }

    public String toString() {
        return "Student{id=" + this.id + ", age=" + this.age + ", name='" + this.name + '\'' + ", classDiv='" + this.classDiv + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student)o;
        return (this.id == student.id && this.age == student.age && this.name

                .equals(student.name) && this.classDiv
                .equals(student.classDiv));
    }

    public int hashCode() {
        return Objects.hash(new Object[] { Integer.valueOf(this.id), Integer.valueOf(this.age), this.name, this.classDiv });
    }
}
