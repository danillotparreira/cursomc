package br.com.danillotparreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danillotparreira.cursomc.model.Pedido;
import br.com.danillotparreira.cursomc.repositories.PedidoRepository;
import br.com.danillotparreira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    

    public Pedido findById(Integer id) {
      Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
      return pedidoOptional.orElseThrow(
        () ->
          new ObjectNotFoundException(
            "Objeto não encontrado! Id " +
            id +
            ", Tipo: " +
            Pedido.class.getSimpleName()
          )
      );
    }
    
}
