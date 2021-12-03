package br.com.aula.sysfuncionario.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.sysfuncionario.domain.Funcionario;
import br.com.aula.sysfuncionario.service.FuncionarioService;

@RestController
@RequestMapping("/api/v.1.0/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void gravar(@RequestBody Funcionario funcionario, HttpServletRequest request, HttpServletResponse response) {
        this.service.save(funcionario);
        response.setHeader("location", request.getRequestURI()+"/" + funcionario.getId());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Funcionario obterPorId(@PathVariable("id") Integer id) {
        return this.service.getById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Funcionario> obterTodos() {
        return this.service.getAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario) {
        this.service.update(id, funcionario);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Integer id) {
        this.service.deleteById(id);
    }
}
