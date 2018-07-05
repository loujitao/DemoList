package simple.producer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import java.util.Properties;

public class ProducerTest {

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.put("metadata.broker.list", "211.159.160.228:9092");
        prop.put("zookeeper.connect", "211.159.160.228:2181");
        prop.put("serializer.class", StringEncoder.class.getName());
        //ack是判别请求是否为完整的条件（就是是判断是不是成功发送了）。
        // 我们指定了“all”将会阻塞消息，这种设置性能最低，但是是最可靠的。
        //prop.put("acks", "all");

        //  retries，如果请求失败，生产者会自动重试，
        // 我们指定是0次，如果启用重试，则会有重复消息的可能性。
        //prop.put("retries", 0);

        // 缓存的大小是通过 batch.size 配置指定的
        //prop.put("batch.size", 16384);


        //设置了linger(逗留)时间为1毫秒，
        // 如果我们没有填满缓冲区，这个设置将增加1毫秒的延迟请求以等待更多的消息。
        //prop.put("linger.ms", 1);

        //控制生产者可用的缓存总量，如果消息发送速度比其传输到服务器的快，将会耗尽这个缓存空间。
        // 当缓存空间耗尽，其他发送调用将被阻塞，阻塞时间的阈值通过max.block.ms设定，之后它将抛出一个TimeoutException。
        //prop.put("buffer.memory", 33554432);
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
        int i = 0;
        while (i<30) {
            //send()方法是异步的
            producer.send(new KeyedMessage<String, String>("stevetao", "msg:" + i++));
            System.out.println("发送消息成功！");
            Thread.sleep(1000);
        }
        producer.close();
    }
}
