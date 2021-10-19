package co.tienda.generica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.tienda.generica.model.Cliente;
import co.tienda.generica.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public List<Cliente> ListaClientes() {
		
		
		
		return (List<Cliente>) clienteRepository.findAll();
	}

}
