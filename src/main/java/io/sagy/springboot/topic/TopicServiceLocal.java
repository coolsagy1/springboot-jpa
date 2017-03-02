package io.sagy.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicServiceLocal {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Algorithms", "Gang of Fours"),
			new Topic("2", "DBMS", "SQL, NOSQL"),
			new Topic("3", "OOAD", "C++, Java")
			));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++){
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}
}
