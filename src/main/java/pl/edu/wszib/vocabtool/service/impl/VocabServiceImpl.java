package pl.edu.wszib.vocabtool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.edu.wszib.vocabtool.dao.VocabDao;
import pl.edu.wszib.vocabtool.model.Vocab;
import pl.edu.wszib.vocabtool.service.VocabService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VocabServiceImpl implements VocabService {
    @Autowired
    private VocabDao dao;

    @Override
    public Vocab getVocab(Long id) throws ChangeSetPersister.NotFoundException {
        return dao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Vocab createVocab(Vocab newVocab) {
        return dao.save(newVocab);
    }

    @Override
    public ArrayList<Vocab> getAllVocabs() {
        ArrayList<Vocab> vocabArrayList = new ArrayList<>(dao.findAll());
        return vocabArrayList;
    }

    @Override
    public Vocab updateVocab(Vocab updateVocab) throws ChangeSetPersister.NotFoundException {
        Vocab existing = getVocab(updateVocab.getId());
        return dao.save(updateVocab);
    }

    @Override
    public void deleteVocab(Long id) {
        dao.deleteById(id);
    }
}
