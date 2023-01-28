package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import java.util.List;
import java.util.Objects;

public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public CursoDTO salvar(Curso curso) {

        curso = cursoRepository.save(curso);
        jmsTemplate.convertAndSend("codigo_curso+queue",curso);
        return CursoDTO.builder()
                .nome(curso.getNome())
                .codigo(curso.getCodigo())
                .build();
    }
    public List<Curso> ListarCursos(){
        return cursoRepository.findAll();
    }
    public Curso consultarPorId(int id){
        return cursoRepository.findById(id).get();
    }
    public void excluir(int id){
        cursoRepository.deleteById(id);
    }
    public Curso alterar(Curso curso){
        if (Objects.isNull(curso.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return cursoRepository.save(curso);
    }
    public List<Curso> buscarCursoLike(String nome){
        return cursoRepository.buscarCursoPorNomeLike(nome);
    }
    public Curso buscarAlunoBy(String codigo, String nome){
        return cursoRepository.findByCodigoAndNome(codigo, nome);
    }
}
