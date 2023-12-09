package ru.letscode.sarafan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "messages")
@ToString(of = {"id", "text"})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Id.class)
    private Long id;

    @JsonView(Views.IdName.class)
    private String text;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Message message = (Message) o;
        return id != null && Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
