package java_ex.multithreading;

public class EvenOdd {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread t1 = new Thread(new TaskEvenOdd(printer, 10, false),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(printer, 10, true), "Even");
        t1.start();
        t2.start();
    }

    private static class Printer{
        private volatile boolean isOdd;

        synchronized void printEven(int num){
            while(!isOdd){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + num);
            isOdd = false;
            this.notify();
        }

        synchronized void printOdd(int num){
            while (isOdd){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()+" : " + num);
            isOdd = true;
            this.notify();
        }
    }

    private static class TaskEvenOdd implements Runnable{

        private int max;
        private Printer printer;
        private boolean isEvenNumber;

        public TaskEvenOdd(Printer printer, int i, boolean b) {
            max=i;
            this.printer=printer;
            isEvenNumber=b;
        }


        @Override
        public void run() {
            int num = isEvenNumber ? 2 : 1;
            while(num<=max){
                if(isEvenNumber){
                    printer.printEven(num);
                }else{
                    printer.printOdd(num);
                }
                num+=2;
            }
        }
    }
}
