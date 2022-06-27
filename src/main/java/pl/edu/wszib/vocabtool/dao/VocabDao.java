package pl.edu.wszib.vocabtool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.vocabtool.model.Vocab;

import java.util.ArrayList;

@Repository
public interface VocabDao extends JpaRepository<Vocab, Long> {


}
