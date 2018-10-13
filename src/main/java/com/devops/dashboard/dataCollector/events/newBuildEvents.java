package com.devops.dashboard.dataCollector.events;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.devops.dashboard.dataCollector.dataModels.implementation.Pipeline.PipelineDM;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class newBuildEvents {

	private SseEmitter emitter;

	@Component
	public class eventHandler {

		@EventListener
		@Async("asyncExecutor")
		public void handleEvent(RequestHandledEvent e) throws IOException {

			String jobName = null;
			System.out.println(e.getDescription());
			System.out.println(e.getSource());
			System.out.println(e.getShortDescription());
			System.out.println(e.toString());
			System.out.println(e.getDescription());
			String[] splitedEventDetailString = e.getDescription().split(";");
			String[] splitedURLString = splitedEventDetailString[0].split("[\\[\\]]");
			if (splitedURLString.length > 1) {
				String[] secondUrlSplit = splitedURLString[1].split("/");
				if (secondUrlSplit.length == 3 && secondUrlSplit[1].equals("getLastBuild")) {
					jobName = secondUrlSplit[2];
				}
			}

			if (emitter != null & jobName != null) {
				
				sendPipeLineData(emitter, jobName);
			} else if (emitter != null) {

				emitter.send(e.getDescription(), MediaType.TEXT_PLAIN);
			}
		}

		private void sendPipeLineData(SseEmitter emitter, String jobName) {
			boolean pipeLineFinished = false;

			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			while (!pipeLineFinished) {
				ResponseEntity<String> livePipelineDetailsString = restTemplate.getForEntity(
						"http://ec2-52-36-106-204.us-west-2.compute.amazonaws.com:8080/job/" + jobName + "/wfapi/runs",
						String.class);
				try {
					PipelineDM[] pipeline = mapper.readValue(livePipelineDetailsString.getBody(), PipelineDM[].class);
					if (!(pipeline[0].getStatus().equals("IN_PROGRESS"))) {
						pipeLineFinished = true;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
					if (livePipelineDetailsString != null) {
						String livePipelineDetailsStringBody = livePipelineDetailsString.getBody();
						StringBuilder responseBuilder = new StringBuilder();
						responseBuilder.append("{ \"ProjectName\":\""+jobName+"\",\"AllBuilds\":");
						responseBuilder.append(livePipelineDetailsStringBody);
						responseBuilder.append("}");
						if(emitter != null) {
							emitter.send(responseBuilder.toString(), MediaType.TEXT_PLAIN);							
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					emitter.complete();
					break;
				}
			}

		}

	}

	@RequestMapping("/subscribeBuild")
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ResponseBodyEmitter newBuildSubscribe(HttpServletResponse response) throws IOException {

		emitter = new SseEmitter(1000 * 60 * 1000L);
		emitter.onTimeout(() -> timeout(emitter));
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		return emitter;

	}
	public void timeout(SseEmitter emmiter) {
		emmiter.complete();
	}

}
