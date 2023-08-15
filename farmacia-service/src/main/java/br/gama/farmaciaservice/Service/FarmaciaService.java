package br.gama.farmaciaservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gama.farmaciaservice.listeners.KafcaListeners;

@Service
public class FarmaciaService {

    @Autowired
    KafcaListeners listeners;

    public String getMensage() {
        String msg = listeners.getMessage();
        return msg;
    }
    
}
