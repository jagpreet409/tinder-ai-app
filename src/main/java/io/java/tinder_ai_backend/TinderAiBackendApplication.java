package io.java.tinder_ai_backend;

import io.java.tinder_ai_backend.conversations.ChatMessage;
import io.java.tinder_ai_backend.conversations.Conversation;
import io.java.tinder_ai_backend.conversations.ConversationRepository;
import io.java.tinder_ai_backend.profiles.Gender;
import io.java.tinder_ai_backend.profiles.Profile;
import io.java.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	public static void main(String[] args) {

		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	public void run(String[] args){
		Profile profile = new Profile("1","Jagpreet","Singh",40,
				"Indian", Gender.MALE,"Software Engineer",
				"foo.jpg", "INIP");
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);

		Conversation conversation = new Conversation("1",profile.id(), List.of( new ChatMessage("Hello", profile.id(), LocalDateTime.now())));
		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);

		System.out.println("My App is running");
	}

}
