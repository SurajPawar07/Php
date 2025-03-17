//Define a thread called `PrintText_Thread` for printing text on the command prompt `n` number of times. Create three threads and run them. Pass the text and `n` as parameters to the thread constructor. Example:
- First thread prints "I am in FY" 30 times.
- Second thread prints "I am in SY" 20 times.
- Third thread prints "I am in TY" 80 times.




  
  class PrintText_Thread implements Runnable {
    String name;
    Thread t;
    int i, cnt;

    PrintText_Thread(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for (i = 1; i <= cnt; i++) {
                System.out.println("I am in " + name + " " + i);
                Thread.sleep(1000);
            }
            System.out.println("** " + name + " exiting. **");
        } catch (InterruptedException e) {}
    }
}

class Ass2SetAExtra {
    public static void main(String args[]) {
        new PrintText_Thread("FY", 30);
        new PrintText_Thread("SY", 20);
        new PrintText_Thread("TY", 80);
    }
}
