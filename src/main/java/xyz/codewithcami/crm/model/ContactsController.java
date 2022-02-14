package xyz.codewithcami.crm.model;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactsController
{
    final ContactRepository contactRepository;

    public ContactsController(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }

    @RequestMapping("/contacts")
    public Collection<Contact> getContacts()
    {
        return (Collection<Contact>) contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact)
    {
        Contact savedContact = contactRepository.save(contact);
        return ResponseEntity.ok(savedContact);
    }


}
