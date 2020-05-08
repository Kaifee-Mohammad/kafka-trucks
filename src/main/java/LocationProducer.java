import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class LocationProducer{

    public void Log()
    {
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "1");
        props.put("linger.ms", "100000");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord<String,String> record = new ProducerRecord<String,String>("trucks", "location", Latitude() + "," + Longitude() );

        Producer<String, String> producer = new KafkaProducer<>(props);

        producer.send(record);

        producer.close();

    }

    private double Latitude(){
        return getRandomIntegerBetweenRange(100, 5000);
    }

    private double Longitude(){
        return getRandomIntegerBetweenRange(100, 5000);
    }

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}