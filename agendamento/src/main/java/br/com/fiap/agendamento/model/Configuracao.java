package br.com.fiap.agendamento.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "col_configuracoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuracao {
    @Id
    private ObjectId id;
    private String chave;
    private String valor;
}

