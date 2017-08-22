package lzq.boot.queue.croner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lzq.boot.queue.entity.Producer;
import lzq.boot.queue.util.Contants;

/**
 * 
 * @author linzhiqiang
 * 生产者的定时任务
 */
@Component
public class ProducerCroner {
	private static final Logger logger = LoggerFactory.getLogger(ProducerCroner.class);
	public Producer producer=new Producer("127.0.0.1", Contants.XT.DEFAULT);
	private int accout=1;
	@Scheduled(fixedRate = 1000)
	public void producerInfo() throws Exception {
//		if(accout<=10){
			producer.sentQueue("定时任务发送消息。。。。。这是第"+accout+"条信息！！！");
//		}
//		logger.info("定时任务发送消息。。。。。这是第"+accout+"条信息！！！");
		accout++;
	}
}
