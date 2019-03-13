package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog= new PetType();
        dog.setName("dog");
        PetType savedDogPrtType=petTypeService.save(dog);

        PetType cat= new PetType();
        dog.setName("cat");
        PetType savedCatPrtType=petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("60 Oleh Road");
        owner1.setCity("Sapele");
        owner1.setTelephone("+2348131248746");
        ownerService.save(owner1);

        Pet mikesPet= new Pet();
        mikesPet.setPetType(savedDogPrtType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPet().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glename");
        owner2.setAddress("24 Ajayi Street");
        owner2.setCity("Ogba");
        owner2.setTelephone("+2348131248746");
        ownerService.save(owner2);

        Pet fionaCat= new Pet();
        fionaCat.setName("Just Cat");
        fionaCat.setPetType(savedCatPrtType);
        fionaCat.setOwner(owner2);
        fionaCat.setBirthdate(LocalDate.now());

        owner2.getPet().add(fionaCat);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
