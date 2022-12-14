package pl.edu.wszib.vocabtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.edu.wszib.vocabtool.dao.VocabDao;
import pl.edu.wszib.vocabtool.model.Vocab;

import java.util.ArrayList;

@Service
public interface VocabService {

    Vocab getVocab(Long id) throws ChangeSetPersister.NotFoundException;
    Vocab selectVocab(Long id) throws ChangeSetPersister.NotFoundException;
    Vocab createVocab (Vocab newVocab);
    ArrayList<Vocab> getAllVocabs();
    Vocab updateVocab (Vocab updateVocab) throws ChangeSetPersister.NotFoundException;
    void deleteVocab (Long id);






}
