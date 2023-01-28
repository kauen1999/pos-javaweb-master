package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public ProfessorDTO salvar(Professor professor) {

        professor = professorRepository.save(professor);
        jmsTemplate.convertAndSend("cod_professor+queue",professor);
        return ProfessorDTO.builder()
                .nome(professor.getNome())
                .cod(professor.getCod())
                .build();
    }
    public List<Professor> ListarProfessores(){
        return professorRepository.findAll();
    }
    public Professor consultarPorId(int id){
        return professorRepository.findById(id).get();
    }
    public void excluir(int id){
        professorRepository.deleteById(id);
    }
    public Professor alterar(Professor professor){
        if (Objects.isNull(professor.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return professorRepository.save(professor);
    }
    public List<Professor> buscarProfessorLike(String nome){
        return professorRepository.buscarProfessorPorNomeLike(nome);
    }
    public Professor buscarProfessorBy(String cod, String nome){
        return professorRepository.findByCodAndNome(cod, nome);
    }
}
