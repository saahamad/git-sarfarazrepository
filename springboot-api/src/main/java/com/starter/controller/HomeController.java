package com.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.service.Topic;
import com.starter.service.TopicService;

@RestController
@RequestMapping("/HomeController")
public class HomeController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/home")
	public String sayHi() {		
		return "Home.jsp";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		
		return topicService
				.getAllTopics();
	}
	@RequestMapping("/topics/{topicId}")
	public Topic getTopicById(@PathVariable("topicId") int id) {		
		return topicService.getTopicById(id);				
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics")
	public void addTopic(@RequestBody Topic topic) {		
		 topicService.addTopic(topic);				
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable int id) {		
		 topicService.updateTopic(topic, id);			
	}
}
