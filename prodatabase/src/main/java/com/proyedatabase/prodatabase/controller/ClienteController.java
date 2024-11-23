package com.proyedatabase.prodatabase.controller;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datos")
public class ClienteController {
    private  final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente){

        try {
            return clienteService.gurdarCliente(cliente);
        }catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar el cliente");
        }

    }

    @GetMapping
    public List<Cliente> consultarCliente(){
        return  clienteService.consultarCliente();

    }

    @GetMapping("/{cliente}")

    public List<Cliente> consultarClientePorNombre(@PathVariable String cliente){
         return  clienteService.consultarPorNombre(cliente);
    }

    @GetMapping("/{varios}/{correo}")
    public List<Cliente> consultarDosDatos(@PathVariable String varios,@PathVariable String correo){

        return  clienteService.consultardosdatos(varios, correo);
    }



}
