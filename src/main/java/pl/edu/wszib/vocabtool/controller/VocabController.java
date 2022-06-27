package pl.edu.wszib.vocabtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.vocabtool.model.Vocab;
import pl.edu.wszib.vocabtool.service.VocabService;

@Controller
@RequestMapping("/vocab")
public class VocabController {

    @Autowired
    VocabService vocabService;

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


        @GetMapping("/new")
        public String createView(Model model) {

            model.addAttribute("newVocab", new Vocab());
            return "create-vocab";
        }
        @PostMapping("/new")
        public String create(Vocab newVocab, Model model) {
            newVocab = vocabService.createVocab(newVocab);
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
