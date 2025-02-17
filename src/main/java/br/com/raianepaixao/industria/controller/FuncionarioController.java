package br.com.raianepaixao.industria.controller;

import br.com.raianepaixao.industria.model.Funcionario;
import br.com.raianepaixao.industria.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<Object> saveFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }

    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<List<Funcionario>> findAllFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAllFuncionario());
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> findFuncionarioById(@PathVariable(value = "id") Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioService.findByIdFuncionario(id);
        if(!funcionarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findByIdFuncionario(id));
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") Long id, @RequestBody Funcionario funcionario) {
        Optional<Funcionario> funcionarioOptional = funcionarioService.findByIdFuncionario(id);
        if(!funcionarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> deletFuncionario(@PathVariable(value = "id") Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioService.findByIdFuncionario(id);

        if(!funcionarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }
        funcionarioService.deletFuncionario(funcionarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso.");
    }

}
