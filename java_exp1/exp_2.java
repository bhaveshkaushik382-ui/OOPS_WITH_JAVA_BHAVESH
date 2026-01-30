public class Main {

    String name;
    int age;
  
    Main(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
    public static void main(String[] args) {
        Main s1 = new Main("Bhavesh", 20);
        Main s2 = new Main("Amit", 22);

        s1.display();
        System.out.println();
        s2.display();
    }
}

