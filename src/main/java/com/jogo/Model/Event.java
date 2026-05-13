package com.jogo.Model;

public class Event {

    private int    id;
    private Option optionA;
    private Option optionB;
    private String title;
    private String description;

    /**
     * 
     * @param id_ ID específico ao evento
     * @param title_ Título do evento
     * @param description_ Descrição do evento
     * @param optionA_ Opção A (esquerda); criar com new Option(...)
     * @param optionB_ Opção B (direita); criar com new Option(...)
     */
    public Event(int id_, String title_, String description_, Option optionA_, Option optionB_){
        id          = id_;
        title       = title_;
        description = description_;
        optionA     = optionA_;
        optionB     = optionB_;
    }

    public int    getId()    { return id;          }
    public String getTitle() { return title;       }
    public String getDesc()  { return description; }
    public Option getOptA()  { return optionA;     }
    public Option getOptB()  { return optionB;     }

}