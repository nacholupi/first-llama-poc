package com.nachol.llama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  private final ChatClient chatClient;

  public ClientController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @PostMapping("/chat")
  public String chat() {
    return chatClient.prompt()
        .user("Tell me a joke")
        .call().content();
  }
}
