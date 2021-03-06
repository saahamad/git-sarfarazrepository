package com.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics =  new ArrayList<Topic>(Arrays.asList(			
			new Topic(1001,"Java","Java Description"),
			new Topic(1002,"Spring","Spring boot  Description")
		));	
	
	public List<Topic> getAllTopics() {		
		return topics;				
	}
	
	public Topic getTopicById(int id) {		
		return topics.stream().filter(t -> t.getTopicId() == id).findFirst().get();	
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic,int id) {
		Topic currentTopic = topics.stream().filter(t -> t.getTopicId() == id).findFirst().get();
		currentTopic.setTopicName(topic.getTopicName());
		currentTopic.setTopicDescription(topic.getTopicDescription());		
	}
	
}
