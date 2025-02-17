package br.com.raianepaixao.industria.service;

import br.com.raianepaixao.industria.model.Funcionario;
import br.com.raianepaixao.industria.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAllFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findByIdFuncionario(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public void deletFuncionario(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

}
