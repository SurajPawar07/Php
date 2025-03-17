//Write a program that creates threads, each displaying a message. Pass the message as a parameter to the constructor. The threads should display the messages continuously until the user presses `Ctrl+C`. Also, display the thread information as it is running.

class NewThread implements Runnable {
    Thread t;
    String str;

    NewThread(String str) {
        t = new Thread(this);
        this.str = str;
        System.out.println(t);
        t.start();
    }

    public void run() {
        try {
            for (;;) {
                Thread.sleep(500);
                System.out.println(str);
            }
        } catch (InterruptedException e) {}
    }
}

class Ass2SetA1 {
    public static void main(String args[]) {
        new NewThread("One");
        new NewThread("Two");
    }
}
