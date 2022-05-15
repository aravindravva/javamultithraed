class Hithread implements Runnable
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

class Hellothread implements Runnable
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
        Runnable h1=new Hithread();
        Runnable h2=new Hellothread();

        Thread t1= new Thread(h1);
        Thread t2=new Thread(h2);


        t1.start();
        t2.start();
    }
}
