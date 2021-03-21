 package tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Resposta {
    private int cod;
    private Object info;

    public Resposta(int cod, Object info) {
        this.cod = cod;
        this.info = info;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
    
    public String toString(){
        ObjectMapper mascara = new ObjectMapper();
        
        try {
            return mascara.writeValueAsString(this);
        } catch (JsonProcessingException e) {
              return "{\"cod\":500, \"info\":\"erro no Json\"}";
        }
    }
    
}