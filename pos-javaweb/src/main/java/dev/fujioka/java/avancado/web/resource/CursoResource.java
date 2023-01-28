package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoRepository.save(curso));
    }


    @GetMapping
    public ResponseEntity<List<Curso>> getAlunos(){
        return ResponseEntity.ok(cursoRepository.findAll());
    }
}
