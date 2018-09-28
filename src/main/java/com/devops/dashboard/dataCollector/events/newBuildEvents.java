package com.devops.dashboard.dataCollector.events;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.Sleep;
import org.elasticsearch.common.regex.Regex;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.devops.dashboard.dataCollector.Constants.ServicesConstants;
import com.devops.dashboard.dataCollector.dataModels.implementation.Pipeline.PipelineDM;
import com.devops.dashboard.dataCollector.dataModels.implementation.Sonar.SonarResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class newBuildEvents {
	
	
	private SseEmitter emitter;
	
	
	@Component
	public class eventHandler {
		
		@Async
		@EventListener
		public void handleEvent (RequestHandledEvent e) throws IOException {
			
			System.out.println(e.getDescription());
			System.out.println(e.getSource());
			System.out.println(e.getShortDescription());
			System.out.println(e.toString());
			System.out.println(e.getDescription());
			int indexOf = e.getShortDescription().substring(ServicesConstants.LENGHT_OF_GETLASTBUILD_STRING).indexOf(']');
			String jobName = e.getDescription().substring(ServicesConstants.LENGHT_OF_GETLASTBUILD_STRING +1 , ServicesConstants.LENGHT_OF_GETLASTBUILD_STRING + indexOf);
			if(!jobName.isEmpty() && jobName.length() > 1 && !jobName.equals("een")) {
				sendPipeLineData(emitter , jobName);
			}
			else if(emitter != null ) {
				
				emitter.send(e.getDescription(), MediaType.TEXT_PLAIN);
			}
		}

		private void sendPipeLineData(SseEmitter emitter, String jobName) {
			boolean pipeLineFinished = false;
			
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			
			while(!pipeLineFinished) {
				ResponseEntity<String> livePipelineDetailsString = restTemplate.getForEntity("http://ec2-52-36-106-204.us-west-2.compute.amazonaws.com:8080/job/"+jobName+"/wfapi/runs",String.class);
				try {
					PipelineDM[] pipeline = mapper.readValue(livePipelineDetailsString.getBody(), PipelineDM[].class);
					if(!(pipeline[0].getStatus().equals("IN_PROGRESS")))
					{
						pipeLineFinished = true;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
					emitter.send(livePipelineDetailsString.getBody(), MediaType.TEXT_PLAIN);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}
	
	@RequestMapping("/subscribeBuild")
    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ResponseBodyEmitter newBuildSubscribe(HttpServletResponse response) throws IOException {
		
		emitter = new SseEmitter(1000 *60 * 1000L);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		return emitter;
		
		
		
	}

}
