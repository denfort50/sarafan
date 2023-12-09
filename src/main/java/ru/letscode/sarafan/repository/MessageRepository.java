package ru.letscode.sarafan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.letscode.sarafan.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
