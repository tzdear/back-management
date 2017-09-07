package com.ly.service.stopm.impl;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ly.service.stopm.IStompService;

/**
* @ClassName: StompServiceImpl
* @Description: 
* @author linyan
* @date 2017年8月18日 上午9:18:56
*
*/
@Service
public class StompServiceImpl implements IStompService{

	private SimpMessagingTemplate template;

	/* （非 Javadoc）
	 * @see com.ly.service.stopm.IStompService#sendText(java.lang.String)
	 */
	@Override
	public void sendText(String text) {
		template.convertAndSend("/topic/greetings",text);
//		template.convertAndSend(text);
		
	}
	
}
