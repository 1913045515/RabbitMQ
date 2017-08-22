package lzq.boot.queue.croner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lzq.boot.queue.entity.Consumer;
import lzq.boot.queue.util.Contants;

/**
 * 
 * @author linzhiqiang
 * 消费者的定时任务
 */
@Component
public class ConsumerCroner {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerCroner.class);
	private Consumer consumer=new Consumer("127.0.0.1",Contants.XT.DEFAULT);
	private int accout=1;
	@Scheduled(fixedRate = 5000)
	public void consumeInfo() throws Exception {
		if(accout==1){
			consumer.deleteMassage();
		}
		accout=0;
//		logger.info("定时任务消费了消息。。。。。这是消费第"+accout+"条信息！！！");
//		accout++;
	}
}
