package pl.edu.wszib.vocabtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.edu.wszib.vocabtool.dao.VocabDao;
import pl.edu.wszib.vocabtool.model.Vocab;
import pl.edu.wszib.vocabtool.service.VocabService;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class DataLoader {

    @Autowired
    VocabService vocabService;

    public DataLoader() {

    }


//    public Vocab findVocab(long id) throws ChangeSetPersister.NotFoundException {
//        return vocabService.getVocab(id);
//    }
//
//    public long randomNbr( ) {
//        int size = vocabService.getAllVocabs().size();
//        Random random = new Random();
//        long randomNbr =  random.nextInt(1, size ) + 1;
//        System.out.println(randomNbr);
//        return randomNbr;
//    }
//












}
