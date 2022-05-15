class Hithread extends Thread
{
   public void run()
    {
        for(int i=0;i<5;i++)
        {
        System.out.println("Hi");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }
    }
}

class Hellothread extends Thread
{
   public void run()
    {
        for(int i=0;i<5;i++)
        {
        System.out.println("Hello");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }
    }
}


public class HiHello{
    public static void main(String[] args) {
        Hithread h1=new Hithread();
        Hellothread h2=new Hellothread();

        h1.start();
        h2.start();
    }
}
