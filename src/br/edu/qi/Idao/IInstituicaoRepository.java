/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.Idao;

import br.edu.qi.model.Instituicao;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IInstituicaoRepository {
    
    void insert(Instituicao instituicao);
    void update(Instituicao instituicao);
    Instituicao select(Integer id);
    void deleteById(Integer id);
    List<Instituicao> findAll();
    
}
