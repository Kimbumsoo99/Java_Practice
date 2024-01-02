class Main
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("one" == "one"); // true
        String aa = "one";
        String bb = "one";
        String cc = new String("one");
        System.out.println(aa == bb);   // true
        System.out.println(aa == cc); // false
        System.out.println(aa.equals(cc)); // true

        switch (3){ // 1,2,3 전부 나온다.
            case 3:
                System.out.println(1);
            case 4:
                System.out.println(2);
            default:
                System.out.println(3);
        }
    }
}