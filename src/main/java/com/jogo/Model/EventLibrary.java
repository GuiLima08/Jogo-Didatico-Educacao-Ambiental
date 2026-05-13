package com.jogo.Model;

public enum EventLibrary {

    /**
     * EVENTO DE EXEMPLO
     */
    TESTE(new Event(
        0,
        "teste_title",
        "test_desc",
        new Option(
            "teste_descA",
            "teste_resA",
            new int[]{-10, -10, -10, -10, -10}
        ),
        new Option(
            "teste_descB",
            "teste_resB",
            new int[]{10, 10, 10, 10, 10}
        )
    )); //TODO: Adicionar eventos

    // A variável que guarda a instância do evento
    private final Event evento;

    // Construtor do Enum
    EventLibrary(Event evento) {
        this.evento = evento;
    }

    // Retorna o objeto Event pronto para uso
    public Event getEvento() {
        return this.evento;
    }

    // Busca o evento pelo ID
    public static Event buscarPorId(int id) {
        for (EventLibrary registro : values()) {
            if (registro.getEvento().getId() == id) {
                return registro.getEvento();
            }
        }
        return null;
    }
}