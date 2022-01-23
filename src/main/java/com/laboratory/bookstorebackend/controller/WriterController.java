package com.laboratory.bookstorebackend.controller;

import com.laboratory.bookstorebackend.model.Writer;
import com.laboratory.bookstorebackend.model.repository.WriterRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/writer")
public class WriterController {

    private final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    /*@CrossOrigin(origins = "${react.server.path}}")
    @GetMapping("/find/all")
    public CollectionModel<Writer> findAll() {
        return CollectionModel.of(writerRepository.findAll(),linkTo(methodOn(WriterController.class).findAll()).withSelfRel());
    }*/


    /*@CrossOrigin(origins = "${react.server.path}}")
    @PostMapping("/save")
    public EntityModel<Writer> createWriter(@RequestBody Writer writer){
                return EntityModel.of(writerRepository.save(writer),linkTo(methodOn(WriterController.class).createWriter(writer))
                        .withSelfRel(), linkTo(methodOn(WriterController.class).findAll()).withRel("/find/all"));
    }*/

    @CrossOrigin(origins = "${react.server.path}}")
    @GetMapping("/find/all")
    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Writer createWriter(@RequestBody Writer writer){
        return writerRepository.save(writer);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/delete")
    public void deleteWriter(@RequestBody Writer writer){
        writerRepository.delete(writer);
    }
}
