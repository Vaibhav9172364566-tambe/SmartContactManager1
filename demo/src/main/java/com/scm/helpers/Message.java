package com.scm.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    private String content;
    private MessageType type;

    public Message(String content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    public static class MessageBuilder {
        private String content;
        private MessageType type = MessageType.blue;

        public MessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder type(MessageType type) {
            this.type = type;
            return this;
        }

        public Message build() {
            return new Message(content, type);
        }
    }

    // Getters and setters

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
