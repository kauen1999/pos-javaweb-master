package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Aluno;
import dev.fujioka.java.avancado.web.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }


   @GetMapping
   public ResponseEntity<List<Aluno>> getAlunos(){
        return ResponseEntity.ok(alunoRepository.findAll());
    }


}
