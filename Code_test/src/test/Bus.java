package test;

public class Bus extends Car{
    static int cc = 2;
    int add(int a, int b){
        return a + b + this.cc + super.cc;
    }
    int add(long a, int b){
        return (int) a + b + df;
    }
    int add(long a, long b){
        return (int) (a + b);
    }
    int add(int a, long b){
        return (int) (a * b);
    }
    String add(){
        return "Add";
    }
    @Override
    void run() {
        System.out.println("버스 출바알~");
    }
}
