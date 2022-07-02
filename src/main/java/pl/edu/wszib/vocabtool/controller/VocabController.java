package pl.edu.wszib.vocabtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.vocabtool.service.DataLoader;
import pl.edu.wszib.vocabtool.model.Vocab;
import pl.edu.wszib.vocabtool.service.VocabService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping("/vocab")
public class VocabController {

    @Autowired
    VocabService vocabService;

    int size = 0;
    String[] japaneseWords;
    String[] koreanWords;
    String[] polishWords;
    String[] englishWords;


    public Vocab findVocab(long id) throws ChangeSetPersister.NotFoundException {
        return vocabService.getVocab(id);
    }


    @GetMapping("/get")
    public String getVocabView(@RequestParam Long id, Model model) throws ChangeSetPersister.NotFoundException {
        model.addAttribute("vocab", vocabService.getVocab(id));
        return "get-vocab";
    }


    @GetMapping("/list")
    public String getAllWordsView(Model model, Vocab vocab) throws ChangeSetPersister.NotFoundException {
        model.addAttribute("vocabs", vocabService.getAllVocabs());
        return "list-vocab";
    }

    @GetMapping("/test")
    public String testView(Model model, Vocab vocab, VocabController controller) throws ChangeSetPersister.NotFoundException {
        ArrayList<Vocab> allVocabs = vocabService.getAllVocabs();
        size = vocabService.getAllVocabs().size();

        ArrayList<String> japaneseWords = new ArrayList<String>();
        ArrayList<String> koreanWords = new ArrayList<String>();
        ArrayList<String> englishWords = new ArrayList<String>();
        ArrayList<String> polishWords = new ArrayList<String>();

//        koreanWords = new String[size];
//        koreanWords = new String[size];
//        koreanWords = new String[size];

        model.addAttribute("vocabs", vocabService.getAllVocabs());
        model.addAttribute("size", size);
        for (Vocab v : allVocabs) {
            japaneseWords.add(v.getJapanese());
            koreanWords.add(v.getKorean());
            englishWords.add(v.getEnglish());
            polishWords.add(v.getPolish());
        }
//        {
////        for (long i = 0; i < japaneseWords.length; i++) {
////            japaneseWords[(int) i] = vocabService.getVocab(i +1).getJapanese();
////            koreanWords[(int) i] = vocabService.getVocab(i + 1).getKorean();
////            englishWords[(int) i] = vocabService.getVocab(i + 1).getEnglish();
////            polishWords[(int) i] = vocabService.getVocab(i + 1).getPolish();
//
//        }
        model.addAttribute("japaneseWords", japaneseWords);
        model.addAttribute("koreanWords", koreanWords);
        model.addAttribute("englishWords", englishWords);
        model.addAttribute("polishWords", polishWords);

        return "test-vocab";
    }


        @GetMapping("/new")
        public String createView(Model model) {

            model.addAttribute("newVocab", new Vocab());
//            model.addAttribute("size", vocabService.getAllVocabs().size());
            return "create-vocab";
        }
        @PostMapping("/new")
        public String create(Vocab newVocab, Model model) throws ChangeSetPersister.NotFoundException {

            newVocab = vocabService.createVocab(newVocab);
//            size = vocabService.getAllVocabs().size();
//            System.out.println(size);
//            model.addAttribute("size", size);
//            for (long i = 0; i < japaneseWords.length; i++) {
//                japaneseWords[(int) i] = vocabService.getVocab(i +1).getJapanese();
//                koreanWords[(int) i] = vocabService.getVocab(i + 1).getKorean();
//                englishWords[(int) i] = vocabService.getVocab(i + 1).getEnglish();
//                polishWords[(int) i] = vocabService.getVocab(i + 1).getPolish();
//
//            }
//            model.addAttribute("japaneseWords", japaneseWords);
//            model.addAttribute("koreanWords", koreanWords);
//            model.addAttribute("englishWords", englishWords);
//            model.addAttribute("polishWords", polishWords);

            return "redirect:/vocab/list";

        }



        @GetMapping("/update")
        public String updateVocabView(@RequestParam Long id, Vocab vocab, Model model) throws ChangeSetPersister.NotFoundException {

            model.addAttribute("updateVocab", vocabService.getVocab(id));
            return "update-vocab";
        }

        @PostMapping("/update")
        public String updateVocab(Vocab vocab, Model model) throws ChangeSetPersister.NotFoundException {
            vocabService.updateVocab(vocab);
            return "redirect:/vocab/list";
        }


        @GetMapping("/delete")
        public String deleteVocabView(@RequestParam Long id, Model model) throws ChangeSetPersister.NotFoundException {
            model.addAttribute("vocab", vocabService.getVocab(id));
            return "delete-vocab";
        }
        @PostMapping("/delete")
        public String deleteVocab(Vocab vocab,  Model model) {
            vocabService.deleteVocab(vocab.getId());
            return "redirect:/vocab/list";
        }


}
