
public class ProducerStarter {
    public static void main(String[] args) throws InterruptedException {
        
    LocationProducer lp = new LocationProducer();

    for (int i = 0; i < 10; i++) {

        System.out.println("sending message...");

        lp.Log();
        
        System.out.println("message sent, now sleeping...");

        Thread.sleep(1000);
    }
        
    }
}