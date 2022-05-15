class display
{
    int k=1;
    synchronized void show(int i) 
    {
        // First decide on what to wait since at first it should start first with 0 so we will wait till 1
        while(i%2==k){
            try
            {
                wait();
        }
        catch(InterruptedException e)
        {
        e.printStackTrace();
        }};    
        // the case changes everytime since we will print even first odd later 
        k=k==0 ? 1:0;
        System.out.println(i);
        notify();
    }
}

class EvenThread implements Runnable
{
    display d;
    public void setdisplay(display di)
    {
        this.d=di;
    }
    public void run()
    {
        for(int i=0;i<100;i=i+2)
        {
            d.show(i);
        }
    }
}

class OddThread implements Runnable
{
    display d;
    public void setdisplay(display di)
    {
        this.d=di;
    }
    public void run()
    {
        for(int i=1;i<100;i=i+2)
        {
            d.show(i);
        }
    }
}



public class evenodd {
    public static void main(String[] args) throws InterruptedException {
        display d=new display();
        
        EvenThread e=new EvenThread();
        OddThread o=new OddThread();

        e.setdisplay(d);
        o.setdisplay(d);

        Thread t1=new Thread(e);
        Thread t2=new Thread(o);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}
