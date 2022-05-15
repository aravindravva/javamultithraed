class counter
{
    int count;

    public synchronized void increment()
    {
        count++;
    }

    int get()
    {
        return count;
    }
}

class Thread1 implements Runnable
{
    counter c;
    void getcounter(counter ct)
    {
        this.c=ct;
    }
    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            c.increment();
        }
    }
}

class Thread2 implements Runnable
{
    counter c;
    void getcounter(counter ct)
    {
        this.c=ct;
    }

    public void run()
    {
        for(int i=0;i<1000;i++)
        {
             c.increment();
        }
    }
}
public class count {
  public static void main(String[] args) throws InterruptedException{

    counter c=new counter();

    Thread1 t1=new Thread1();
    Thread T1=new Thread(t1);
    t1.getcounter(c);

    Thread2 t2=new Thread2();
    Thread T2=new Thread(t2);
    t2.getcounter(c);


    T1.start();
    T2.start();

    T1.join();
    T2.join();

    System.out.println(c.get());

      
  }  
}
