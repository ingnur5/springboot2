package com.proyedatabase.prodatabase.service;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.repository.ClienteRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public Cliente gurdarCliente(Cliente cliente){
        try {
            return clienteRepository.save(cliente);
        } catch (DataAccessException e){
            throw new RuntimeException("Error al guardar el cliente");
        }

    }


    public List<Cliente> consultarCliente(){
        try {
            return clienteRepository.findAll();
        }catch (DataAccessException e){
            throw new RuntimeException("Error al consultar los clientes");
        }

    }


    public List<Cliente> consultarPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

public List<Cliente> consultardosdatos(String nom, String cor){
        return  clienteRepository.findByNombreAndCorreo(nom, cor);
}


}
