package ru.letscode.sarafan.contoller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.letscode.sarafan.model.Message;
import ru.letscode.sarafan.model.Views;
import ru.letscode.sarafan.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("message")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping()
    public Message create(@RequestBody Message message) {
        return messageService.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                                      @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageService.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageService.delete(message);
    }
}
