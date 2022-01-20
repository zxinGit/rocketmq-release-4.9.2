package org.apache.rocketmq.example.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;

/**
 * @author zxin
 * @date 2022-01-13 14:33
 */
public class MainTest {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("192.168.197.7:9870;192.168.197.7:9871;192.168.197.7:9872");
        consumer.setConsumerGroup("cg-simple");
        consumer.subscribe("topic-simple", "TagB");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                if (CollectionUtils.isEmpty(list)) {
//                    logger.info("no message to consume");
//                }
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//                for (MessageExt messageExt : list) {
//                    Random random = new Random();
//            int i = random.nextInt(2);
//            logger.info("{}", i);
//                    if (true) {
//                        logger.info("消息：{} {}", new String(messageExt.getBody()), "消费失败");
//                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                    }
//                    logger.info("消费了消息：{},{}", new String(messageExt.getBody()), messageExt.getMsgId());
//                }

                for (MessageExt msg : msgs) {
                    System.out.println("消费了消息：" + msg);
                }

                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

        });
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setMaxReconsumeTimes(1);

        consumer.start();
    }
}
