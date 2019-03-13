package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialitesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialitesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty objectd) {
        return super.save(objectd);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
