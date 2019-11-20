/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.Idao;

import br.edu.qi.model.Refeicao;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IFoodRepository {
    
    void insert(Refeicao refeicao);
    void update(Refeicao refeicao);
    Refeicao select(Integer id);
    void deleteById(Integer id);
    List<Refeicao> findAll();
    
}
