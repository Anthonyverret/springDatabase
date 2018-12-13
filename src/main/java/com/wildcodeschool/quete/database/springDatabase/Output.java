package com.wildcodeschool.quete.database.springDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Output implements CommandLineRunner  {
	

	public Output() {
		// TODO Auto-generated constructor stub
	}
	
	private Logger LOG = LoggerFactory.getLogger("Wilder");
	
	@Autowired
    private WilderDao wildersDao;
	
	@Override
    public void run(String... args) throws Exception {
		// Checke combien d'objets se trouvent dans la BDD        
        LOG.info("|----------------------------|");
        LOG.info("Objects in DB : " + wildersDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Wilder user1 = new Wilder("Etienne", "peut faire un beau dessin");
        LOG.info("|----------------------------|");
        LOG.info(user1 + " has been created !");
        wildersDao.save(user1);
        LOG.info(user1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Wilder user2 = new Wilder("Thomas", "a une carapace et crache du feu ");
        LOG.info("|----------------------------|");
        LOG.info(user2 + " has been created !");
        wildersDao.save(user2);
        LOG.info(user2 + " has been saved !");
        
     // Crée un second utilisateur et l'enregistre dans la BDD
        Wilder user3 = new Wilder("Gaëtan", "croit en ses convictions");
        LOG.info("|----------------------------|");
        LOG.info(user3 + " has been created !");
        wildersDao.save(user3);
        LOG.info(user3 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
         /* On écrit "2L" car 
           le type de l'id est Long */
        
        Wilder readInfo = wildersDao.findById(1L).get();
        LOG.info("|----------------------------|");
        LOG.info("Le premier Wilder s'appelle " + readInfo.getFirstName());
        LOG.info("Le premier Wilder " + readInfo.getPower());
        
        
        Wilder readInfo2 = wildersDao.findById(2L).get();
        LOG.info("|----------------------------|");
        LOG.info("Le second Wilder s'appelle " + readInfo2.getFirstName());
        LOG.info("Le second Wilder " + readInfo2.getPower());
        
        
        Wilder readInfo3 = wildersDao.findById(3L).get();
        LOG.info("|----------------------------|");
        LOG.info("Le second Wilder s'appelle " + readInfo3.getFirstName());
        LOG.info("Le second Wilder a une carapace et crache du feu  " + readInfo3.getPower());
        
        

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("|----------------------------|");
        LOG.info("Users in list are ");
        for(Wilder myWilder : wildersDao.findAll()) {
            LOG.info(myWilder.toString());
        };
        
		// Supprime le second utilisateur de la BDD
        /* risque de provoquer une erreur si 
		   tu n'as pas vidé ta table avant de relancer 
		   ton application ! */
        wildersDao.deleteById(2L);
        
        user1.setFirstName("Nico");
        user1.setPower("est quand même Nico !");
        wildersDao.save(user1);
        
        Wilder readInfo4 = wildersDao.findById(1L).get();
        LOG.info("|----------------------------|");
        LOG.info("Le premier Wilder s'appelle " + readInfo4.getFirstName());
        LOG.info("Le premier Wilder " + readInfo4.getPower());
        
        
        /*     Liste les utilisateurs enregistrés dans la BDD (permet de vérifier que le second utilisateur a bien été supprimé de la BDD) */
        
        LOG.info("|----------------------------|");
        LOG.info("Wilders in list are ");
        for(Wilder myUser : wildersDao.findAll()) {
            LOG.info(myUser.toString());
        };
    }    
}

	

