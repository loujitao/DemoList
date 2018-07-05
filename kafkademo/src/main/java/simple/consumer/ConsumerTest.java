package simple.consumer;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConsumerTest {
            static final String topic = "stevetao";

               public static void main(String[] args) {
                 Properties prop = new Properties();
                   prop.put("metadata.broker.list", "211.159.160.228:9092");
                   prop.put("zookeeper.connect", "211.159.160.228:2181");

                 //  设置enable.auto.commit,偏移量由auto.commit.interval.ms控制自动提交的频率
                   prop.put("enable.auto.commit", "true");
                   prop.put("auto.commit.interval.ms", "1000");

                  prop.put("serializer.class", StringEncoder.class.getName());
                  prop.put("group.id", "group1");
                  ConsumerConnector consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
                  Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                 topicCountMap.put(topic, 1);
                 Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
                  final KafkaStream<byte[], byte[]> kafkaStream = messageStreams.get(topic).get(0);
                 ConsumerIterator<byte[], byte[]> iterator = kafkaStream.iterator();
                  while (iterator.hasNext()) {
                      String msg = new String(iterator.next().message());
                      System.out.println("收到消息："+msg);
                 }
           }

}



