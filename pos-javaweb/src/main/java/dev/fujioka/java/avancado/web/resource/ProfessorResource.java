package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor){
        return ResponseEntity.ok(professorRepository.save(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessores(){
        return ResponseEntity.ok(professorRepository.findAll());
    }
}
