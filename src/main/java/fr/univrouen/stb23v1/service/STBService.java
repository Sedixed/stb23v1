package fr.univrouen.stb23v1.service;

import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.repository.STBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class STBService {

    @Autowired
    private STBRepository stbRepository;

    public List<STB> getAllSTB() {
        List<STB> stbs = new ArrayList<>();
        stbRepository.findAll().forEach(
                stbs::add);
        return stbs;
    }

    public void addSTB(STB stb) {
        stbRepository.save(stb);
    }
}
