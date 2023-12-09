package ru.letscode.sarafan.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.letscode.sarafan.model.Message;
import ru.letscode.sarafan.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository messageRepository;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public void delete(Message message) {
        messageRepository.delete(message);
    }
}
