/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.Idao;

import br.edu.qi.model.Pessoa;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IClienteRepository {
    
    
    void AlterarCliente(Pessoa pessoa);
    Pessoa select(Integer id);
    void ExcluirCliente (Integer id);
    List<Pessoa> findAll();

    public String AdcionarCliente(Pessoa pessoa);
  
}
