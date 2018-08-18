package com.devops.dashboard.dataCollector.events;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;



@Controller
public class newBuildEvents {
	
	
	private SseEmitter emitter;
	
	
	@Component
	public class eventHandler {
		
		@EventListener
		public void handleEvent (RequestHandledEvent e) throws IOException {
			
			System.out.println(e.getDescription());
			System.out.println(e.getSource());
			System.out.println(e.getShortDescription());
			System.out.println(e.toString());
			System.out.println(e.getDescription());
			if(emitter != null ) {
				
				emitter.send(e.getDescription(), MediaType.TEXT_PLAIN);
			}
		}

	}
	
	@RequestMapping("/subscribeBuild")
    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ResponseBodyEmitter newBuildSubscribe(HttpServletResponse response) throws IOException {
		
		emitter = new SseEmitter(1000 *60 * 1000L);
		response.setHeader("Access-Control-Allow-Origin", "null");
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
//		ExecutorService service = Executors.newSingleThreadExecutor();
//        service.execute(() -> {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    emitter.send(LocalTime.now().toString() , MediaType.TEXT_PLAIN);
//
//                    Thread.sleep(200);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    emitter.completeWithError(e);
//                    return;
//                }
//            }
//            emitter.complete();
//        });
		
		
		
		return emitter;
		
		
		
	}

}
