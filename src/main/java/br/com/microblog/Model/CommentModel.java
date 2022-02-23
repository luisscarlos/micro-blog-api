package br.com.microblog.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CommentModel {

    @JsonProperty("content")
    private String content;

    @JsonProperty("date")
    private Timestamp date;

    @JsonProperty("author")
    private String author;
    
}
