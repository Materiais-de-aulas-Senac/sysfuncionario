package br.com.aula.sysfuncionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.sysfuncionario.domain.Funcionario;
import br.com.aula.sysfuncionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public void save(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public Funcionario getById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public void update(Integer id, Funcionario funcionario) {

        if(id != null && id == funcionario.getId()){
            if(repository.existsById(id))
                repository.saveAndFlush(funcionario);
        } 
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
    
}
