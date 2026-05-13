package com.jogo.Model;

public class Option {

    private String description;
    private String result;
    private int[]  stats = new int[5];

    /**
     * 
     * @param description_ Descrição da opção
     * @param result_ Resultado (se for selecionada)
     * @param stats_ int[]{saúde, natureza, água, população, dinheiro}
     */
    public Option(String description_, String result_, int[] stats_){
        description = description_;
        result      =      result_;
        for (int i = 0; i < 5; i++){
            stats[i] = stats_[i];
        }
    }

    public String getDesc()   { return description; }
    public String getResult() { return result;      }
    public int[]  getStats()  { return stats;       }
}
