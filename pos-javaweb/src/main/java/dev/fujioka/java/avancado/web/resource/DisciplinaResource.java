package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Disciplina;
import dev.fujioka.java.avancado.web.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping
    public ResponseEntity<Disciplina> salvar(@RequestBody Disciplina disciplina){
        return ResponseEntity.ok(disciplinaRepository.save(disciplina));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getDisciplinas(){
        return ResponseEntity.ok(disciplinaRepository.findAll());
    }
}
