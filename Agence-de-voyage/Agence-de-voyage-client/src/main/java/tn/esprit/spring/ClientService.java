package tn.esprit.spring;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ClientService.class);
	
	public Client addClient(Client client){
		Client clientSaved = clientRepository.save(client);
		return clientSaved;
	}
	
	public List<Client> retrieveAllClients() {
		List<Client> clients= (List<Client>) clientRepository.findAll();
		for (Client client : clients){
			l.debug("user ++++ : "+client);
		}
		return clients;
	}
	
	
	public Client updateClient(int id , Client newClient){
		if(clientRepository.findById(id).isPresent()){
			Client existingClient = clientRepository.findById(id).get();
			existingClient.setNom(newClient.getNom());
			existingClient.setPrenom(newClient.getPrenom());
			existingClient.setEmail(newClient.getEmail());
			existingClient.setTel(newClient.getTel());
			
			return clientRepository.save(existingClient);
		}
		else
			return null;
	}
	
	
	public String deleteClient(int id){
		
		if(clientRepository.findById(id).isPresent()){
			clientRepository.deleteById(id);
			return "Client supprimé";
		} else 
			return "Client non supprimé";
		}
	
}
