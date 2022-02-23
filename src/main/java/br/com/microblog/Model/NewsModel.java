package br.com.microblog.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import br.com.microblog.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Validated
@NoArgsConstructor
public class NewsModel {

    @NotNull
    @NotEmpty
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("content")
    private String content;

    @NotNull
    @JsonProperty("author")
    private String author;

    @NotNull
    @JsonProperty("tags")
    private String tags;

    @OneToMany(mappedBy = "news", cascade = CascadeType.REMOVE)
    private List<Comment> comment;
}
