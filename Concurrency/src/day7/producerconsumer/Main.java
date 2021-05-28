package day7.producerconsumer;

public class Main {
    public static void main(String[] args) {
    	BoundedBufferWN buff = new BoundedBufferWN(5); 
        new Producer("Producer-1", buff, 31415).start();
        new Producer("Producer-2", buff, 92653).start();
//        new Producer("Producer-3", buff, 58979).start();
        new Consumer("Consumer-1", buff, 32384).start();
//        new Consumer("Consumer-2", buff, 62643).start();
//        new Consumer("Consumer-3", buff, 38327).start();
    }
}
