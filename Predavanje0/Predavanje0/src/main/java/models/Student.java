package models;

public class Student extends Person {
    private long index;

    public Student() {
        super();
    }

    public Student(long index, int age, double height) {
        super(age, height, "Hi");
        this.index = index;
    }

    public Student(long index, int age, double height, String name) {
        super(age, height, name);
        this.index = index;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean isReducedPrice() {
        return age < 25;
    }

    @Override
    public void printName() {
        super.printName();
    }


    public void print() {

    }

    public void print(int a) {

    }

    public void print(int a, int b) {

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", height=" + height +
                ", index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
