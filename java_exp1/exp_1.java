public class Main {

   
    int area(int side) {
        return side * side;
    }

    
    int area(int length, int breadth) {
        return length * breadth;
    }

    

    public static void main(String[] args) {

        Main obj = new Main();
        System.out.println("Area of Square: " + obj.area(4));
        System.out.println("Area of Rectangle: " + obj.area(10, 5));
    }
}